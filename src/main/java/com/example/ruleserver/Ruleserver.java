package com.example.ruleserver;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;

import com.example.model.Account;
import com.example.model.AppUnit;
import com.example.model.SanctionProvider;

import static com.jsoniter.JsonIterator.*;

import spark.Request;
import spark.Response;

public class Ruleserver {

    final static SanctionProvider sp = SanctionProvider.getInstance();

    public static void main(String[] args) {
        port(8888);
        get("/", (req, res) -> "Stateless Drools Server");
        post("/execute", (req, res) -> execute(req, res), new JsonTransformer());
    }

    public static Object execute(Request req, Response res) {
        try {
            Change change = parseBody(req.body());
            AppUnit unit = getAppUnit();
            unit.setSanctions(Ruleserver.sp);

            RuleUnitInstance<AppUnit> instance = getInstance(unit);

            for (int i = 0; i < change.facts.size(); i++) {
                loadFacts(unit, change.facts.get(i));
            }

            Map<String, Object> queryResults = new HashMap<String, Object>();
            if (change.queries != null) {
                for (int i = 0; i < change.queries.size(); i++) {
                    Query q = change.queries.get(i);
                    queryResults.put(q.name, instance.executeQuery(q.name).toList(q.variable));
                }
                return queryResults;
            } else {
                return "OK";
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());

            e.printStackTrace(System.out);
            res.status(403);
            return e;
        }

    }

    static Change parseBody(String body) {
        return deserialize(body, Change.class);
    }

    static AppUnit getAppUnit() {
        return new AppUnit();
    }

    static RuleUnitInstance<AppUnit> getInstance(AppUnit unit) {
        return RuleUnitProvider.get().createRuleUnitInstance(unit);
    }

    static void loadFacts(AppUnit unit, Fact factObj) {

        switch (factObj.typeName) {
            case "Account":
                unit.getAccounts().add(new Account(factObj.attributes));
                break;
        }
    }
}
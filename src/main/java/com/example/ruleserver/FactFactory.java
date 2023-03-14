package com.example.ruleserver;

import com.example.model.Account;

public class FactFactory {

    public static Object getFactInstance(Fact fact) {
        switch (fact.typeName) {
            case "Account":
                return new Account(fact.attributes);
            default:
                return null;
        }
    }
}

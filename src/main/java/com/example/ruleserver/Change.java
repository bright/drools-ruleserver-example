package com.example.ruleserver;

import java.util.List;

public class Change {

    List<Fact> facts;

    List<Query> queries;

    public List<Fact> getFacts() {
        return facts;
    }

    public void setFacts(List<Fact> facts) {
        this.facts = facts;
    }
}

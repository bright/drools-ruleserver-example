package com.example.model;

public class Sanction {

    SanctionType sanctionType;

    String name;

    public Sanction(SanctionType sanctionType, String name) {
        this.sanctionType = sanctionType;
        this.name = name;
    }

    public SanctionType getSanctionType() {
        return sanctionType;
    }

    public String getName() {
        return name;
    }

}

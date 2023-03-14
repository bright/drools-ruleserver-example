package com.example.model;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class AppUnit implements RuleUnitData {

    private final DataStore<Account> accounts;

    private DataStore<Sanction> sanctions;

    public AppUnit() {
        this(DataSource.createStore());
    }

    public AppUnit(DataStore<Account> accounts) {
        this.accounts = accounts;
    }

    public DataStore<Account> getAccounts() {
        return accounts;
    }

    public DataStore<Sanction> getSanctions() {
        return sanctions;
    }

    public void setSanctions(DataStore<Sanction> sanctions) {
        this.sanctions = sanctions;
    }
}

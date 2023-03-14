package com.example.model;

import org.drools.ruleunits.api.DataHandle;
import org.drools.ruleunits.api.DataProcessor;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;

public class SanctionProvider implements DataStore<Sanction> {

    DataStore<Sanction> sanctions;

    private static SanctionProvider instance = new SanctionProvider();

    private SanctionProvider() {
        sanctions = DataSource.createStore();
        this.init();
    }

    private void init() {
        this.sanctions.add(new Sanction(SanctionType.CRIME, "John Snow"));
        this.sanctions.add(new Sanction(SanctionType.CRIME, "Loki"));
        this.sanctions.add(new Sanction(SanctionType.DIPLOMATIC, "Mysterio"));
    }

    public static SanctionProvider getInstance() {
        return instance;
    }

    @Override
    public void subscribe(DataProcessor<Sanction> subscriber) {
        this.sanctions.subscribe(subscriber);
    }

    @Override
    public DataHandle add(Sanction object) {
        return this.sanctions.add(object);
    }

    @Override
    public void update(DataHandle handle, Sanction object) {
        this.sanctions.update(handle, object);
    }

    @Override
    public void remove(DataHandle handle) {
        this.sanctions.remove(handle);
    }

    @Override
    public void remove(Sanction object) {
        this.sanctions.remove(object);
    }

}

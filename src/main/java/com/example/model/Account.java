package com.example.model;

import java.util.Map;

public class Account {

    String name;
    double age;
    double income;
    Education education;

    int score;

    public Account(Map<String, Object> attributes) {
        super();
        this.age = (double) attributes.get("age");
        this.name = (String) attributes.get("name");
        this.education = attributes.get("education") != null
                ? Education.valueOf((String) attributes.get("education"))
                : Education.MIDDLE;
        this.income = (double) attributes.getOrDefault("income", 0.0);
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public double getIncome() {
        return income;
    }

    public Education getEducation() {
        return education;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int add) {
        this.score += add;
    }
}

package org.example;

public enum ActionType {
    BASE_ATTACK("Базовая атака"),
    SPECIAL_SKILL("Особая способность"),
    REST("Отдых");

    private final String rusName;

    ActionType(String rusName){this.rusName = rusName;}

    public String getRusName(){return rusName;}
}

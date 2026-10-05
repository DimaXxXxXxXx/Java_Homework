package org.example;

public enum BankType {
    NEO("НеоКредит", 0.01),
    AUM("Арум Финтех",0.02),
    VTA("Вектор Альянс Банк", 0.00);

    private final String name;
    private final double percOfCommision;

    BankType(String name, double percOfCommisioncommission){
        this.name = name;
        this.percOfCommision = percOfCommisioncommission;
    }

    public String getName(){
        return name;
    }

    public double getPercOfCommisionCommission() {
        return percOfCommision;
    }
}

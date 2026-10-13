package org.example;

public class Arena {
    private final Hero fighter1;
    private final Hero fighter2;
    private int roundCounter;
    public Arena(Hero fighter1, Hero fighter2){
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }
    public String getHaveMana(Hero hero){
        if (hero instanceof Mage mage){
            return ", " + mage.getMana() + " маны";
        }
        return "";
    }
    void startTournament(){
        while (fighter1.isAlive() && fighter2.isAlive()){
            roundCounter++;
            System.out.println("Раунд " + roundCounter);
            Hero attacker;
            Hero defender;
            if (Math.random() < 0.5){
                attacker = fighter1;
                defender = fighter2;
            } else {
                attacker = fighter2;
                defender = fighter1;
            }
            ActionType action = attacker.makeTurn(defender);
            System.out.println("Игрок " + attacker.getName() + " совершил действие " + action.getRusName());
            if (defender.isAlive()){
                action = defender.makeTurn(attacker);
                System.out.println("Игрок " + defender.getName() + " совершил действие " + action.getRusName());
            } else {
                break;
            }
            System.out.println("Раунд завершён, Статус первого бойца: Здоровье - " + fighter1.getHealth() + getHaveMana(fighter1) + ". Статус второго: Здоровье - " + fighter2.getHealth() + getHaveMana(fighter2) +".");
        }
        Hero winner;
        if (fighter2.isAlive()) winner = fighter2;
        else winner = fighter1;
        System.out.println("Турнир завершён, победитель " + winner.getName());
    }
}

package org.example;

public abstract class Hero {

    final int MIN_STAT_VALUE = 1;

    private String name;
    private int maxHealth;
    private int baseAttack;
    private int health;

    public Hero(String name, int maxHealth, int baseAttack) {
        if (maxHealth < MIN_STAT_VALUE){
            throw new IllegalArgumentException("Максимальное здоровье персонажа не может быть меньше " + MIN_STAT_VALUE + ".");
        }
        if (baseAttack < MIN_STAT_VALUE){
            throw new IllegalArgumentException("Значение урона базовой атаки персонажа не может быть меньше " + MIN_STAT_VALUE + ".");
        }
        this.name = name;
        this.maxHealth = maxHealth;
        this.baseAttack = baseAttack;
        this.health = maxHealth;
    }

    public String getName() {return name;}
    public int getMaxHealth(){return maxHealth;}
    public int getBaseAttack(){return baseAttack;}
    public int getHealth(){return health;}

    public abstract void attack(Hero target);
    public abstract ActionType makeTurn(Hero target);

    public void takeDamage(int damage){
        health =  Math.max(0, health-damage);
        if (health == 0){
            System.out.println(name + " пал в бою!");
        }
    }

    public void heal(int amount){
        health = Math.max(maxHealth, health+amount);
    }

    public boolean isAlive(){
        return (health > 0);
    }
}

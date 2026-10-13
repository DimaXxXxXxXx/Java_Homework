package org.example;

public class Warrior extends Hero implements Castable, Restable {

    private static final int MIN_STAT_VALYE = 1;
    private final int armor;

    public Warrior(String name, int maxHealth, int baseAttack, int armor){

        super(name, maxHealth, baseAttack);

        if (armor < MIN_STAT_VALYE) {
            throw new IllegalArgumentException("Значение брони не может быть меньше " + MIN_STAT_VALYE + ".");
        }
        this.armor = armor;
    }
    public int getArmor(){
        return armor;
    }

    @Override
    public void takeDamage(int damage){
        int finalDamage = Math.max(1, damage-armor);
        super.takeDamage(finalDamage);
    }

    @Override
    public void attack(Hero target){
        if (target == null) return;
        System.out.println(getName() + " проводит физическую атаку по " + target.getName() + " на " + getBaseAttack() + " урона.");
        target.takeDamage(getBaseAttack());
    }

    @Override
    public ActionType makeTurn(Hero target){
        if (canCast()){
            castSpecialSkill(target);
            return ActionType.SPECIAL_SKILL;
        } else if (needsRest()){
            rest();
            return ActionType.REST;
        } else {
            attack(target);
            return ActionType.BASE_ATTACK;
        }
    }

    @Override
    public boolean canCast(){
        return (getHealth() < getMaxHealth() / 2);
    }

    @Override
    public void castSpecialSkill(Hero target){
        if (canCast()){
            int sSDamage = getBaseAttack() + armor*2;
            System.out.println(getName() + " применяет 'Удар щитом' по " + target.getName() + " и наносит " + sSDamage + " урона.");
            target.takeDamage(sSDamage);
        }
        System.out.println("Воин попытался ударить щитом, но потерял равновесие!");
        return;
    }

    @Override
    public boolean needsRest(){
        return (getHealth() < getMaxHealth()*0.15);
    }

    @Override
    public void rest(){
        System.out.println(getName() + " применяет 'Второе дыхание' и восстанавливает " + armor*2 + " единиц здоровья.");
        heal(armor*2);
    }
}

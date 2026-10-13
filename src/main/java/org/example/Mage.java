package org.example;

public class Mage extends Hero implements Castable, Restable{

    private final int maxMana;
    private int mana;

    public Mage(String name, int maxHealth, int baseAttack, int maxMana){

        super(name, maxHealth, baseAttack);

        if (maxMana < MIN_STAT_VALUE) {
            throw new IllegalArgumentException("Максимальное значение маны не может быть меньше " + MIN_STAT_VALUE + ".");
        }
        this.maxMana = maxMana;
        this.mana = maxMana;
    }
    public int getMana(){
        return mana;
    }

    @Override
    public void attack(Hero target){
        if (mana >= 10){
            int magicShotDamage = getBaseAttack()*2;
            System.out.println(getName() + " применяет 'Магический выстрел' по " + target.getName() + " на " + magicShotDamage + " урона.");
            target.takeDamage(magicShotDamage);
            mana = mana-10;
        } else {
            int staffHitDamage = getBaseAttack() / 2;
            System.out.println(getName() + " применяет 'Удар посохом' по " + target.getName() + " на " + staffHitDamage + " урона.");
            target.takeDamage(staffHitDamage);
            mana = Math.min(maxMana, mana+5);
        }
    }

    @Override
    public ActionType makeTurn (Hero target){

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
        return (mana >= 25);
    }

    @Override
    public void castSpecialSkill(Hero target){
        if (!canCast()){
            System.out.println(getName() + " попытался применить заклинание 'Огненная глыба', но оно сорвалось.");
            return;
        }
        int specialSkillDamage = getBaseAttack()*3;
        System.out.println(getName() + " применяет 'Огненную глыбу' по " + target.getName() + " и наносит " + specialSkillDamage + " урона.");
        target.takeDamage(specialSkillDamage);
        mana -= 25;
    }

    @Override
    public boolean needsRest(){
        return ((mana == 0) || (getHealth() < getMaxHealth()*0.3));
    }

    @Override
    public void rest(){
        System.out.println(getName() + " использует 'Исцеляющую медитацию', восстанавливает всю ману и " + getBaseAttack() + "здоровья.");
        mana = maxMana;
        heal(getBaseAttack());
    }
}

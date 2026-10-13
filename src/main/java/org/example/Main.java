package org.example;

import java.util.Scanner;

public class Main {

    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Создайте перовго бойца.");
        Hero hero1 = heroMaker(sc);

        System.out.println("Создайте второго бойца.");
        Hero hero2 = heroMaker(sc);

        Arena arena = new Arena(hero1, hero2);
        arena.startTournament();
    }

    public static Hero heroMaker(Scanner sc) {
        Hero hero;
        System.out.println("Выберите класс бойца (1 - воин, 2 - маг)");
        String heroClass = sc.nextLine();
        if (!((heroClass.equals("1"))||(heroClass.equals("2")))) {
            throw new IllegalArgumentException("Неверно введён класс бойца!");
        }

        System.out.println("Теперь введите имя бойца.");
        String name = sc.nextLine();
        if ((name == null) || (name.equals(""))) {
            throw new IllegalArgumentException("Имя бойца не может быть пустым!");
        }

        System.out.println("Введите здоровье бойца.");
        int maxHealth = Integer.parseInt(sc.nextLine());

        System.out.println("Введите значение урона для базовой атаки.");
        int baseAttack = Integer.parseInt(sc.nextLine());

        if (heroClass.equals("1")){
            System.out.println("Введите значение защиты для воина.");
            int armor = Integer.parseInt(sc.nextLine());
            return new Warrior(name, maxHealth, baseAttack, armor);
        }
        System.out.println("Введите значение маны для мага.");
        int maxMana = Integer.parseInt(sc.nextLine());
        return new Mage(name, maxHealth, baseAttack, maxMana);
    }
}

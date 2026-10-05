package org.example;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        Account baseacc = new Account(12345, 999, 10000.00, BankType.AUM);
        System.out.println("Здравствуйте!");
        System.out.println("Введите номер карты:");
        if (!(sc.hasNextInt())) {
            System.out.println("Ошибка авторизации, неверно введён номер карты!");
            return;
        }
        int cardnomer = sc.nextInt();
        if (cardnomer != baseacc.getCardnomer()) {
            System.out.println("Ошибка авторизации, неверный номер карты!");
            return;
        }
        if (!sc.hasNextInt()) {
            System.out.println("Ошибка авторизации, неверно введён пин-код!");
            return;
        }
        int pin_code = sc.nextInt();
        if (pin_code != baseacc.getPin_code()) {
            System.out.println("Ошибка авторизации, неверный пин-код!");
            return;
        }
        System.out.println("Введите сумму внесения");
        if (!(sc.hasNextDouble())) {
            System.out.println("Ошибка, неверно введена сумма внесения!");
            return;
        }
        double adding;
        adding = sc.nextDouble();
        CashMachine cashmachine = new CashMachine();
        System.out.println(cashmachine.deposit(baseacc.getBalance(), adding));
        System.out.println("Введите сумму снятия");
        if (!(sc.hasNextDouble())) {
            System.out.println("Ошибка, неверно введена сумма снятия!");
            return;
        }
        double withdrawal = sc.nextDouble();
        System.out.println(cashmachine.withdrawal(baseacc.getBalance(), withdrawal, baseacc.getBankType()));
    }
}

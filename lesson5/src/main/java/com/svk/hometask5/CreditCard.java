package com.svk.hometask5;

/*1. Создать класс CreditCard c полями номер счета, текущая сумма на счету.
               Добавьте метод, который позволяет начислять сумму на кредитную
       карточку.
               Добавьте метод, который позволяет снимать с карточки некоторую сумму.
       Добавьте метод, который выводит текущую информацию о карточке.
               Напишите программу, которая создает три объекта класса CreditCard у
       которых заданы номер счета и начальная сумма
       Тестовый сценарий для проверки:
       Положите деньги на первые две карточки и снимите с третьей.
       Выведите на экран текущее состояние всех трех карточек.*/
public class CreditCard {
    private int accountNumber;
    private int balance;

    public CreditCard(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void increaseAmount(int increaseSum) {
        balance = balance + increaseSum;
    }

    public void decreaseAmount(int decreaseSum) {
        balance = balance - decreaseSum;
    }

    public void showAccountInfo() {
        System.out.println("Номер счёта " + accountNumber + ", баланс счета: " + balance + "$");
    }
}

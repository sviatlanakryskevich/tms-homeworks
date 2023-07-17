package com.svk.hometask5;

public class Main {
    public static void main(String[] args) {
        CreditCard card1 = new CreditCard(5730208, 5400);
        CreditCard card2 = new CreditCard(9799897, 11354);
        CreditCard card3 = new CreditCard(2575874, 38524);
        card1.increaseAmount(4600);
        card2.increaseAmount(5630);
        card3.decreaseAmount(7300);
        card1.showAccountInfo();
        card2.showAccountInfo();
        card3.showAccountInfo();
        Computer computer1 = new Computer(157, "HP");
        computer1.showComputerInfo();
        Ram ram2 = new Ram("name", 1);
        Hdd hdd2 = new Hdd("name", 2, true);
        Computer computer2 = new Computer(278, "ASUS", ram2, hdd2);
        computer2.showComputerInfo();
    }
}

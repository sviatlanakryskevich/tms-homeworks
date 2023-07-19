package com.tms.hometask7;

public class MainApp {
    public static void main(String[] args) {
        Phone phone1 = new Phone(285761, "nokia-G234", 180);
        Phone phone2 = new Phone(578730, "samsung-A22", 200);
        Phone phone3 = new Phone(209301, "xiaomi-14", 205);
        Phone[] phones = {phone1, phone2, phone3};
        for (Phone phone : phones){
            System.out.println("Phone number: " + phone.getNumber() + ", phone model: " + phone.getModel() +
                    ", " + "phone weight: " + phone.getWeight() + ".");
        }
        phone1.receiveCall("Ivan");
        phone2.receiveCall("Anna");
        phone3.receiveCall("Alex");
        int number1 = phone1.getNumber();
        int number2 = phone2.getNumber();
        int number3 = phone3.getNumber();
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
        phone1.receiveCall("Ivan", number1);
        phone2.receiveCall("Anna", number2);
        phone3.receiveCall("Alex", number3);
        phone1.sendMessage(number1, number2, number3, 321321, 567576);
    }
}

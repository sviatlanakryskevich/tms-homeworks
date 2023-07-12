package com.svk.hometask5;

/*1. Создать класс для описания компьютера, в этом классе должны быть
        поля: стоимость, модель(строковый тип), RAM и HDD.
        Для полей RAM и HDD следует создать свои собственные классы.
        Классы для RAM и HDD должны иметь конструктор по умолчанию и
        конструктор со всеми параметрами.
        Класс RAM имеет поля "название" и "объем".
        Класс HDD имеет поля "название", "объем" и "тип" (внешний или
        внутренний).
        Класс Computer должен иметь два конструктора:
        - первый - с параметрами стоимость и модель,
        - второй - со всеми полями.
        При создании объекта "компьютер" с помощью первого конструктора
        должны создаваться поля RAM и HDD с помощью конструкторов по
        умолчанию.
        В каждом из классов предусмотреть методы для вывода полной
        информации (вывод всех полей и всех значений).
        Тестовый сценарий для проверки:
        создать объект "компьютер 1" с помощью первого конструктора и
        вывести информацию на экран;
        создать объект "компьютер 2" с помощью второго конструктора и
        вывести информацию на экран.*/
public class Computer {
    private int price;
    private String model;
    private Ram ram;
    private Hdd hdd;

    public Computer(int price, String model) {
        this.price = price;
        this.model = model;
        this.ram = new Ram();
        this.hdd = new Hdd();
    }

    public Computer(int price, String model, Ram ram, Hdd hdd) {
        this.price = price;
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
    }

    public void showComputerInfo() {
        System.out.println("Price: " + price + ", model: " + model + ", RAM: " + ram.showRamInfo() + ", HDD: " + hdd.showHddInfo());
    }
}

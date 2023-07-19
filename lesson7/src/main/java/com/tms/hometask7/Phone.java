package com.tms.hometask7;

/*      Создайте класс Phone, который содержит переменные number, model и
        weight. Создайте три экземпляра этого класса. Выведите на консоль значения их переменных.Добавить в класс Phone методы:
        receiveCall, имеет один параметр – имя звонящего. Выводит на консоль сообщение “Звонит {name}”. getNumber –
        возвращает номер телефона. Вызвать эти методы для каждого из объектов. Добавить конструктор в класс Phone,
        который принимает на вход три параметра для инициализации переменных класса - number, model и weight.
        Добавить конструктор, который принимает на вход два параметра для инициализации переменных класса - number, model.
        Добавить конструктор без параметров. Вызвать из конструктора с тремя параметрами конструктор с двумя.
        Добавьте перегруженный метод receiveCall, который принимает два параметра - имя звонящего и номер телефона звонящего.
        Вызвать этот метод. Создать метод sendMessage с аргументами переменной длины. Данный метод принимает на вход номера телефонов,
        которым будет отправлено сообщение. Метод выводит на консоль номера этих телефонов.*/
public class Phone {
    private int number;
    private String model;
    private int weight;

    public Phone() {
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(int number, String model, int weight) {
        this(number, model);
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public void receiveCall(String name){
        System.out.println("Звонит " + name);
    }
    public void receiveCall(String name, int number){
        System.out.println("Звонит " + name + ", номер телефона: " + number);
    }
    public void sendMessage(int ...numbers){
        for (int number : numbers){
            System.out.println("Message has been sent to phone number: " + number);
        }

    }
}

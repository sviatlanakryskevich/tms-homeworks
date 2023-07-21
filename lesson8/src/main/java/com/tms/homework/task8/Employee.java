package com.tms.homework.task8;

/*Создать абстрактный класс Employee для хранения сведений о сотруднике (имени, фамилии, стажа работы и долженности).
 Должность должна быть описана в enum (DIRECTOR, WORKER) и хранить в себе коэффициент заработанной платы).
 В классе Employee реализовать расчет з/п = базовая_ставка * коэффициент * стаж.
 Создать класс Worker для создания сотрудников (наследуется от Employee).Реализовать класс Director (наследуется от Employee).
 Реализовать метод для назначения сотрудников (как работника, так и директора) под его управление. Для директора
 переопределить метод расчета з/п, в котором предусмотреть влияние количества сотрудников, которые находятся в подчинении
 (непосредственном) директора.
 1) Необходимо создать 3 работника и 1 директора. Для каждого сотрудника распечатать полное имя сотрудника и его з/п.
 2) Назначить двух созданных сотрудников под управление директора. Распечатать сведения о директоре (инфо о директоре и об его подчинении).
 3) Создать нового директора с одним сотрудником (под управлением) и добавить его под управления существующего директора.
 4) Убедиться, что сведения о первом директоре теперь включают сведения о втором, который так же добавлен к нему (и т.д.).
 5) Создать сервис, который определяет есть ли у данного директора в подчинении (прямом или косвенном) сотрудник с указанным
 именем (поиск вглубь)*/
public abstract class Employee {
    private static int baseRate = 2000;
    private String firstName;
    private String secondName;
    private int seniority;
    private Position position;

    public Employee(String firstName, String secondName, int seniority, Position position) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.seniority = seniority;
        this.position = position;
    }

    public static int getBaseRate() {
        return baseRate;
    }

    public static void setBaseRate(int baseRate) {
        Employee.baseRate = baseRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public  int calculateSalary(){
        return baseRate * seniority * position.getCoefficient();
    }

    @Override
    public String toString() {
        return position.name() + ": firstName= " + getFirstName() + "; secondName= " + getSecondName() +  "; salary: " + calculateSalary();
    }
}

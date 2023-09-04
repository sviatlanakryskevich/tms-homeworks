package com.skv.hometask18.domain;

public class Student {
    private Integer id;
    private String firstName;
    private String secondName;
    private Boolean isMan;
    private City city;

    public Student(String firstName, String secondName, Boolean isMan, City city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.isMan = isMan;
        this.city = city;
    }

    public Student(Integer id, String firstName, String secondName, Boolean isMan) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isMan = isMan;
    }

    public Student(Integer id, String firstName, String secondName, Boolean isMan, City city) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isMan = isMan;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getMan() {
        return isMan;
    }

    public void setMan(Boolean man) {
        isMan = man;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", isMan=" + isMan +
                ", city=" + city +
                '}';
    }
}

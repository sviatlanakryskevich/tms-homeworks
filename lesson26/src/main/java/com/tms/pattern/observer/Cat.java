package com.tms.pattern.observer;

import lombok.Getter;

import java.util.Observable;
@Getter

public class Cat extends Observable {
    String name;
    public Cat(String name) {
        this.name = name;
    }
    public void create(){
        setChanged();
        notifyObservers(this);
    }
}

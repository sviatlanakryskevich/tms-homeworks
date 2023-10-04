package com.tms.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class PetShopService implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Cat){
            Cat cat = (Cat)arg;
            System.out.println("Buy something in the pet-shop for " + cat.getName());
        }
    }
}

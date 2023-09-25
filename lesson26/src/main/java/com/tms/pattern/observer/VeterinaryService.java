package com.tms.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class VeterinaryService implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Cat){
            Cat cat = (Cat)arg;
            System.out.println(cat.getName()+ " visit to veterinarian");
        }
    }
}

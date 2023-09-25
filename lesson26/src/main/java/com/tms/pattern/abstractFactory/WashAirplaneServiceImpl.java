package com.tms.pattern.abstractFactory;

public class WashAirplaneServiceImpl implements WashService{
    @Override
    public void wash(Vehicle vehicle) {
        System.out.println("Wash in special place");
    }
}

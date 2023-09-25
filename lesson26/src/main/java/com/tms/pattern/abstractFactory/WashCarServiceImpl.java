package com.tms.pattern.abstractFactory;

public class WashCarServiceImpl implements WashService{
    @Override
    public void wash(Vehicle vehicle) {
        System.out.println("Wash in the car wash station");
    }
}

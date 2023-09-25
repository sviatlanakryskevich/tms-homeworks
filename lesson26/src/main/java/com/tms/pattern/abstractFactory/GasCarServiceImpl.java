package com.tms.pattern.abstractFactory;

public class GasCarServiceImpl implements GasService{
    @Override
    public void gas(Vehicle vehicle) {
        System.out.println("Car gas in the petrol station");
    }
}

package com.tms.pattern.abstractFactory;

public class GasAirplaneServiceImpl implements GasService{
    @Override
    public void gas(Vehicle vehicle) {
        System.out.println("Gas special fuel");
    }
}

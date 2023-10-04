package com.tms.pattern.abstractFactory;

public class MoveAirplaneServiceImpl implements MoveService{
    @Override
    public void move(Vehicle vehicle) {
        System.out.println("Airplane fly");
    }
}

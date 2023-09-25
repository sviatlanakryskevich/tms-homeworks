package com.tms.pattern.abstractFactory;

public class MoveCarServiceImpl implements MoveService{
    @Override
    public void move(Vehicle vehicle) {
        System.out.println("Move to the road");
    }
}

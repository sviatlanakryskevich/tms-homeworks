package com.tms.pattern.abstractFactory;

public class VehicleProcess {
    public void doAll(Vehicle vehicle, VehicleAbstractFactory factory){
        factory.moveService().move(vehicle);
        factory.washService().wash(vehicle);
        factory.gasService().gas(vehicle);
    }
}

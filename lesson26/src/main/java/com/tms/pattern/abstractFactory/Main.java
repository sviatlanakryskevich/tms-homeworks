package com.tms.pattern.abstractFactory;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Vehicle();
        Vehicle airplane = new Vehicle();
        VehicleProcess process = new VehicleProcess();
        process.doAll(car, new VehicleCarAbstractFactory());
        process.doAll(airplane, new VehicleAirplaneAbstractFactory());
    }

}

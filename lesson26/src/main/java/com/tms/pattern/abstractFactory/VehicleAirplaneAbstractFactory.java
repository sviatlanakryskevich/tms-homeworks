package com.tms.pattern.abstractFactory;

public class VehicleAirplaneAbstractFactory implements VehicleAbstractFactory{
    @Override
    public MoveService moveService() {
        return new MoveAirplaneServiceImpl();
    }

    @Override
    public WashService washService() {
        return new WashAirplaneServiceImpl();
    }

    @Override
    public GasService gasService() {
        return new GasAirplaneServiceImpl();
    }
}

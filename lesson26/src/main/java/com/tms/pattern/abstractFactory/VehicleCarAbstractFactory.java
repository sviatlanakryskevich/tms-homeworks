package com.tms.pattern.abstractFactory;

public class VehicleCarAbstractFactory implements VehicleAbstractFactory{
    @Override
    public MoveService moveService() {
        return new MoveCarServiceImpl();
    }

    @Override
    public WashService washService() {
        return new WashCarServiceImpl();
    }

    @Override
    public GasService gasService() {
        return new GasCarServiceImpl();
    }
}

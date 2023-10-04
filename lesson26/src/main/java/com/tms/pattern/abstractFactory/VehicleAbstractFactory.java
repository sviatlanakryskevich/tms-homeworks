package com.tms.pattern.abstractFactory;

public interface VehicleAbstractFactory {
    MoveService moveService();
    WashService washService();
    GasService gasService();
}

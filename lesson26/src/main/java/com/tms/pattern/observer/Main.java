package com.tms.pattern.observer;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Cat martin = new Cat("Martin");
        VeterinaryService veterinaryService = new VeterinaryService();
        GroomingService groomingService = new GroomingService();
        PetShopService petShopService = new PetShopService();
        martin.addObserver(veterinaryService);
        martin.addObserver(groomingService);
        martin.addObserver(petShopService);
        martin.create();
    }
}

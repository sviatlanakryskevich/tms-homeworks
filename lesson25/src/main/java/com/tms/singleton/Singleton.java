package com.tms.singleton;

public class Singleton {
    private static Singleton INSTANCE;
    private Singleton() {
        System.out.println("Singleton");
    }
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}

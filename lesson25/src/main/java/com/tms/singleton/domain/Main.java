package com.tms.singleton.domain;

import com.tms.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);
    }
}

package com.tms.pattern.decorater;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new LogDataReader(new BufferDataReader(new RandomDataReader()));
        for (int i = 0; i < 20; i++) {
            System.out.println(dataReader.read());
        }
    }
}

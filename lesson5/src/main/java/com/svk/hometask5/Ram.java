package com.svk.hometask5;

public class Ram {
    private String name;
    private int volume;

    public Ram(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public Ram() {
    }

    public String showRamInfo(){
        return "Name: " + name + ", volume: " + volume;
    }

}

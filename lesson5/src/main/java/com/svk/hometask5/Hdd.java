package com.svk.hometask5;

public class Hdd {
    private String name;
    private int volume;
    private boolean isExternal;

    public Hdd() {
    }

    public Hdd(String name, int volume, boolean isExternal) {
        this.name = name;
        this.volume = volume;
        this.isExternal = isExternal;
    }
    public String showHddInfo(){
        return "Name: " + name + ", volume: " + volume + ", is external: " + isExternal;
    }
}

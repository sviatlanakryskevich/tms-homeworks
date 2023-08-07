package com.ksv.tms.hw11;

public class MainApp {
    public static void main(String[] args) {
        OwnArrayList<String> ownArrayList = new OwnArrayList<>(2);
        ownArrayList.addElement("1");
        ownArrayList.addElement("2");
        ownArrayList.addElement("3");
        ownArrayList.addElement(null);
        System.out.println(ownArrayList.toString());
        ownArrayList.removeElement(1);
        System.out.println(ownArrayList.toString());
        ownArrayList.removeElement(5);
        System.out.println(ownArrayList.toString());
        /*ownArrayList.removeElement(10);
        System.out.println(ownArrayList.toString());
        String res = ownArrayList.getElementByIndex(10);
        System.out.println(res);*/
        System.out.println(ownArrayList.containElement("6"));
        System.out.println(ownArrayList.containElement(null));
        ownArrayList.clearArray();
        System.out.println(ownArrayList.toString());
    }
}

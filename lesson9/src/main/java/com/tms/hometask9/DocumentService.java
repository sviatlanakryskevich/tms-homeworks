package com.tms.hometask9;

public class DocumentService {
    public static void showNumbers(String text) {
        System.out.println(text.substring(0, 4) + text.substring(9, 13));
    }

    public static void replaceLetters(String text) {
        System.out.println(text.replaceAll("\\-[a-zA-Z]{3}\\-", "-***-"));
    }

    public static void showLowerLetters(String text) {
        System.out.println((text.substring(5, 8) + "/" + text.substring(14, 17) + "/"
                + text.substring(19, 20) + "/" + text.substring(21, 22)).toLowerCase());

    }

    public static void showUpperLetters(String text) {
        StringBuilder builder = new StringBuilder();
        builder.append(text, 5, 8);
        builder.append("/");
        builder.append(text, 14, 17);
        builder.append("/");
        builder.append(text.charAt(19));
        builder.append("/");
        builder.append(text.charAt(21));
        System.out.println("Letters: "+ builder.toString().toUpperCase());
    }

    public static void findMatch(String text, String substring) {
        System.out.println(text.toLowerCase().contains(substring.toLowerCase()));
    }

    public static void checkStartMatch(String text, String substring) {
        System.out.println(text.startsWith(substring));
    }

    public static void checkEndMatch(String text, String substring) {
        System.out.println(text.endsWith(substring));
    }

}

package com.tms.lesson50unit_tests.service;

public class StringService {
    public int findSubstring(String main, String substring){
        return main.toLowerCase().indexOf(substring.toLowerCase());
    }
}

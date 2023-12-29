package com.tms.lesson50unit_tests.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringServiceTest {
    @Test
    public void testFindSubstring(){
//        Given
        StringService stringService = new StringService();
        String main = "Hello world!";
        String substring = "world";
//        When
        int result = stringService.findSubstring(main, substring);
//        Then
        Assertions.assertEquals(6, result);
    }
    @Test
    public void testFindWithDiffCasesSubstring(){
//        Given
        StringService stringService = new StringService();
        String main = "heLLo WoRld!";
        String substring = "wOrLD";
//        When
        int result = stringService.findSubstring(main, substring);
//        Then
        Assertions.assertEquals(6, result);
    }
    @Test
    public void testNotFoundSubstring(){
//        Given
        StringService stringService = new StringService();
        String main = "Hello world!";
        String substring = "people";
//        When
        int result = stringService.findSubstring(main, substring);
//        Then
        Assertions.assertEquals(-1, result);
    }
}

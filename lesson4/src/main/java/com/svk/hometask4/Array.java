package com.svk.hometask4;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        /*0. Создайте массив целых чисел. Напишете программу, которая выводит сообщение о том, входит ли заданное число в массив
        или нет.*/

        findNumber();

        /*1. Создайте массив целых чисел. Удалите все вхождения заданного
        числа из массива. Пусть число задается с консоли (класс Scanner). Если такого числа нет - выведите сообщения об этом.
        В результате должен быть новый массив без указанного числа./*
         */

        createNewArray();

        //2. Создайте и заполните массив случайным числами и выведете максимальное, минимальное и среднее значение.

        calculateMinMaxAvg();


        /*3. Создайте 2 массива из 5 чисел. Выведите массивы на консоль в двух отдельных строках. Посчитайте среднее
        арифметическое элементов каждого массива и сообщите, для какого из массивов это значение оказалось больше
        (либо сообщите, что их средние арифметические равны).
         */

        compareAvgArrays();
    }

    private static void createNewArray() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numbers = {2, 5, 9, 15, 24, 2};
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Такого числа нет в массиве");
        } else {
            int[] newArr = new int[numbers.length - count];

            int shift = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] != num) {
                    newArr[i - shift] = numbers[i];
                } else {
                    shift++;
                }
            }
            System.out.println(Arrays.toString(newArr));
        }

    }

    private static void findNumber() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numbers = {2, 5, 9, 15, 24};
        boolean isExist = false;
        for (int el : numbers) {
            if (el == num) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Число не входит в массив");
        } else {
            System.out.println("Число входит в массив");
        }
    }

    private static void calculateMinMaxAvg() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        double[] numbers = new double[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random();
            System.out.println(numbers[i]);
        }
        double max = numbers[0];
        double min = numbers[0];
        double avg = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i])
                max = numbers[i];
            if (min > numbers[i])
                min = numbers[i];
            avg += numbers[i] / numbers.length;
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + avg);
    }

    public static void compareAvgArrays() {
        int[] arr1 = {2, 5, 9, 43, 56};
        int[] arr2 = {5, 7, 28, 53, 192};
        String str1 = Arrays.toString(arr1);
        String str2 = Arrays.toString(arr2);
        System.out.println(str1);
        System.out.println(str2);
        int avg1 = 0;
        int avg2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            avg1 += arr1[i] / arr1.length;
        }
        for (int i = 0; i < arr2.length; i++) {
            avg2 += arr2[i] / arr2.length;
        }
        if (avg1 > avg2) {
            System.out.println("Средняя арифметическая первого массива больше");
        } else if (avg1 < avg2) {
            System.out.println("Средняя арифметическая второго массива больше");
        } else {
            System.out.println("Средние арифметические равны");
        }
    }
}


package com.skv.tms.hometask13_14.part1;

import java.util.*;
import java.util.stream.Stream;

/*1. Создать коллекцию класса ArrayList наполнить ее элементами  рандомными элементами типа Integer. С помощью Stream'ов:
- Удалить дубликаты - Вывести все четные элементы в диапазоне от 7 до 17 (включительно) - Каждый элемент умножить на 2
- Отсортировать и вывести на экран первых 4 элемента - Вывести количество элементов в стриме
- Вывести среднее арифметическое всех чисел в стриме*/
public class IntegerList {
    public static void main(String[] args) {
        int size = 20;
        List<Integer> integers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            integers.add(new Random().nextInt(20));
        }

        integers.stream()
                .distinct()
                .forEach(System.out::println);

        integers.stream()
                .filter(integer -> integer > 7)
                .filter(integer -> integer <= 17)
                .filter(integer -> integer % 2 == 0)
                .forEach(System.out::println);

        integers.stream()
                .map(integer -> integer * 2)
                .forEach(System.out::println);

        integers.stream()
                .sorted()
                .limit(4)
                .forEach(System.out::println);

        long count = integers.stream()
                .count();
        System.out.println(count);

        OptionalDouble average = integers.stream()
                .mapToInt(integer -> integer)
                .average();
        System.out.println(average.orElse(0));
    }

}

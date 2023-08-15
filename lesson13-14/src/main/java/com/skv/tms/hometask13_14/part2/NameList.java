package com.skv.tms.hometask13_14.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*2. Создать коллекцию класса ArrayList со значениями имен всех студентов в группе. С помощью Stream'ов:
- Вернуть количество количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
- Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
- Отсортировать и вернуть первый элемент коллекции или "Empty@, если коллекция пуста*/
public class NameList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(10);
        names.add("Sveta");
        names.add("Anna");
        names.add("Ivan");
        names.add("Alex");
        names.add("sveta");
        names.add("Yana");
        names.add("SASHA");
        names.add("anna");
        names.add("Dasha");
        names.add("SVETA");

        long repeatMyName = names.stream()
                .filter(name -> name.equalsIgnoreCase("sveta"))
                .count();
        System.out.println(repeatMyName);

        names.stream()
                /*.map(String::toLowerCase)*/
                .filter(name -> name.startsWith("a") || name.startsWith("A"))
                .forEach(System.out::println);

        Optional<String> first = names.stream()
                .sorted()
                .findFirst();
        System.out.println(first.orElse("Empty"));
    }
}

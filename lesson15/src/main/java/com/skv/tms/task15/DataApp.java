package com.skv.tms.task15;


import java.io.Console;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*1. Написать программу для вывода на консоль названия дня недели по введенной дате.
 2. Написать программу для вывода на экран дату следующего вторника.*/
public class DataApp {
    public static void main(String[] args) throws ParseException {
        /*Дату прошу вводить в консоли только в таком формате: dd/MM/yyyy*/

        Scanner dateScanner = new Scanner(System.in);
        String someDate = dateScanner.nextLine();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format.parse(someDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.US);
        String dayOfWeek = dateFormat.format(date);
        System.out.println(dayOfWeek);

        LocalDate now = LocalDate.now();
        DayOfWeek dayOfWeek1 = now.getDayOfWeek();
        LocalDate nextTuesday = switch (dayOfWeek1){
            case MONDAY:
                yield now.plusDays(8);
            case TUESDAY:
                yield now.plusDays(7);
            case WEDNESDAY:
                yield now.plusDays(6);
            case THURSDAY:
                yield now.plusDays(5);
            case FRIDAY:
                yield now.plusDays(4);
            case SATURDAY:
                yield now.plusDays(3);
            case SUNDAY:
                yield now.plusDays(2);
        };

        System.out.println(nextTuesday.getDayOfMonth());
    }

}

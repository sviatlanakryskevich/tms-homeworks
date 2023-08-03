package com.tms.task10;

import java.io.*;
import java.util.Scanner;

/*
1. Допустим есть txt файл с номерами документов. Номером документа является строка, состоящая из букв и цифр(без служебных символов).
Пусть этот файл содержит каждый номер документа с новой строки и в строке никакой другой информации, только номер документа.
Валидный номер документа должен иметь длину 15 символов иначинаться с последовательности docnum(далее любая последовательность букв/цифр)
или contract(далее любая последовательность букв/цифр). Написать программу для чтения информации из входного файла - путь к
входному файлу должен задаваться через консоль. Программа должна проверять номера документов на валидность.
2. Улучшить предыдущее задание. А именно: Валидные номера документов следует записать в один файл-отчет.Невалидные номера документов
следует записать в другой файл-отчет, но после номеров документов следует добавить информацию о том, почему этот документ невалиден.*/
public class FileService {
    public static void main(String[] args) {

        //String fileName = "D:/sviatlana/hometask10.txt";

        try (Scanner scanner = new Scanner(System.in);
             LineNumberReader reader = new LineNumberReader(new FileReader(scanner.nextLine()));
             Writer writerR = new FileWriter("D:/sviatlana/hometask10right.txt");
             Writer writerW = new FileWriter("D:/sviatlana/hometask10wrong.txt")) {
            String s = reader.readLine();

            while (s != null) {
                if (s.length() == 15 && (s.startsWith("docnum") || s.startsWith("contract"))) {
                    writerR.write(s);
                    writerR.write("\n");
                } else if (s.length() < 15) {
                    writerW.write(s);
                    writerW.write(" - Message: String length < 15 symbols.\n");
                } else if (s.length() > 15) {
                    writerW.write(s);
                    writerW.write(" - Message: String length > 15 symbols.\n");
                } else if (!s.startsWith("docnum") || !s.startsWith("contract")) {
                    writerW.write(s);
                    writerW.write(" - Message: String don't starts with docnum or contract.\n");
                }
                System.out.println(s);
                s = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}

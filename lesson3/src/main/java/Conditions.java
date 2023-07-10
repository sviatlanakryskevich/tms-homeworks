import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        //1. Написать программу для вывода названия поры года по номеру месяца.
        Scanner seasonScanner = new Scanner(System.in);
        int season = seasonScanner.nextInt();
        switch (season){
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Incorrect information");
        }

//        2. Написать программу для вывода названия поры года по номеру месяца.
        Scanner monthScanner = new Scanner(System.in);
        int month = monthScanner.nextInt();
        if((month == 12) ||(month == 1) || (month == 2)){
            System.out.println("Winter");
        } else if((month == 3) ||(month == 4) || (month == 5)){
            System.out.println("Spring");
        } else if((month == 6) ||(month == 7) || (month == 8)){
            System.out.println("Summer");
        } else if((month == 9) ||(month == 10) || (month == 11)){
            System.out.println("Autumn");
        } else{
            System.out.println("Incorrect information");
        }

//        3. Напишите программу, которая будет принимать на вход число и на выход будет выводить сообщение четное число или нет.
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if((num % 2) == 0){
            System.out.println("Четное число " + num);
        } else {
            System.out.println("Нечетное число " + num);
        }

//        4. Для введенного числа t (температура на улице) вывести
//        Если t>–5, то вывести «Тепло».
//        Если –5>= t > –20, то вывести «Нормально».
//        Если –20>= t, то вывести «Холодно».
        Scanner tempScanner = new Scanner(System.in);
        int temp = tempScanner.nextInt();
        if(temp > -5){
            System.out.println("Тепло");
        } else if((temp > -20) && (temp <= -5)) {
            System.out.println("Нормально");
        } else if(temp <= -20){
            System.out.println("Холодно");
        }

    }
}

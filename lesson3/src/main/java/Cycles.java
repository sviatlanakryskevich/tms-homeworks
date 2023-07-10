import java.util.Scanner;

public class Cycles {
    public static void main(String[] args) {

//        1. При помощи цикла for вывести на экран нечетные числа от 1 до 99.
        for (int i = 0; i < 100; i++) {
            if((i % 2) == 0){
                continue;
            }
            System.out.println(i);
        }
//        2. Необходимо вывести на экран числа от 5 до 1.
        for (int i = 5; i > 0 ; i--) {
            System.out.println(i);
        }
//        3. Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует все числа от 1 до
//        введенного пользователем числа.
        Scanner numScanner = new Scanner(System.in);
        int num = numScanner.nextInt();
        int result = 0;
        for (int i = 1; i < num; i++) {
            result = result + i;
        }
        System.out.println(result);
    }
}

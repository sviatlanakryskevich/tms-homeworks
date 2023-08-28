package com.tms.task16;

/*Создать три потока Т1, Т2 и Т3. Реализовать выполнение поток в последовательности Т3 -> Т2 -> Т1 (используя метод join)*/
public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread1 = new MyThread1();
        Thread myThread2 = new Thread(new MyThread2());
        Thread myThread3 = new Thread(() -> System.out.println("thread3"));
        myThread3.start();
        myThread3.join();
        myThread2.start();
        myThread2.join();
        myThread1.start();
        myThread1.join();

    }
}

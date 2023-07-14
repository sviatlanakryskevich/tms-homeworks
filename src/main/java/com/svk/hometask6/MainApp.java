package com.svk.hometask6;

public class MainApp {
    public static void main(String[] args) {
        Figure triangle1 = new Triangle(5, 3, 2);
        Figure triangle2 = new Triangle(8, 6, 5);
        Figure rectangle1 = new Rectangle(10, 8);
        Figure rectangle2 = new Rectangle(13,9);
        Figure circle1 = new Circle(5);

        Figure[] figures = {triangle1, triangle2, rectangle1, rectangle2, circle1};

        double sumPerimeters = 0;
        for (int i = 0; i < figures.length; i++) {
            double perimeter = figures[i].calculatePerimeter();
            sumPerimeters = sumPerimeters + perimeter;
        }
        System.out.println(sumPerimeters);

        Position pos1 = new Director();
        Position pos2 = new Worker();
        Position pos3 = new Accountant();
        Position[] position = {pos1, pos2, pos3};
        for (int i = 0; i < position.length; i++) {
            position[i].showPosition();
        }

    }
}

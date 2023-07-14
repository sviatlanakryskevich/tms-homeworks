package com.svk.hometask6;

public class Circle  implements Figure{
    private double radius;
    private final double Pi = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double calculateArea() {
        return (Pi * radius * radius);
    }

    @Override
    public double calculatePerimeter() {
        return (2 * Pi * radius);
    }
}

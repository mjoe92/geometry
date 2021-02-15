package com.codecool.geometry.shapes;

public class Rectangle extends Shape {

    private double side1, side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double calculateArea() {
        return (side1 * side2);
    }

    @Override
    public double calculatePerimeter() {
        return (2 * (side1 + side2));
    }

    @Override
    public String toString() {
        String represent = getClass().getSimpleName() +
                ", a = " + side1 +
                ", b = " + side2;
        return represent;
    }
}

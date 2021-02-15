package com.codecool.geometry.shapes;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return (radius * radius * Math.PI);
    }

    @Override
    public double calculatePerimeter() {
        return (2 * radius * Math.PI);
    }

    @Override
    public String toString() {
        String represent = getClass().getSimpleName() +
                ", r = " + radius;
        return represent;
    }
}

package com.codecool.geometry.shapes;

public class RegularPentagon extends Shape {

    private double side1;

    public RegularPentagon(double side1) {
        this.side1 = side1;
    }

    @Override
    public double calculateArea() {
        return (Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) / 4 * Math.pow(side1, 2));
    }

    @Override
    public double calculatePerimeter() {
        return (5 * side1);
    }

    @Override
    public String toString() {
        String represent = getClass().getSimpleName() +
                ", a = " + side1;
        return represent;
    }
}

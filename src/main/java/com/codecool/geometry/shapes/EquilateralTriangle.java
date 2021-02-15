package com.codecool.geometry.shapes;

public class EquilateralTriangle extends Triangle {

    private double side1;

    public EquilateralTriangle(double side1) {

        super(side1, side1, side1);
        this.side1 = side1;

    }
    @Override
    public String toString() {
        String represent = "Equilateral Triangle" +
                ", a = " + side1;
        return represent;
    }
}

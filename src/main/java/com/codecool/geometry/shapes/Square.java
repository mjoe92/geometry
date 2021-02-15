package com.codecool.geometry.shapes;

public class Square extends Rectangle {

    private double side1;

    public Square(double side1) {
        super(side1, side1);
        this.side1 = side1;

    }
    @Override
    public String toString() {
        String represent = getClass().getSimpleName() +
                ", a = " + side1;
        return represent;
    }

}

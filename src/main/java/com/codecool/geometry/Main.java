package com.codecool.geometry;

import com.codecool.geometry.containers.ShapeCollection;
import com.codecool.geometry.shapes.*;
import com.codecool.geometry.utilities.FormulaProvider;

import java.util.Scanner;

public class Main {

    private static ShapeCollection shapes = new ShapeCollection();

    public static void main(String[] args) {


        boolean isRunning = true;

        //test
        Shape cir = new Circle(4);
        Shape tri = new Triangle(2,3,50);
        Shape eTri = new EquilateralTriangle(3);
        Shape rect = new Rectangle(2, 400);
        Shape squ = new Square(2);
        Shape pent = new RegularPentagon(4);
        shapes.addShape(cir);
        shapes.addShape(tri);
        shapes.addShape(eTri);
        shapes.addShape(rect);
        shapes.addShape(squ);
        shapes.addShape(cir);
        shapes.addShape(tri);
        shapes.addShape(eTri);
        shapes.addShape(rect);
        shapes.addShape(squ);
        shapes.addShape(pent);
        shapes.addShape(cir);
        shapes.addShape(tri);
        shapes.addShape(eTri);
        shapes.addShape(rect);
        shapes.addShape(squ);
        shapes.addShape(pent);

	    while (isRunning) {

            // TODO read the keyboard here
            int option = messageWithScannerInInt(true, mainMenu().toString());

            switch (option) {
                case 1:
                    // TODO Add new shape
                    int shapeOption = messageWithScannerInInt(true, showShapes().toString());
                    shapes.addShape(calcShapeDisplay(shapeOption));
                    break;
                case 2:
                    // TODO Show all shapes
                    shapes.getShapesTable();
                    break;
                case 3:
                    // TODO Show shape with the largest perimeter
                    System.out.println(shapes.getLargestShapeByPerimeter());
                    break;
                case 4:
                    // TODO Show shape with the largest area
                    System.out.println(shapes.getLargestShapeByArea());
                    break;
                case 5:
                    // TODO Show formulas
                    messageWithScannerInInt(false, showFormulas());
                    break;
                case 0:
                    // TODO Exit
                    System.exit(0);
                    break;
            }
        }
    }

    private static StringBuilder mainMenu() {

        StringBuilder show = new StringBuilder("\nMain menu (choose an option):\n");
        show.append("\n1: Add new shape");
        show.append("\n2: Show all shapes");
        show.append("\n3: Show shape with the largest perimeter");
        show.append("\n4: Show shape with the largest area");
        show.append("\n5: Show formulas");
        show.append("\n0: Exit from program");
        show.append("\n\nInput:");
        return show;

    }

    private static StringBuilder showShapes() {

        StringBuilder show = new StringBuilder("Please, choose shape:");
        show.append("\n1: Circle");
        show.append("\n2: Triangle");
        show.append("\n3: Equilateral Triangle");
        show.append("\n4: Rectangle");
        show.append("\n5: Square");
        show.append("\n6: Regular Polygon");
        show.append("\n\nInput:");
        return show;

    }

    private static double messageWithScannerInDouble(boolean inputTrigger,String message) {
        System.out.println(message);
        if (inputTrigger) {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextDouble();
        }
        return -1;
    }
    private static int messageWithScannerInInt(boolean inputTrigger, String message) {
        System.out.println(message);
        if (inputTrigger) {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }
        return -1;
    }

    private static Shape calcShapeDisplay(int numberOfShape) {

        Shape shape = null;
        String chosenShape = null;
        String[] shapes = {
                "Circle",
                "Triangle",
                "Equilateral Triangle",
                "Rectangle",
                "Square",
                "Regular Pentagon"
        };

        StringBuilder plotTextArea = new StringBuilder(" calculated area: ");
        StringBuilder plotTextPerimeter = new StringBuilder(" calculated perimeter: ");
        switch (numberOfShape) {
            case 1:
                double radius = messageWithScannerInDouble(true,"Radius:");
                shape = new Circle(radius);
                chosenShape = shapes[0];
                break;
            case 2:
                double adjacent = messageWithScannerInDouble(true,"Adjacent:");
                double leftLeg = messageWithScannerInDouble(true,"Left side:");
                double rightLeg = messageWithScannerInDouble(true,"Right side:");
                shape = new Triangle(adjacent, leftLeg, rightLeg);
                chosenShape = shapes[1];
                break;
            case 3:
                double side = messageWithScannerInDouble(true,"Side:");
                shape = new EquilateralTriangle(side);
                chosenShape = shapes[2];
                break;
            case 4:
                double length = messageWithScannerInDouble(true,"Length:");
                double height = messageWithScannerInDouble(true,"Height:");
                shape = new Rectangle(length, height);
                chosenShape = shapes[3];
                break;
            case 5:
                double base = messageWithScannerInDouble(true,"Base:");
                shape = new Square(base);
                chosenShape = shapes[4];
                break;
            case 6:
                side = messageWithScannerInDouble(true,"Side:");
                shape = new RegularPentagon(side);
                chosenShape = shapes[5];
                break;
        }
        if (0 < numberOfShape && numberOfShape < 7) {
            System.out.println(chosenShape + plotTextArea + shape.calculateArea());
            System.out.println(chosenShape + plotTextPerimeter + shape.calculatePerimeter());
        } else {
            System.out.println("Nope, number is out of range! Try again, please!");
        }
        return shape;

    }

    private static String showFormulas() {

        String show = "\n(A: area, P: perimeter)\n";
        String[] shapeNames = new String[]{
                "Circle",
                "Triangle",
                "EquilateralTriangle",
                "Rectangle",
                "Square",
                "RegularPentagon"
        };

        for (int i = 0; i < shapeNames.length; i++) {

            String name = shapeNames[i];
            if (i == 2) {
                name = "Equilateral Triangle";
            } else if (i == 5) {
                name = "Regular Pentagon";
            }
            show += "\n" + name +
                    ": A = " + FormulaProvider.getAreaForShape(shapeNames[i]) +
                    ", P = " + FormulaProvider.getPerimeterForShape(shapeNames[i]);
        }
        show += "\n";
        return show;
    }

}

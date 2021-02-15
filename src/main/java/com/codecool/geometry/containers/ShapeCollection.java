package com.codecool.geometry.containers;

import com.codecool.geometry.shapes.Shape;
import com.codecool.geometry.utilities.FormulaProvider;

import java.util.ArrayList;
import java.util.Collections;

public class ShapeCollection {

    private static int count = 0;
    private ArrayList<String> shapeList = new ArrayList<>();
    private ArrayList<Double> areaList = new ArrayList<>();
    private ArrayList<Double> perimeterList = new ArrayList<>();
    private int[] maxDiffOfSeparators;

    public ShapeCollection() {
        shapeList.add("ID | Class | toString | Perimeter | Formula | Area | Formula");
        maxDiffOfSeparators = new int[]{3, 7, 10, 11, 9, 6, 7};
    }

    public void addShape(Shape shape) {

        double area = Math.round(shape.calculateArea() * 100.00) / 100.00;
        double perimeter = Math.round(shape.calculatePerimeter() * 100.00) / 100.00;
        areaList.add(area);
        perimeterList.add(perimeter);
        String nameOfShape = shape.getClass().getSimpleName();

        shapeList.add(count + " | " + nameOfShape
                + " | " + shape + " | " + perimeter
                + " | " + FormulaProvider.getPerimeterForShape(nameOfShape)
                + " | " + area
                + " | " + FormulaProvider.getAreaForShape(nameOfShape));
        count++;
        calcSpacesForShapeList();
        shapeListWithEqualCol();
    }

    public void shapeListWithEqualCol() {

        StringBuilder[] rowInSb = new StringBuilder[shapeList.size()];
        for (int k = 0; k < shapeList.size(); k++) {

            int j = shapeList.get(k).indexOf("|");
            rowInSb[k] = new StringBuilder("");
            rowInSb[k].append(shapeList.get(k));
            String[] spaces = new String[7];
            for (int i = 0; i < 7; i++) {

                int diffOfSeparators = rowInSb[k].indexOf("|", j + 1) - j;
                if (i == 0) {
                    diffOfSeparators = j;
                } else if (i == 6) {
                    diffOfSeparators = rowInSb[k].length() - j;
                }

                int diff = maxDiffOfSeparators[i] - diffOfSeparators;
                spaces[i] = "";
                for (int m = 0; m < diff; m++) {
                    spaces[i] += " ";
                }
                if (i == 0) j = -1;
                rowInSb[k].insert(j + 1,spaces[i]);
                j = rowInSb[k].indexOf("|", j) + 1;
            }
            shapeList.set(k, rowInSb[k].toString());
        }

    }

    public void calcSpacesForShapeList() {

        maxDiffOfSeparators[0] = shapeList.get(shapeList.size() - 1).indexOf("|");
        int j = maxDiffOfSeparators[0] + 1;
        int[] posOfSeparators = new int[6];

        for (int i = 1; i < 6; i++) {
            posOfSeparators[i] = shapeList.get(shapeList.size() - 1).indexOf("|", j);
            int diff = posOfSeparators[i] - posOfSeparators[i - 1];
            if (maxDiffOfSeparators[i] < diff) {
                maxDiffOfSeparators[i] = diff;
            };
            j = posOfSeparators[i] + 1;
        }
        maxDiffOfSeparators[6] = shapeList.get(shapeList.size() - 1).length() - posOfSeparators[5];

    }

    public void getShapesTable() {

        String firstRow, lastRow, middleRow;
        firstRow = lastRow = middleRow = "";

        for (int i = 0; i < shapeList.get(0).length(); i++) {
            firstRow += "-";
            lastRow += "-";
            if (shapeList.get(0).charAt(i) != '|') {
                middleRow += "-";
            } else {
                middleRow += "|";
            }
        }
        firstRow = "|-" + firstRow + "-|";
        middleRow = "|-" + middleRow + "-|";
        lastRow = "|-" + lastRow + "-|";

        System.out.println(firstRow);
        for (int i = 0; i < shapeList.size(); i++) {

            System.out.println("| " + shapeList.get(i) + " |");
            if (i != shapeList.size() - 1) {
                System.out.println(middleRow);
            }
        }
        System.out.println(lastRow);

    }

    public String getLargestShapeByPerimeter() {

        int indexOfMaxArea = areaList.indexOf(Collections.max(areaList));
        return shapeList.get(indexOfMaxArea);

    }

    public String getLargestShapeByArea() {

        int indexOfMaxArea = perimeterList.indexOf(Collections.max(perimeterList));
        return shapeList.get(indexOfMaxArea);

    }

}

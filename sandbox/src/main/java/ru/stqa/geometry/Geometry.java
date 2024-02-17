package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Squre;

public class Geometry {
    public static void main(String[] args) {
        Squre.printSquareArea(7);

        Rectangle.printRwectangleArea(3.0, 5.0);
        Rectangle.printRwectangleArea(7.,9.);
    }

}


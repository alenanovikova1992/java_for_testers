package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Squre;

public class Geometry {
    public static void main(String[] args) {
        Squre.printSquareArea(new Squre(7.0));
        Rectangle.printRwectangleArea(3.0, 5.0);
        Rectangle.printRwectangleArea(7.,9.);
    }

}


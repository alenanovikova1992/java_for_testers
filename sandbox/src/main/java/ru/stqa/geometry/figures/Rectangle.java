package ru.stqa.geometry.figures;

public class Rectangle {
    public static void printRwectangleArea(double a, double b) {

        System.out.println("площадь квадрата со сторонами "+ a +" и "+ b+" = "+ rectangleArea(a,b));

    }

    public static double rectangleArea(double a, double b) {
        return a*b;
    }
}

package ru.stqa.geometry.figures;

public class Squre {
    public static void printSquareArea(double side) {
        System.out.println("площадь квадрата со стороной "+ side +" = "+ squareArea(side));
    }

    private static double squareArea(double a) {
        return a * a;
    }
}

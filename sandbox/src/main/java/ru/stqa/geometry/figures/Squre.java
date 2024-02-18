package ru.stqa.geometry.figures;

public class Squre {
    public static void printSquareArea(double side) {
        System.out.println("площадь квадрата со стороной "+ side +" = "+ area(side));
    }

    public static double area(double a) {
        return a * a;
    }


    public static double perimetr(double a) {
        return  4 * a;
    }


}

package ru.stqa.geometry.figures;

public class Rectangle {
    public static void printRwectangleArea(double a, double b) {
        var text = String.format("площадь прямоугольника со сторонами %f и %f =%f", a, b,  rectangleArea(a,b) );
        System.out.println(text);

    }

    public static double rectangleArea(double a, double b) {
        return a*b;
    }
}

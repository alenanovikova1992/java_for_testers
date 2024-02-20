package ru.stqa.geometry.figures;

public record Triangle (double a, double b, double c){

    public static void printTriangleArea(Triangle t) {
        var text = String.format("площадь прямоугольника со сторонами %f и %f и %f =%f", t.a, t.b, t.c, t.area(t.a,t.b,t.c) );
        System.out.println(text);

    }
    public static double area(double a, double b, double c) {
        double p=(a+b+c)/2;
        return  Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }


}
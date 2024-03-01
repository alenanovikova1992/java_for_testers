package ru.stqa.geometry.figures;

public record Triangle (double a, double b, double c){
    public Triangle  {
        if (a<0||b<0||c<0)  {
            throw new IllegalArgumentException("Стороны прямоугольника не могут быть отрицательными");
        }

    }
    public static void printTriangleArea(Triangle t) {
        var text = String.format("площадь треугольника со сторонами %f и %f и %f =%f", t.a, t.b, t.c, t.area(t.a,t.b,t.c) );

        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle tp) {
        var text = String.format("периметр треугольника со сторонами %f и %f и %f =%f", tp.a, tp.b, tp.c, tp.perimeter(tp.a,tp.b,tp.c) );
        System.out.println(text);
    }

    public static double perimeter(double a, double b, double c) {

        double p=(a+b+c);
        return  p;

    }
    public static double area(double a, double b, double c) {

        double p=(a+b+c)/2;
        return  Math.sqrt(p*(p-a)*(p-b)*(p-c));

    }
    public static double Sum(double a, double b, double c) {

        double s1=a+b;
        double s2=b+c;
        double s3=c+a;
        return  Math.sqrt(p*(p-a)*(p-b)*(p-c));

    }


}
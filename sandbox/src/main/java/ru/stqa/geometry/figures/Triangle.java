package ru.stqa.geometry.figures;

public record Triangle (double a, double b, double c){

    public Triangle  {
        if (a<0||b<0||c<0)  {
            throw new IllegalArgumentException("Стороны треугольника не могут быть отрицательными");
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.c) ==0)
        || (Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.a) ==0)
        || (Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.b) ==0)
        ||  (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.b) ==0)
        || (Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.c, this.a) ==0)
        || (Double.compare(triangle.c, this.c) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.a, this.b) ==0);
    }

    @Override
    public int hashCode() {
        return 1;
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




}
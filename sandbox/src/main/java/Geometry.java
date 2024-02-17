public class Geometry {
    public static void main(String[] args) {
        printSquareArea(7);

        printRwectangleArea(3.0, 5.0);
printRwectangleArea(7.,9.);
    }

    private static void printRwectangleArea(double a, double b) {
        System.out.println("площадь квадрата со сторонами "+ a +" и "+ b+" = "+ rectangleArea(a,b));

    }

    private static double rectangleArea(double a, double b) {
        return a*b;
    }

    static void printSquareArea(double side) {
        System.out.println("площадь квадрата со стороной "+ side +" = "+ squareArea(side));
    }

    private static double squareArea(double a) {
        return a * a;
    }
}

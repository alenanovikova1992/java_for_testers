package ru.stqa.geometry.figures;

public record Squre (double side){
  /* public double side;

    public Squre(double side) {
        this.side=side;
    }

*/
    public static void printSquareArea(Squre s) {
        System.out.println("площадь квадрата со стороной "+ s.side +" = "+ s.area());
    }

  /*  public static double area(double a) {
        return a * a;
    }*/


   /* public static double perimetr(double a) {
        return  4 * a;
    }*/


    public double area() {
        return  this.side*this.side;
    }

    public double perimetr() {
        return 4* this.side;
    }
}

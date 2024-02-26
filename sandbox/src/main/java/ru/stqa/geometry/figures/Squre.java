package ru.stqa.geometry.figures;

public record Squre (double side){
    public  Squre {
        if (side<0){
            throw  new IllegalArgumentException("Значение сторон не может быть < 0");
        }
    }
    public static void printSquareArea(Squre s) {
        System.out.println("площадь квадрата со стороной "+ s.side +" = "+ s.area());
    }
    public double area() {
        return  this.side*this.side;
    }

    public double perimetr() {
        return 4* this.side;
    }
}

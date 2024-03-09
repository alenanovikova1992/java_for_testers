package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void  canCalculatePLT()
    {
        var t = new Triangle(6,4,2);
        double result =t.area(6,4,2);
        //  double result1 =t.area(1.5,1,1);
        //  Assertions.assertEquals(0,result);
        //  Assertions.assertEquals(0.49607837082461076,result1);
        if ( !(result==0.0)){
            throw new AssertionError(String.format("Expected %f, actual  %f",0.0, result ));
        }

    }


    @Test
    void  canCalculatePT()
    {
        var t = new Triangle(6,4,2);
        double result =t.perimeter(6,4,2);
        double result1 =t.perimeter(1.5,1,1);
        Assertions.assertEquals(12,result);
        Assertions.assertEquals(3.5,result1);
        return ;
    }



    @Test
    void  testEquality (){
        var a=3.0;
        var b=-4.0;
        var c=5.0;
        var r1 = new Triangle(a,b,c);
        var r2 = new Triangle(b,c,a);
        var r3 = new  Triangle(c,a,b);
        var r4 = new Triangle(a,b,c);
        var r5 = new Triangle(b,a,c);
        var r6 = new Triangle(c,a,b);
        var r7 = new Triangle(a,b,c);

        Assertions.assertEquals(r1,r2);
        Assertions.assertEquals(r2,r3);
        Assertions.assertEquals(r3,r4);
        Assertions.assertEquals(r4,r5);
        Assertions.assertEquals(r5,r6);
        Assertions.assertEquals(r6,r7);
    }
    }


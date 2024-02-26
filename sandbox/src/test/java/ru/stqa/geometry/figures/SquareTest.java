package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {
    @Test
     void canCalculateArea()
    {
        var s = new Squre(5.0);
        double result = s.area();
        Assertions.assertEquals(25.0, result);
    }
    @Test
    void canCalculatePerimetr()
    {
        Assertions.assertEquals(20.0, new Squre(5.0).perimetr());

    }
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
    void cannotCreateSquareWithNegativeSide()
    {try {
        new Squre(-5.0);
        Assertions.fail();
    }
    catch (IllegalArgumentException exception) {
//ok
    }

    }

}

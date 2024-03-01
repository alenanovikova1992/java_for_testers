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
    void cannotCreateSquareWithNegativeSide()
    {try {
        new Squre (-5.0);
        Assertions.fail();
    }
    catch (IllegalArgumentException exception) {
//ok
    }

    }
    @Test
    void testEquality(){
        var s1 = new Squre(5);
        var s2 = new Squre(5);
        Assertions.assertEquals(s1, s2);
    }
    @Test
    void testNonEquality(){
        var s1 = new Squre(5);
        var s2 = new Squre(4);
        Assertions.assertNotEquals(s1,s2);
    }

    @Test
    void testPass(){
        var s1 = new Squre(5.);
        var s2 = new Squre(5.);
        Assertions.assertTrue(s1.equals(s2));
    }
}

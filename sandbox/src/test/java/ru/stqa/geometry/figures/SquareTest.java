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




}

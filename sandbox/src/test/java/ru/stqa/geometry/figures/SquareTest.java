package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {
    @Test
     void canCalculateArea()
    {
        double result = Squre.area(5.0);
        Assertions.assertEquals(25.0, result);
    }
@Test
    void canCalculatePerimetr()
    {
        Assertions.assertEquals(20.0, Squre.perimetr(5.0));
    }




}

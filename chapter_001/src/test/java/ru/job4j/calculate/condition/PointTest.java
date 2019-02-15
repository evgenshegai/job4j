package ru.job4j.calculate.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;


public class PointTest {

    @Test
    public void distance() {

        Point point = new Point(0, 0);
        double result = point.distanceTo(new Point(3, 0));
        assertThat(result, closeTo(3, 0.1));
    }

}
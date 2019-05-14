package ru.job4j.collections.lambda;

/**
 * Test
 * @author Shegai Evgenii
 */

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class LambdaFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        LambdaFunction function = new LambdaFunction();
        List<Double> result = function.diapozon(5, 8, x -> Double.valueOf(2 * x + 1));
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQudraticFunctionThenResults() {
        LambdaFunction function = new LambdaFunction();
        List<Double> result = function.diapozon(5, 8, x -> Double.valueOf(x * x));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogaritmicFunctionThenResults() {
        LambdaFunction function = new LambdaFunction();
        List<Double> result = function.diapozon(1, 3, Math::log);
        List<Double> expected = Arrays.asList(0D, 0.6931471805599453D);
        assertThat(result, is(expected));
    }
}
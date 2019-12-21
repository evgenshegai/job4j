package ru.job4j.calculate.loop;

/**
 * Test.
 * @author Evgenii Shegai
 * @ version 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FitnessTest {

    @Test
    public void whenIvanGreatNik() {
        Fitness fit = new Fitness();
        int month = fit.calc(95, 90);
        assertThat(month, is(0));
    }

    @Test
    public void whenIvanLessByOneNik() {
        Fitness fit = new Fitness();
        int month = fit.calc(90, 95);
        assertThat(month, is(1));
    }

    @Test
    public void whenIvanLessByFewNik() {
        Fitness fit = new Fitness();
        int month = fit.calc(50, 90);
        assertThat(month, is(2));
    }

}
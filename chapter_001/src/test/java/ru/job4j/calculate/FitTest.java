package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */


public class FitTest {

    @Test
    public void weightForMen() {
      Fit fit = new Fit();
      double result = fit.menWeight(180);
      assertThat(result, closeTo(92.0, 0.1));
    }

    @Test
    public void weightForWomen() {
        Fit fit = new Fit();
        double result = fit.womenWeight(170);
        assertThat(result, closeTo(69.0, 0.1));
    }

}
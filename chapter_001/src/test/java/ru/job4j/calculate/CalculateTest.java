package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author EvgeniiShegai (evgeniishegai@yandex.ru)
* @version $Id$
* @since 0.1
*/

public class CalculateTest {
	
	@Test
	public void whenAdd() {
	    Calculate calculate = new Calculate();
	    calculate.add(1.0, 1.0);
	    double result = calculate.getResult();
	    assertThat(result, is(2.0));
    }

    @Test
    public void whenSubtract() {
        Calculate calculate = new Calculate();
        calculate.subtract(2.0, 1.0);
        double result = calculate.getResult();
        assertThat(result, is(1.0));
    }

    @Test
    public void whenDiv() {
        Calculate calculate = new Calculate();
        calculate.div(2.0, 1.0);
        double result = calculate.getResult();
        assertThat(result, is(2.0));
    }

    @Test
    public void whenMultiply() {
        Calculate calculate = new Calculate();
        calculate.multiple(2.0, 1.0);
        double result = calculate.getResult();
        assertThat(result, is(2.0));
    }


	
}
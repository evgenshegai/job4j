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
	public void whenTakeNameThenThreeEchoPlusName() {
    String input = "Evgenii Shegai";
    String expect = "Echo, echo, echo : Evgenii Shegai"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
    }
	
}
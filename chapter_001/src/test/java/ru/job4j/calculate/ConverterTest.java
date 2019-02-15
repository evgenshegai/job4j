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


public class ConverterTest {

    @Test
    public void whenRubInDollars() {
        Converter converter = new Converter();
        int res = converter.rubInDollars(120);
        assertThat(res, is(2));
    }

    @Test
    public void whenRubInEuro() {
        Converter converter = new Converter();
        int res = converter.rubInEvro(140);
        assertThat(res, is(2));
    }

    @Test
    public void whenEuroInRub() {
        Converter converter = new Converter();
        int res = converter.evroInRub(2);
        assertThat(res, is(140));
    }

    @Test
    public void whenDollarInRub() {
        Converter converter = new Converter();
        int res = converter.dollarsInRub(2);
        assertThat(res, is(120));
    }
}
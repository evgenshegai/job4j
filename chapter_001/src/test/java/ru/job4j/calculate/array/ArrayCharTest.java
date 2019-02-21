package ru.job4j.calculate.array;


/** Test.
 *
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {

    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar arrayChar = new ArrayChar("Hello");
        boolean result = arrayChar.startWith("Hel");
        assertThat(result, is(true));
    }

    @Test
    public void whenStartWithPrefixThenFalse() {
        ArrayChar arrayChar = new ArrayChar("Hello");
        boolean result = arrayChar.startWith("Hl");
        assertThat(result, is(false));
    }

}
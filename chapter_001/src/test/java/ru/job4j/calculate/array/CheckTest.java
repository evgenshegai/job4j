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

public class CheckTest {

    @Test
    public void whenArrayTrue() {
        Check check = new Check();
        boolean[] temp = {true, true, true};
        boolean result = check.mono(temp);
        assertThat(result, is(true));
    }


    @Test
    public void whenArrayFalse() {
        Check check = new Check();
        boolean[] temp = {true, true, true, false};
        boolean result = check.mono(temp);
        assertThat(result, is(false));
    }
}
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


public class FindLoopTest {

    @Test
    public void whenFoundNumber() {
        FindLoop findLoop = new FindLoop();
        int[] data = {1, 2, 3};
        int result = findLoop.indexOf(data, 2);
        assertThat(result, is(1));
    }

    @Test
    public void whenNoNumber() {
        FindLoop findLoop = new FindLoop();
        int[] data = {1, 2, 3};
        int result = findLoop.indexOf(data, 0);
        assertThat(result, is(-1));
    }
}
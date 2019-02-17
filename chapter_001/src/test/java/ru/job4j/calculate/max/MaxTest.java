package ru.job4j.calculate.max;

/** Test.
 *
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MaxTest {

    @Test
    public void maxFromTwoNumbers() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void maxFromThreeNumbers() {
        Max max = new Max();
        int result = max.max2(2, 5, 3);
        assertThat(result, is(5));
    }
}
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


public class SquareTest {

    @Test
    public void whenBount3() {
        Square square = new Square();
        int[] result = square.calculate(3);
        int[] expect = {1, 4, 9};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBount5() {
        Square square = new Square();
        int[] result = square.calculate(5);
        int[] expect = {1, 4, 9, 16, 25};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBount2() {
        Square square = new Square();
        int[] result = square.calculate(2);
        int[] expect = {1, 4};
        assertThat(result, is(expect));
    }

}
package ru.job4j.calculate.loop;

/** Test.
 *
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void when3x3() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String ln = System.lineSeparator();
        String expect = String.format("x x%s x %sx x%s", ln, ln, ln);
        assertThat(result, is(expect));
    }

    @Test
    public void when5x4() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String ln = System.lineSeparator();
        String expect = String.format("x x x%s x x %sx x x%s x x %s", ln, ln, ln, ln);
        assertThat(result, is(expect));
    }

}
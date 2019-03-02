package ru.job4j.pseudo;

/**
 * Test.
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
    public void testForSquare() {
        Square square = new Square();
        String result = square.draw();
        assertThat(result, is(new StringBuilder()
                .append("****")
                .append("*  *")
                .append("*  *")
                .append("****")
                .toString()
        ));
    }

}
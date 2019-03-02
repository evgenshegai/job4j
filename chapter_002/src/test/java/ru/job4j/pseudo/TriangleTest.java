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

public class TriangleTest {

    @Test
    public void testForTriangle() {
        Triangle triangle = new Triangle();
        String result = triangle.draw();
        assertThat(result, is(new StringBuilder()
                .append("  *  ")
                .append(" * * ")
                .append("*****")
                .toString()
        ));
    }

}
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


public class MatrixTest {

    @Test
    public void when2x2() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiplie(2);
        int[][] expect = {{1, 2}, {2, 4}};
        assertThat(result, is(expect));
    }

    @Test
    public void when5x5() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiplie(5);
        int[][] expect = {{1, 2, 3, 4, 5},
                          {2, 4, 6, 8, 10},
                          {3, 6, 9, 12, 15},
                          {4, 8, 12, 16, 20},
                          {5, 10, 15, 20, 25}};
        assertThat(result, is(expect));
    }
}
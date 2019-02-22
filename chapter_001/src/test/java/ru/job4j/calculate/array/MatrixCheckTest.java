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


public class MatrixCheckTest {

    @Test
    public void whenDataTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] array = {{false, true, false},
                             {true, false, true},
                             {false, true, false}};
        boolean result = matrixCheck.mono(array);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataFalse() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] array = {{true, true},
                             {false, true}};

        boolean result = matrixCheck.mono(array);
        assertThat(result, is(false));
    }
}
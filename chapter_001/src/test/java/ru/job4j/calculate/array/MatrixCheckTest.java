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
import static ru.job4j.calculate.array.MatrixCheck.isWin;


public class MatrixCheckTest {

  /*  @Test
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

    @Test
    public void whenDataNotMonoByFalseThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {false, true, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }*/


  @Test
    public void test() {
      char[][] hasWinVertical = {
              {'_', '_', 'X', '_', '_'},
              {'_', '_', 'X', '_', '_'},
              {'_', '_', 'X', '_', '_'},
              {'_', '_', 'X', '_', '_'},
              {'_', '_', 'X', '_', '_'},
      };
      boolean win = isWin(hasWinVertical);
      assertThat(win, is(true));
  }

  @Test
          public void test2() {
      char[][] hasWinHor = {
              {'_', '_', '_', '_', '_'},
              {'X', 'X', 'X', 'X', 'X'},
              {'_', '_', '_', '_', '_'},
              {'_', '_', '_', '_', '_'},
              {'_', '_', '_', '_', '_'},
      };
      boolean winHor = isWin(hasWinHor);
     assertThat(winHor, is(true));
  }

  @Test
  public void test3() {
      char[][] notWin = {
              {'_', '_', 'X', '_', '_'},
              {'_', '_', 'X', '_', '_'},
              {'_', 'X', '_', '_', '_'},
              {'_', '_', 'X', '_', '_'},
              {'_', '_', 'X', '_', '_'},
      };
      boolean lose = isWin(notWin);
      assertThat(lose, is(false));
    }
}
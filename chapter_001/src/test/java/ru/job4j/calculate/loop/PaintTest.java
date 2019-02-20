package ru.job4j.calculate.loop;

/**
 * Test.
 *  @author EvgeniiShegai (evgeniishegai@yandex.ru)
 *  @version $Id$
 *  @since 0.1
 */

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PaintTest {

    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(4);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("^   ")
                                .add("^^  ")
                                .add("^^^ ")
                                .add("^^^^")
                                .toString()
                )
        );
    }

    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                )
        );
    }

   @Test
    public void whenAllPiramida() {
       Paint paint = new Paint();
       String result = paint.pyramid(4);
       assertThat(result, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                       .add("   ^   ")
                       .add("  ^^^  ")
                       .add(" ^^^^^ ")
                       .add("^^^^^^^")
                       .toString()
               )

       );
   }
}
package ru.job4j.chess.firuges.white;

/**
 * Test for Bishop figure
 * @author Shegai Evgenii
 */

import org.junit.Test;
import ru.job4j.chess.ImposibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopWhiteTest {

    @Test
    public void whenSourceCellA1DestCellH8() {
        BishopWhite bishop = new BishopWhite(Cell.A1);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        try {
            assertThat(bishop.way(Cell.A1, Cell.H8), is(expected));
        } catch (ImposibleMoveException exc) {
            System.out.println(exc);
        }
    }

    @Test
    public void whenSourceCellH8DestCellA1() {
        BishopWhite bishop = new BishopWhite(Cell.H8);
        Cell[] expected = {Cell.G7, Cell.F6, Cell.E5, Cell.D4, Cell.C3, Cell.B2, Cell.A1};
        try {
            assertThat(bishop.way(Cell.H8, Cell.A1), is(expected));
        } catch (ImposibleMoveException exc) {
            System.out.println(exc);
        }
    }


    @Test
    public void whenSourceCellD4DestCellA1() {
        BishopWhite bishop = new BishopWhite(Cell.D4);
        Cell[] expected = {Cell.C3, Cell.B2, Cell.A1};
        try {
            assertThat(bishop.way(Cell.D4, Cell.A1), is(expected));
        } catch (ImposibleMoveException exc) {
            System.err.println(exc);
        }
    }


    @Test
    public void whenSourceCellD4DestCellA7() {
        BishopWhite bishop = new BishopWhite(Cell.D4);
        Cell[] expected = {Cell.C5, Cell.B6, Cell.A7};
        try {
            assertThat(bishop.way(Cell.D4, Cell.A7), is(expected));
        } catch (ImposibleMoveException exc) {
            System.err.println(exc);
        }
    }

}
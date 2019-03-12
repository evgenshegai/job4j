package ru.job4j.chess.firuges.white;

/**
 * BishopWhite
 * @author Shegai Evgenii
 */

import ru.job4j.chess.Figure;
import ru.job4j.chess.ImposibleMoveException;
import ru.job4j.chess.firuges.Cell;


public class BishopWhite extends Figure {

    public BishopWhite(Cell position) {
        super(position);
    }


    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
         if (!(this.moveDiagonal(source, dest))) {
             throw new ImposibleMoveException("impossible move exception");
         }
        Cell[] steps = new Cell[Math.max(source.x, dest.x) - Math.min(source.x, dest.x)];
         int deltaX = dest.x > source.x ? 1 : -1;
         int deltaY = dest.y > source.y ? 1 : -1;
         for (int i = 1; i <= steps.length; i++) {
             steps[i - 1] = Cell.getCell(source.x + i * deltaX, source.y + i * deltaY);
         }
        return steps;
    }

    private boolean moveDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}

package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public  abstract class Figure {

    private final Cell position;

    public Figure(final Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

     public abstract Figure copy(Cell dest);

}

package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Cell;

public class KnightWhite implements Figure {

    private final Cell position;

    public KnightWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] {dest };
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}

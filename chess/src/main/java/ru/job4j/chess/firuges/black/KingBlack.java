package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Cell;

public class KingBlack implements Figure {

    private final Cell position;

    public KingBlack(final Cell position) {
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
        return new KingBlack(dest);
    }
}

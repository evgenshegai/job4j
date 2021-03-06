package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board   {

    private Figure[] figures = new Figure[32];
    private int index;


    public void add(Figure figure) {
        this.figures[index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
         boolean result = false;
         this.index = findBy(source);
         if (this.index == -1) {
             throw new FigureNotFoundException("figure  not found");
         }
         Cell[] steps = this.figures[this.index].way(source, dest);
         if (hasAnotherFigures(steps)) {
             throw new OccupiedWayException(" Occupied way exception");
         }
         this.figures[this.index] = this.figures[this.index].copy(dest);
         result = true;

        return result;
    }

    private int findBy(Cell source) {
        return IntStream.range(0, this.figures.length - 1)
                .filter(i->this.figures[i] != null)
                .filter(i->this.figures[i].getPosition().equals(source))
                .findFirst()
                .orElse(-1);
    }

    private boolean hasAnotherFigures(Cell[] steps) {
        boolean result = false;
        for (Cell cell : steps) {
            for (Figure figure : this.figures) {
                if (cell.equals(figure.getPosition())) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}

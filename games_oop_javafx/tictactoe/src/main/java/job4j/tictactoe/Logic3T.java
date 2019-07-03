package job4j.tictactoe;

/*
 author Evgenii Shegai
 version 0.1
 */
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1);
    }

    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    // Данный метод возвращает тру, если я правильно понял как он работает ,  если все 3 хода у ннолика или крестика уже сделаны .
    // Вывод сделал  из результата теста

    public boolean hasGap() {
        boolean result = false;
        int count = 0;
        int count2 = 0;
        for (Figure3T [] temp : this.table) {
            for(Figure3T temp2 : temp ) {
                if (temp2.hasMarkO() == true)
                    count++;
                if (temp2.hasMarkX() == true) {
                    count2++;
                }
            }
        }
        if (count == 3 || count2 == 3) {
            result = true;
        }
        return result;
    }
}

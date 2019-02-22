package ru.job4j.calculate.array;

/**
 * Квадратный массив заполнен true or false по диагоналям
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 *  @version $Id$
 *  @since 0.1
 */



public class MatrixCheck {

    /**
     * ПРоверяем массив по диагоналям
     * @param data вхоящий массив
     * @return будево значение
     */

    public boolean mono(boolean[][] data) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if ((data[0][0] == data[data[i].length - 1][data[i].length - 1])
                        && (data[0][data[j].length - 1] == data[data[i].length - 1][0])) {
                        result = true;
                }
            }
        }

        return result;
    }
}

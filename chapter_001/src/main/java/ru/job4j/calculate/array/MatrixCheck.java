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
        boolean result = true;
        int count = 0;
        for (int i = 0; i < data.length - 1 ; i++) {
                if ((data[i][i] != data[i + 1][i + 1]) || (data[i][data.length - i - 1] != (data[i + 1][data.length - i - 2])))  {
                    result = false;
                    break;
                }
        }
        return result;
    }
}

package ru.job4j.calculate.array;

/**
 * Таблица умножения
 *  @author Evgenii Shegay(evgeniishegai@yandex.ru)
 *   @version $Id$
 *   @since 0.1
 */

public class Matrix {

    /**
     * Реализуем таблицу умножения
     * @param size размер таблицы
     * @return матрицу таблицу умножения
     */

    public int[][] multiplie(int size) {
        int[][] data = new int[size][size];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = (i + 1) * (j + 1);
            }
        }
        return data;
    }
}

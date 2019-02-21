package ru.job4j.calculate.array;

/**
 * Сортировка пузыьковая
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 *  @version $Id$
 *  @since 0.1
 */

public class BubleSort {

    /**
     * Сортировка
     * @param data массив чисел
     * @return отсортированный мапссив
     */

    public int[] sort(int[] data) {
        for (int out = data.length - 1; out > 1; out--) {
            for (int in  = 0; in < out; in++) {
               if (data[in] > data[in + 1]) {
                   int temp = data[in];
                   data[in] = data[in + 1];
                   data[in + 1] = temp;
               }
            }
        }
        return data;
    }


}

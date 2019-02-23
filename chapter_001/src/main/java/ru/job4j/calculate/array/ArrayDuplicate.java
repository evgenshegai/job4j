package ru.job4j.calculate.array;

/**
 * Удаляем дубликаты из массива
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 *  @version $Id$
 *  @since 0.1
 */

import java.util.Arrays;

public class ArrayDuplicate {

    /**
     * удаляем дубликаты
     * @param array входящий массив
     * @return конечный массив без дуликатов
     */

    public String[] remove(String[] array) {

        int count = array.length;
        for (int out = 0; out < count; out++) {
            for (int in = out + 1; in < count; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[count - 1];
                    count--;
                    in--;
                }
            }

        }
        return Arrays.copyOf(array, count);
    }
}

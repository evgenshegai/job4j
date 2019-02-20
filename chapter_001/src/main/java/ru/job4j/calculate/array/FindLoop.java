package ru.job4j.calculate.array;

/**
 * Классический поиск перебором
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 *  @version $Id$
    @since 0.1
 */

public class FindLoop {

    /**
     * Ищем одинаковый элемент в массиве
     * @param data массив чисел
     * @param temp число
     * @return индекс массива
     */

    public int indexOf(int[] data, int temp) {
        int result = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == temp) {
                result = i;
                break;
            }
        }
        return result;
    }

}

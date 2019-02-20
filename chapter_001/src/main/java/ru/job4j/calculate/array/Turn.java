package ru.job4j.calculate.array;

/**
 * Переворачиваем массив
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Turn {

    /**
     * Переворачиваем массив
     * @param array входящий массив
     * @return перевернутый массив
     */

    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            int temp2 = array[array.length - i - 1];
            array[i] = temp2;
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}

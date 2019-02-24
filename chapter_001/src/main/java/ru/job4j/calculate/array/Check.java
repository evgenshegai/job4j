package ru.job4j.calculate.array;

/**
 * Массив true или false
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Check  {

    /**
     * Проверка массива
     * @param data массив входящий
     * @return булево значение
     */

    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean temp = data[0];
        for (int i = 1; i < data.length; i++) {
            if (temp != data[i]) {
                result = false;
            }
        }
        return  result;
    }
}

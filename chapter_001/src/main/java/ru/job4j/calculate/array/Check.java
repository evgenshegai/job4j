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
        boolean result = false;
        int count = 0;
        for (boolean temp : data) {
            if (temp) {
                count++;
            }

        }
        if (count == data.length  || count == 0) {
            result = true;
        }
        return  result;
    }
}

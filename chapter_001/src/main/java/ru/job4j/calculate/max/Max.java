package ru.job4j.calculate.max;

/**
 * Максимум из двух чисел
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * Возвращает максимальное число
     * @param - два числа
     * @return - наибольшее число
     */

    public int max(int first, int second) {
        if (first == second) {
            return first;
        }
        return first > second ? first : second;
    }
}

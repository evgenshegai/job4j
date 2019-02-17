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
        return first > second ? first : second;
    }

    /**
     * Возвращает максимум из 3 чисел
     * @param a
     * @param b
     * @param c
     * @return максимальное число
     */

    public int max2(int a, int b, int c) {
        return this.max(c, (this.max(a, b)));
    }
}

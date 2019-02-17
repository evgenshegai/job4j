package ru.job4j.calculate.loop;

/**
 * Вычисляем факториал числа
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 * @version $Id$
 *  @since 0.1
 */

public class Factorial {

    /**
     * @param n - число факториал которого надо вычислить
     * @return - факториал числа
     */

    public int calc(int n) {

        int result = 1;
        if (n == 0) {
            return 1;
        }

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

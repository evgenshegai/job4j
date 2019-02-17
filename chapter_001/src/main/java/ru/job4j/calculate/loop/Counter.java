package ru.job4j.calculate.loop;

/**
 * Подсчет суммы четных чисел в диапозоне
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Counter {

    /**
     * Подсчет суммы четных чисел
     * @param start начальная цифра диапозона
     * @param finish конечная цифра диапозона
     * @return сумма четных чисел
     */

    public int add(int start, int finish) {
        int result = 0;

        for (int i = start; i <= finish; i++) {
             if (i % 2 == 0) {
                 result += i;
             }
        }
        return result;
    }
}

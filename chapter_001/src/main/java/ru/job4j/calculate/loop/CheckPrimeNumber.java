package ru.job4j.calculate.loop;

/**
 * Проверяем простое ли число
 * @ author Evgenii Shegai
 * @since 21.12.2019
 * @ version 0.1
 */

public class CheckPrimeNumber {


    public static boolean check(int finish) {
        boolean result = true;
        if (finish < 2) {
            result = false;
        }
        if (finish > 1) {
            for (int i = 2; i < finish; i++) {
                if (finish % i == 0) {
                    result = false;
                    break;
                }
            }

        }
        return result;
    }
}

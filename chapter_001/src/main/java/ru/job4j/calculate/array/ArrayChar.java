package ru.job4j.calculate.array;

/**
 * Cлово начинается с...
 *  @author Evgenii Shegay(evgeniishegai@yandex.ru)
 *  @version $Id$
 *  @since 0.1
 */

public class ArrayChar {

    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверка слова
     * @param prefix строка
     * @return булево значение
     */
    public boolean startWith(String prefix) {
        boolean result = false;
        int count = 0;
        char[] temp = prefix.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (data[i] == temp[i]) {
                count++;
            }
        }
        if (count == temp.length) {
            result = true;
        }
        return result;
    }
}

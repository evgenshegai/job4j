package ru.job4j.calculate.loop;

/**
 * Построить шахматную доску в псевдографике
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 *  @version $Id$
 *   @since 0.1
 */

public class Board {

    /**
     * Рисуем шахматную доску
     * @param width - ширина доски
     * @param hight - высота доски
     * @return - эскиз доски в псевдографике
     */

    public String paint(int width, int hight) {

        StringBuilder str = new StringBuilder();
        String ln = System.lineSeparator();

        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    str.append("x");
                } else {
                    str.append(" ");
                }
            }
            str.append(ln);
        }
        return str.toString();
    }
}

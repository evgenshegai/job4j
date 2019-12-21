package ru.job4j.calculate.loop;

/**
 * @author Evgenii Shegai
 * @version 0.1
 */

public class Fitness {

    /**
     * Вычисляем кол во месяцев которые нужны ивану
     * @param ivan - вес поднимаемый иваном
     * @param nik - вес поднимаеый николаем
     * @return - кол во месяцев
     */
    public int calc(int ivan, int nik) {
        int mounth = 0;
        while (ivan < nik) {
            ivan *= 3;
            nik *= 2;
            mounth++;
        }
        return mounth;
    }
}

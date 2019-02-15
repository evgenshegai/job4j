package ru.job4j.calculate;

/**
* Конвертер валюты
*/


public class Converter {

    private int result;

    /**
     * Конвертируем рубли в евро
     * @param value - рубли.
     * @return евро.
     */

    public int rubInEvro(int value) {
        this.result = value / 70;
        return this.result;
    }

    /**
     * Конвертируем рубли в доллары
     * @param value - рубли.
     * @return доллары.
     */

    public int rubInDollars(int value) {
        this.result = value / 60;
        return this.result;
    }

    /**
     * Конвертируем доллары в рубли
     * @param value - доллары.
     * @return рубли.
     */

    public int dollarsInRub(int value) {
        this.result = value * 60;
        return this.result;
    }

    /**
     * Конвертируем евро в рубли
     * @param value - евро.
     * @return рубли.
     */

    public int evroInRub(int value) {
        this.result = value * 70;
        return this.result;
    }

}

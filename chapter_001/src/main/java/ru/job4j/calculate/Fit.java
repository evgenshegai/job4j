package ru.job4j.calculate;

/**
 * Расчет веса
 */

public class Fit {

    private double result;

    /**
     * Идеальный вес для мужчины
     * @param height - рост
     * @return идеальный вес
     */

    public double menWeight(int height) {
        this.result = (height - 100) * 1.15;
        return this.result;
    }

    /**
     * Идеальный вес для женщины
     * @param height - рост
     * @return идеальный вес
     */

    public double womenWeight(int height) {
        this.result = (height - 110) * 1.15;
        return this.result;
    }
 }

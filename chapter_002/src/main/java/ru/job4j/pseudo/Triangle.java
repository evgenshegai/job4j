package ru.job4j.pseudo;

/**
 * Рисуем треугольник
 * @author Evgenii Shegai
 */

public class Triangle implements Shape {


    @Override
    public String draw() {
        StringBuilder str = new StringBuilder();
        str.append("  *  ");
        str.append(" * * ");
        str.append("*****");
        return str.toString();
    }
}

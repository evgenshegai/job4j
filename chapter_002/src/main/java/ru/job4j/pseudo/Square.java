package ru.job4j.pseudo;

/**
 * Рисуем квадрат
 * @author Evgenii Shegai
 */

public class Square implements Shape {


    @Override
    public String draw() {
        StringBuilder str = new StringBuilder();
        str.append("****");
        str.append("*  *");
        str.append("*  *");
        str.append("****");
        return str.toString();
    }
}

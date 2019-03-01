package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Интерфейс ввода  данных от пользователя
 * @author EvgeniiShegai
 */

public class ConsoleInput implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}

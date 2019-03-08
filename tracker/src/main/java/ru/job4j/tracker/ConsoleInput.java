package ru.job4j.tracker;

import java.security.Key;
import java.util.List;
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

    @Override
    public int ask(String question, List<Integer> ranges) {

        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int temp : ranges) {
            if (key >= 0 && key < ranges.size()) {
                exist = true;
            }
        }

        if (exist) {
            return key;
        } else {
            throw new MenuOutException("out of menu range");
        }

    }


}

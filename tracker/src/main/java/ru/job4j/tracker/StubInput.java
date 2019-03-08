package ru.job4j.tracker;

import java.util.List;

/**
 * Класс реализует  поведение пользователя
 * @author Evgenii Shegai
 */

public class StubInput implements Input {

    private final String[] value;
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, List<Integer> ranges) {
        int key = -1;
        try {
             key = Integer.valueOf(this.ask(question));
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter validate data");
        }

        return key;

    }
}

package ru.job4j.tracker;

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
}

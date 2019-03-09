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
        int key = 0;
        boolean temp = false;
             key = Integer.valueOf(this.ask(question));
             for (int index : ranges) {
                 if (key == index) {
                     temp = true;
                     break;
                 }

             }
             if (temp) {
                 return key;
             } else {
                 throw  new MenuOutException("out of menu range");
             }

    }
}

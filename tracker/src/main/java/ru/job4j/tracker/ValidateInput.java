package ru.job4j.tracker;

/**
 * Класс проверяет корректность ввода
 * @author Shegai Evgenii
 */

import java.util.List;

public class ValidateInput implements Input {

    private Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }


    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, List<Integer> ranges) {

        boolean invalid = true;
        int value = -1;
        do {
            try {
                value =  this.input.ask(question, ranges);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data");
            } catch (MenuOutException moe) {
                System.out.println("Please enter data from range");
            }
        } while (invalid);
       return value;
    }
}

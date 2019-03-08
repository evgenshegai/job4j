package ru.job4j.tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, List<Integer> ranges) {

        boolean invalid = true;
        int value = -1;
        do {
            try {
                value =  super.ask(question, ranges);
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

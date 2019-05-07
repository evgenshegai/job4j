package ru.job4j.collections.testbank;

import java.util.Objects;

/**
 * class Account
 * @author Shegai Evgenii
 */

public class Account {

    private int value;
    private int requisites;

    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public int getRequisites() {
        return requisites;
    }

}

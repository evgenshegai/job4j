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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return value == account.value && requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }
}

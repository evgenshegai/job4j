package ru.job4j.collections.testbank;

import java.util.Objects;

/**
 * class Account
 * @author Shegai Evgenii
 * version 0.1
 */

public class Account {

    private int value;
    private String requisites;

    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRequisites() {
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
        return value == account.value && requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }

    public boolean transfer(Account dest, double amount) {
        boolean result = false;
        if (this.value >= amount) {
            this.value = (int) (this.value - amount);
            dest.value = (int) (dest.value + amount);
            result = true;
        }
        return result;
    }
}

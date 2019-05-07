package ru.job4j.collections.testbank;

/**
 * class User3
 * @author Shegai Evgenii
 */

import java.util.Objects;

public class User3 {

    private String name;
    private int passport;

    public User3(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }




    public int getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User3 user3 = (User3) o;
        return passport == user3.passport && Objects.equals(name, user3.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}

package ru.job4j.collections.testbank;

/**
 * class User3
 * @author Shegai Evgenii
 */

import java.util.Objects;

public class User3 {

    private String name;
    private String passport;

    public User3(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }


    public String getPassport() {
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
        return name.equals(user3.name) && passport.equals(user3.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}

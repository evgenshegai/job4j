package ru.job4j.collections;

/**
 * class User2
 * @author Evgenii Shegai
 */

public class User2 implements Comparable<User2> {

    private int age;
    private String name;

    public User2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User2 o) {
        return  Integer.compare(this.getAge(), o.getAge());
    }
}

package ru.job4j.collections;

/**
 * class User
 * @author Evgenii Shegai
 */

public class User  {

    private int id;
    private String city;
    private String name;

    public User(int id, String city, String name) {
        this.id = id;
        this.city = city;
        this.name = name;
    }

    public int getId() {
        return id;
    }

}

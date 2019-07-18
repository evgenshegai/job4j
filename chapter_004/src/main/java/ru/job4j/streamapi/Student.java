package ru.job4j.streamapi;

/*
 author Evgenii Shegai
 version 0.1
 */

public class Student {

    private int score;
    private String name;

    public String getName() {
        return name;
    }

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

}

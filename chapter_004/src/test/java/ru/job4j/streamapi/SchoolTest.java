package ru.job4j.streamapi;

/*
 author Evgenii Shegai
 version 0.1
 */

import org.junit.Test;
import ru.job4j.streamapi.School;
import ru.job4j.streamapi.Student;

import java.util.*;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    @Test
    public void whenGetHighScore() {
        Student student1 = new Student(50);
        Student student2 = new Student(77);
        Student student3 = new Student(69);
        List<Student> students = List.of(student1, student2, student3);
        Predicate<Student> predicate = s -> s.getScore() < 100 && s.getScore() > 70;
        List<Student> result = new School().collect(students, predicate);
        List<Student> except = List.of(student2);
        assertThat(result, is(except));
    }

    @Test
    public void whenGetMiddleScore() {
        Student student1 = new Student(49);
        Student student2 = new Student(90);
        Student student3 = new Student(69);
        List<Student> students = List.of(student1, student2, student3);
        Predicate<Student> predicate = s -> s.getScore() < 70 && s.getScore() > 50;
        List<Student> result = new School().collect(students, predicate);
        List<Student> except = List.of(student3);
        assertThat(result, is(except));
    }

    @Test
    public void whenGetLowScore() {
        Student student1 = new Student(50);
        Student student2 = new Student(23);
        Student student3 = new Student(78);
        List<Student> students = List.of(student1, student2, student3);
        Predicate<Student> predicate = s -> s.getScore() < 50 && s.getScore() > 0;
        List<Student> result = new School().collect(students, predicate);
        List<Student> except = List.of(student2);
        assertThat(result, is(except));
    }
}

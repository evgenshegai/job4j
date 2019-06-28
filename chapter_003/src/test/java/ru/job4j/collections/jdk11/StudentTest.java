package ru.job4j.collections.jdk11;

import javafx.collections.transformation.SortedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {

    @Test
    public void whenUselistofMethod() {

        List<Student> list = new ArrayList<>();
        Student student1 = new Student("petr", "4");
        Student student2 = new Student("john", "5");
        Student student3 = new Student("alex", "3");
        list.add(null);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        List<Student> result = new Student().levelOf(list, 3);
        List<Student> expect = List.of(student3, student1);
        assertThat(result, is(expect));
    }

}
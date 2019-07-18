package ru.job4j.streamapi;

/*
 author Evgenii Shegai
 version 0.1
 */

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransformationlistinmapTest {

    @Test
    public void whenTransformListInMap() {
        Student student1 = new Student(12, "petr");
        Student student2 = new Student(10, "pavel");
        List<Student> list = List.of(student1, student2);
        Map<String, Student> result = new Transformationlistinmap().transformation(list);
        Map<String, Student> expect = new TreeMap();
        expect.put("petr", student1);
        expect.put("pavel", student2);
        assertThat(result, is(expect));
    }
}
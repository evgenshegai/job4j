package ru.job4j.collections.jdk11;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparator<Student> {

    private String name;
    private String scope;

    public Student(String name, String scope) {
        this.name = name;
        this.scope = scope;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getScope() {
        return scope;
    }

    private Comparator<Student> comparator = (s1, s2) -> {
        int result = 0;
        if (s1 == null) {
            result = -1;
        } else if (s2 == null) {
            result = 1;
        } else if (Integer.parseInt(s1.getScope()) > Integer.parseInt(s2.getScope())) {
            result = 1;
        } else if (Integer.parseInt(s1.getScope()) < Integer.parseInt(s2.getScope())) {
            result = -1;
        } else {
            result = s1.getName().length() - s2.getName().length();
        }
        return result;
    };


    public List<Student> levelOf(List<Student> students, int bound) {
        students.sort(comparator);
        return students.stream().flatMap(Stream::ofNullable).takeWhile(s -> Integer.parseInt(s.getScope()) < 5).collect(Collectors.toList());
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}

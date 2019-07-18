package ru.job4j.streamapi;

/*
 author Evgenii Shegai
 version 0.1
 */

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Transformationlistinmap {

    public Map<String, Student> transformation(List<Student> list) {
        return list.stream().collect(Collectors.toMap(s -> s.getName(), s -> s));
    }


}

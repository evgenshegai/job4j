package ru.job4j.streamapi;

/*
   author Evgenii Shegai
   version 0.1
 */

import java.util.List;
import java.util.stream.Collectors;

public class Matrix {

    public List<Integer> getList(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(List :: stream).collect(Collectors.toList());
    }
}

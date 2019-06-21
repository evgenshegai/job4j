package ru.job4j.collections;

/**
 * Convert array in list
 * @author Shegai Evgenii
 * version 0.1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
      /* List<Integer> result = new ArrayList<>();
       for (int[] data  : array) {
           for (int value : data) {
               result.add(value);
           }
       }*/
       return Arrays.stream(array).flatMapToInt(Arrays:: stream).boxed().collect(Collectors.toList());
    }
}

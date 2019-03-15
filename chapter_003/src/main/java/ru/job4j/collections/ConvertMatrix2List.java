package ru.job4j.collections;

/**
 * Convert array in list
 * @author Shegai Evgenii
 */

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
       List<Integer> result = new ArrayList<>();
       for (int[] data  : array) {
           for (int value : data) {
               result.add(value);
           }
       }
       return result;
    }
}

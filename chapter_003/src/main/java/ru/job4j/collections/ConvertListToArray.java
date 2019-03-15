package ru.job4j.collections;

/**
 * Convert list to array
 * @author Sgegai Evgenii
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertListToArray {

    public int[][] convert(List<Integer> list, int rows) {
        int out = 0;
        int in = 0;
        int[][] result = new int[rows][rows];
        for (int temp :list) {
            result [out][in++] = temp;
            if (in == result[out].length) {
                out++;
                in = 0;
            }
        }
        return result;
    }

    public List<Integer> convertArray(List<int[]> data) {
        List<Integer> result = new ArrayList<>();
        Iterator<int[]> it = data.iterator();
        while (it.hasNext()) {
            int[] array = it.next();
            for (int value : array) {
                result.add(value);
            }
        }

        return result;
    }
}

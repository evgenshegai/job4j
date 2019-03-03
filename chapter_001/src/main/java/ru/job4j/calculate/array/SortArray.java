package ru.job4j.calculate.array;

import java.util.Arrays;

/**
 * Принимаю 2 массива и возвращаю один отсортированный массив без дубликатов
 * @author Evgenii Shegai
 */

public class SortArray {

    private int count;
    private int index;
    private int[] result;
    private int[] one;
    private int[] two;

    public SortArray(int[] one, int[] two) {
        this.one = one;
        this.two = two;
        result = new int[one.length + two.length];
    }


    public int[] sort() {
        for (int i = 0; i < one.length; i++) {
            result[index++] = one[i];
        }
        for (int i = 0; i < two.length; i++) {
            result[index++] = two[i];
        }
        count = result.length;
        for (int out = 0; out < count; out++) {
            for (int in = out + 1; in < count; in++) {
                if (result[out] == result[in]) {
                    result[in] = result[count - 1];
                    count--;
                    in--;
                }
            }
        }
        result =  Arrays.copyOf(result, count);
        return bubleSort(result);
    }

    private int[] bubleSort(int[] result) {
        for (int out = result.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (result[in] > result[in + 1]) {
                    int temp = result[in];
                    result[in] = result[in + 1];
                    result[in + 1] = temp;
                }
            }
        }
        return result;
    }

}


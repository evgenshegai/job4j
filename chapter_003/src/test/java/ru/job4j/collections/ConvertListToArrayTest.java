package ru.job4j.collections;

/**
 * Test
 * @author Shegai Evgenii
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListToArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertListToArray list = new ConvertListToArray();
        int[][] result = list.convert(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenReturnListInteger() {
        ConvertListToArray list = new ConvertListToArray();
        List<int[]> array = new ArrayList<>();
        array.add(new int[] {1, 2, 3});
        array.add(new int[] {4, 5, 6});
        List<Integer> result = list.convertArray(array);
        List<Integer> expect = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            expect.add(i);
        }
        assertThat(result, is(expect));
    }
}
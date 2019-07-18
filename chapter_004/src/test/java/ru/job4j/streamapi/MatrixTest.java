package ru.job4j.streamapi;

/*
   author Evgenii Shegai
   version 0.1
 */

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void whenGetListInteger() {
        List<List<Integer>> matrix = List.of(List.of(1, 2), List.of(3, 4));
        List<Integer> result = new Matrix().getList(matrix);
        List<Integer> expect = List.of(1, 2, 3, 4);
        assertThat(result, is(expect));
    }

}
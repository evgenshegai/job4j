package ru.job4j.calculate.array;

/** Test.
 *
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortArrayTest {

    @Test
    public void whenHaveTwoArraysReturnOneSortArray() {
        int[] one = {1, 2, 3, 4};
        int[] two = {1, 2,  5, 6, 7};
        SortArray sortArray = new SortArray(one, two);
        int[] result = sortArray.sort();
        int[] expect = {1, 2, 3, 4, 5, 6, 7};
        assertThat(result, is(expect));
    }

}
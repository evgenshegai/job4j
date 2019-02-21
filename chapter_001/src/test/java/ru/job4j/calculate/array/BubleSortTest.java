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

public class BubleSortTest {

    @Test
    public void whenSortArrayWithTenElements() {
        BubleSort bubleSort = new BubleSort();
        int[] data = {3, 4, 1, 0, 5, 8, 9, 7, 2, 6};
        int[] result = bubleSort.sort(data);
        int[] expect = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(result, is(expect));

    }

}
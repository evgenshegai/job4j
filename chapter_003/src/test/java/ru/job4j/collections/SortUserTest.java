package ru.job4j.collections;

/**
 * Test
 * @author Shegai Evgenii
 */

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenListReturnTreeSet() {
        SortUser sortUser = new SortUser();
        List<User2> data = new ArrayList<>();
        data.add(new User2(120, "petr"));
        data.add(new User2(45, "dasha"));
        data.add(new User2(5, "ian"));
        TreeSet<User2> result = (TreeSet<User2>) sortUser.sort(data);
        assertThat(result.pollFirst().getAge(), is(5));
    }
}
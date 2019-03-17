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

    @Test
    public void whenSortByNameLength() {
        SortUser sortUser = new SortUser();
        List<User2> data = new ArrayList<>();
        User2 user = new User2(120, "petro");
        data.add(user);
        User2 user2 = new User2(45, "dash");
        data.add(user2);
        User2 user3 = new User2(5, "van");
        data.add(user3);
        List<User2> result = sortUser.sortUserByNameLength(data);
        List<User2> expect = new ArrayList<>();
        expect.add(user3);
        expect.add(user2);
        expect.add(user);
        assertThat(result, is(expect));
    }

    @Test
    public void whenCompareAllFields() {
        SortUser sortUser = new SortUser();
        List<User2> data = new ArrayList<>();
        User2 user = new User2(120, "petrov");
        data.add(user);
        User2 user2 = new User2(45, "petrov");
        data.add(user2);
        User2 user3 = new User2(5, "ivan");
        data.add(user3);
        User2 user4 = new User2(13, "ivan");
        data.add(user4);
        List<User2> result = sortUser.sortByAllFields(data);
        List<User2> expect = new ArrayList<>();
        expect.add(user3);
        expect.add(user4);
        expect.add(user2);
        expect.add(user);
        assertThat(result , is(expect));
    }
}
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
        List<User2> data = List.of(new User2(120, "petr"), new User2(45, "dasha"), new User2(5, "ian"));
        TreeSet<User2> result = (TreeSet<User2>) sortUser.sort(data);
        assertThat(result.pollFirst().getAge(), is(5));
    }

    @Test
    public void whenSortByNameLength() {
        SortUser sortUser = new SortUser();
        User2 user = new User2(120, "petro");
        User2 user2 = new User2(45, "dash");
        User2 user3 = new User2(5, "van");
        List<User2> data = List.of(user, user2, user3);
        List<User2> result = sortUser.sortUserByNameLength(data);
        List<User2> expect = List.of(user3, user2, user);
        assertThat(result, is(expect));
    }

    @Test
    public void whenCompareAllFields() {
        SortUser sortUser = new SortUser();
        User2 user = new User2(120, "petrov");
        User2 user2 = new User2(45, "petrov");
        User2 user3 = new User2(5, "ivan");
        User2 user4 = new User2(13, "ivan");
        List<User2> data = List.of(user, user2, user3, user4);
        List<User2> result = sortUser.sortByAllFields(data);
        List<User2> expect = List.of(user3, user4, user2, user);
        assertThat(result, is(expect));
    }
}
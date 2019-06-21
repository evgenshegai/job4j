package ru.job4j.collections;

/**
 * Test
 * @author Shegai Evgenii
 */

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void whenProcessReturnHashMap() {
        UserConvert convert = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(12, "Moscow", "VasyaPupkin"));
        User user = new User(10, "Vladivostok", "qwerty");
        list.add(user);
        Map<Integer, User> map;
        map = convert.process(list);
        assertThat(map.get(10), is(user));
    }

}
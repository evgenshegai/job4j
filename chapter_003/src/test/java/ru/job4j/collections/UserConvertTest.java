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
        User user = new User(12, "Moscow", "VasyaPupkin");
        User user2 = new User(10, "Vladivostok", "qwerty");
        List<User> list = List.of(user, user2);
        Map<Integer, User> map;
        map = convert.process(list);
        assertThat(map.get(10), is(user2));
    }

}
package ru.job4j.collections;

/**
 * Class UserConvert
 * @author Evgenii Shegai
 */

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>(list.size());
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}

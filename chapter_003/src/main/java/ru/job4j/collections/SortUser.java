package ru.job4j.collections;

/**
 * class SortUser
 * @author Shegai Evgenii
 */

import java.util.*;

public class SortUser {

    public Set<User2> sort(List<User2> array) {
        Set<User2> result = new TreeSet<>();
        for (User2 temp : array) {
            if (temp != null) {
                result.add(temp);
            }
        }
        return result;
    }

    public List<User2> sortUserByNameLength(List<User2> list) {

        Collections.sort(list, new Comparator<User2>() {
            @Override
            public int compare(User2 o1, User2 o2) {
                int res = 0;
                if (o1.getName().length() > o2.getName().length()) {
                    res = 1;
                } else if (o1.getName().length() < o2.getName().length()) {
                    res = -1;
                }
                return res;
            }
        });
        return list;
    }

    public List<User2> sortByAllFields(List<User2> list) {

        Collections.sort(list, new Comparator<User2>() {
            @Override
            public int compare(User2 o1, User2 o2) {
                int comp = o1.getName().compareTo(o2.getName());
                return comp != 0 ? comp : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }

}

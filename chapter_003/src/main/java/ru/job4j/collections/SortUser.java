package ru.job4j.collections;

/**
 * class SortUser
 * @author Shegai Evgenii
 * version 0.1
 */

import java.util.*;
import java.util.stream.Collectors;

public class SortUser {

    public Set<User2> sort(List<User2> list) {
       /* Set<User2> result = new TreeSet<>();
        for (User2 temp : list) {
            if (temp != null) {
                result.add(temp);
            }
        }*/
        return list.stream().collect(Collectors.toCollection(TreeSet::new));
    }

    public List<User2> sortUserByNameLength(List<User2> list) {

       /* Collections.sort(list, new Comparator<User2>() {
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
        });*/
        return list.stream().sorted(Comparator.comparing(u -> u.getName().length())).collect(Collectors.toList());
    }

    public List<User2> sortByAllFields(List<User2> list) {
/*
        Collections.sort(list, new Comparator<User2>() {
            @Override
            public int compare(User2 o1, User2 o2) {
                int comp = o1.getName().compareTo(o2.getName());
                return comp != 0 ? comp : Integer.compare(o1.getAge(), o2.getAge());
            }
        });*/
        return list.stream().sorted((s1, s2) -> (s1.getName().equals(s2.getName())) ? s1.getAge() - s2.getAge()
                : s1.getName().compareTo(s2.getName())).collect(Collectors.toList());
    }
}



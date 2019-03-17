package ru.job4j.collections;

/**
 * class SortUser
 * @author Shegai Evgenii
 */

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<User2> sort(List<User2> array){
        Set<User2> result = new TreeSet<>();
        for(User2 temp : array) {
            if (temp != null) {
                result.add(temp);
            }
        }
        return result;
    }

}

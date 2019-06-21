package ru.job4j.collections;

/**
 * class ListCompare for String
 * @author Shegai Evgenii
 * version 0.1
 */

import java.util.Comparator;
import java.util.stream.IntStream;

public class ListCompare implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
       /* int value = o1.length();
        int value2 = o2.length();
        int result = 0;
        int size = Math.min(value, value2);
        for (int index = 0; index < size; index++) {
          result =  Character.compare(o1.charAt(index), o2.charAt(index));
          if (result != 0) {
              result = o1.charAt(index) - o2.charAt(index);
              break;
          }
        }
        if (result == 0) {
           result = value - value2;
        }*/
        return IntStream.range(0, Math.min(o1.length(), o2.length()))
                .map(i -> Character.compare(o1.charAt(i), o2.charAt(i)))
                .filter(i -> i != 0)
                .findFirst()
                .orElse(o1.length() - o2.length());
    }
}

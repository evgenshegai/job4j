package ru.job4j.collections;

/**
 * class ListCompare for String
 * @author Shegai Evgenii
 */

import java.util.Comparator;

public class ListCompare implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
        int value = o1.length();
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
        }
        return result;
    }
}

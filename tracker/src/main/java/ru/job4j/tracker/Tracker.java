package ru.job4j.tracker;

/**
 * Трекер
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {

    private List<Item> list = new ArrayList<>();
    private static final Random RN = new Random();



    public Item add(Item item) {
        if (item != null) {
            item.setId(this.generatedId());
            list.add(item);
        }
        return item;
    }

    private String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if (item != null && list.get(i).getId().equals(id)) {
                item.setId(id);
                list.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
       // int count = 0;
        for (int index = 0; index < list.size(); index++) {
            result.add(list.get(index));

        }
       // result = Arrays.copyOf(result, result.s - count);
        return result;
    }

    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
       // int index2 = 0;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) != null && list.get(index).getName().equals(name)) {
                result.add(list.get(index));
            }
        }
       // result = Arrays.copyOf(result, result.length - index2);
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index <= list.size(); index++) {
            if (list.get(index).getId().equals(id)) {
                result = list.get(index);
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) != null && list.get(index).getId().equals(id)) {
                 result = list.remove(list.get(index));
               // System.arraycopy(items, index + 1, items, index, items.length - index - 1);
               // result = true;
                break;
            }
        }
        return result;
    }
}

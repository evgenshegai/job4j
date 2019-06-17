package ru.job4j.tracker;

/**
 * Трекер
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 * version 0.1
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        return list.stream().collect(Collectors.toList());
    }

    public List<Item> findByName(String name) {
        return list.stream().filter(s-> s.getName().equals(name)).collect(Collectors.toList());
    }

    public Item findById(String id) {
        return list.stream().filter(s-> s.getId().equals(id)).findAny().get();
    }


    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) != null && list.get(index).getId().equals(id)) {
                list.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }
}
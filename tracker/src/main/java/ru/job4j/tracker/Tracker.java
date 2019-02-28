package ru.job4j.tracker;

/**
 * Трекер
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 */

import java.util.Random;

public class Tracker {

    private Item[] items = new Item[100];
    private static final Random RN = new Random();
    private int position;


    public Item add(Item item) {
        if (item != null) {
            item.setId(this.generatedId());
            items[position++] = item;
        }
        return item;
    }

    private String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if (item != null && items[i].getId().equals(id)) {
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int index = 0; index < result.length; index++) {
            result[index] = items[index];
        }
        return result;
    }

    public Item[] findByName(String name) {
        Item[] result = new Item[position];
        int index2 = 0;
        for (int index = 0; index < result.length; index++) {
            if (items[index].getName().equals(name)) {
                result[index2++] = items[index];
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index <= position; index++) {
            if (items[index].getId().equals(id)) {
                result = items[index];
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, position - index - 1);
                result = true;
            }
        }
        return result;
    }
}

package ru.job4j.collections;

import java.util.LinkedList;

public class PriorityQuque {

    private LinkedList<Task> tasks = new LinkedList<Task>();
    private int index;
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0 || index < task.getPriority()) {
            while (index < task.getPriority()) {
                tasks.add(index, null);
                index++;
            }
        }
        tasks.add(task.getPriority(), task);
    }

    public Task take() {
        Task result = tasks.poll();
        return result != null ? result : take();
    }
}

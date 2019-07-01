package ru.job4j.collections;

import java.util.LinkedList;

public class PriorityQuque {

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        var index = 0;
        if (tasks.size() == 0) {
            tasks.add(task);
            return;
        }
        for (var temp : tasks) {
            index++;
            if (task.getPriority() <= temp.getPriority()) {
               tasks.add(--index, task);
               break;
           } else {
             continue;
           }
       }


    }

    public Task take() {
        Task result = tasks.poll();
        return result != null ? result : take();
    }
}

package ru.job4j.collections;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQuqueTest {

    @Test
    public void whenHigherPriority() {
        PriorityQuque queue = new PriorityQuque();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("test", 2));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHightPriority() {
        PriorityQuque queue = new PriorityQuque();
        queue.put(new Task("middle", 3));
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("test", 1));
        Task result = queue.take();
        assertThat(result.getDesc(), is("test"));
    }


}
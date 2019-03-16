package ru.job4j.tracker;

/**
 * Test.
 *
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class TrackerTest {

    @Test
    public void whenAddItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "desc", 1);
        Item result = tracker.add(item);
        assertThat(result, is(item));
    }

  @Test
    public void whenReplaceById() {
        Tracker tracker = new Tracker();
        Item first = new Item("test", "desc", 1);
        Item second = new Item("test2", "desc2", 2);
        Item temp = tracker.add(first);
        assertThat(tracker.replace(temp.getId(), second), is(true));
    }


    @Test
    public void whenArrayItemReturn() {
        Tracker tracker = new Tracker();
        Item first = new Item("test", "desc", 1);
        Item second = new Item("test2", "desc2", 2);
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.findAll().get(0), is(first));
    }


    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test", "desc", 1);
        Item second = new Item("test2", "desc2", 2);
        List<Item> expect = new ArrayList<>();
        expect.add(second);
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.findByName(second.getName()), is(expect));
    }


    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item first = new Item("test", "desc", 1);
        Item second = new Item("test2", "desc2", 2);
        tracker.add(first);
        Item expect = tracker.add(second);
        assertThat(tracker.findById(expect.getId()), is(expect));
    }


    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test", "desc", 1);
        Item second = new Item("test2", "desc2", 2);
        Item temp = tracker.add(first);
        tracker.add(second);
        tracker.delete(temp.getId());
        assertThat(tracker.findAll().get(0).getName(), is(second.getName()));
    }
}
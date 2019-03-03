package ru.job4j.tracker;

/**
 * Test.
 *
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {

    @Test
    public void whenUserAddItem() {
        Input input = new StubInput(new String[] {"0", "test", "desc", "1", "6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test"));
    }

    @Test
    public void whenAddItemThenUpdateItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "desc", 1);
        tracker.add(item);
        Input input = new StubInput(new String[] {"2", item.getId(), "test2", "desc2", "2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }

    @Test
    public void whenAddItemsThenFindItemById() {
        Item item = new Item("test", "desc", 1);
        Item item2 = new Item("test2", "desc2", 2);
        Tracker tracker = new Tracker();
        tracker.add(item);
        Item temp = tracker.add(item2);
        Input input = new StubInput(new String[] {"4", temp.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(temp.getId()), is(temp));
    }

    @Test
    public void whenAddItemsThenDeleteOneItem() {
        Item item = new Item("test", "desc", 1);
        Item item2 = new Item("test2", "desc2", 2);
        Tracker tracker = new Tracker();
        Item temp = tracker.add(item);
        tracker.add(item2);
        Input input = new StubInput(new String[] {"3", temp.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is(item2.getName()));
    }

}
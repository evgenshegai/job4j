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
import org.junit.After;
import org.junit.Before;


public class StartUITest {

    private Tracker tracker;
    private Item item;
    private Item item2;

    @Before
    public void inStart() {
        this.tracker = new Tracker();
        this.item = new Item("test", "desc", 1);
        this.item2 = new Item("test2", "desc2", 2);
    }

    @After
    public void inFinish() {
        System.out.println("The end");
    }

    @Test
    public void whenUserAddItem() {
        Input input = new StubInput(new String[] {"0", "test", "desc", "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test"));
    }

    @Test
    public void whenAddItemThenUpdateItem() {
        tracker.add(item);
        Input input = new StubInput(new String[] {"2", item.getId(), "test2", "desc2", "2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }

    @Test
    public void whenAddItemsThenFindItemById() {
        tracker.add(item);
        Item temp = tracker.add(item2);
        Input input = new StubInput(new String[] {"4", temp.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(temp.getId()), is(temp));
    }

    @Test
    public void whenAddItemsThenDeleteOneItem() {
        Item temp = tracker.add(item);
        tracker.add(item2);
        Input input = new StubInput(new String[] {"3", temp.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is(item2.getName()));
    }

    @Test
    public void whenAddItemsThenDisplayAll() {
        tracker.add(item);
        tracker.add(item2);
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        Item[] result = {item, item2};
        assertThat(result, is(tracker.findAll()));

    }

}
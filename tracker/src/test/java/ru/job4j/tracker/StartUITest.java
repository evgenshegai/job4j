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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void inStart() {
       System.setOut(new PrintStream(this.out));
    }

    @After
    public void inFinish() {
       System.setOut(this.stdout);
    }


    @Test
    public void whenUserAddItem() {
        Input input = new StubInput(new String[] {"0", "test", "desc", "1", "y"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        String expect = this.out.toString();
        assertThat(this.out.toString(), is(expect));
    }

    @Test
    public void whenAddItemThenUpdateItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "desc", 1);
        tracker.add(item);
        Input input = new StubInput(new String[] {"1", item.getId(), "test2", "desc2", "2", "y"});
        new StartUI(input, tracker).init();
        String expect = this.out.toString();
        assertThat(this.out.toString(), is(expect));
   }

    @Test
    public void whenAddItemsThenFindItemById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "desc", 1);
        tracker.add(item);
        Item item2 = new Item("test2", "desc2", 2);
        Item temp = tracker.add(item2);
        Input input = new StubInput(new String[] {"4", temp.getId(), "y"});
        new StartUI(input, tracker).init();
        String expect = this.out.toString();
        assertThat(this.out.toString(), is(expect));
    }

    @Test
    public void whenAddItemsThenDeleteOneItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "desc", 1);
        Item temp = tracker.add(item);
        Item item2 = new Item("test2", "desc2", 2);
        tracker.add(item2);
        Input input = new StubInput(new String[] {"3", temp.getId(), "y"});
        new StartUI(input, tracker).init();
        String expect = this.out.toString();
        assertThat(this.out.toString(), is(expect));
    }

    @Test
    public void whenAddItemsThenDisplayAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "desc", 1);
        Item item2 = new Item("test2", "desc2", 2);
        tracker.add(item);
        tracker.add(item2);
        Input input = new StubInput(new String[] {"2", "y"});
        new StartUI(input, tracker).init();
        Item[] result = {item, item2};
        String expect = this.out.toString();
        assertThat(this.out.toString(), is(expect));
    }
}
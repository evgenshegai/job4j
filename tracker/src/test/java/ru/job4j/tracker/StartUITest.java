
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


    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    public static String ln = System.lineSeparator();
    public static final String ME_NU = String.valueOf(new StringBuilder().append("0. Add the item" + ln)
            .append("1. Edit the item" + ln)
            .append("2. Show all items" + ln)
            .append("3. Delete item" + ln)
            .append("4. Find item by id" + ln)
            .append("5. Find item by name" + ln)
            .append("6. Exit from programm" + ln));


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
        assertThat(this.out.toString(), is(new StringBuilder(ME_NU)
                .append("Создание новой заявки" + ln)
                .toString()));
    }

    @Test
    public void whenAddItemThenUpdateItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "desc", 1);
        tracker.add(item);
        Input input = new StubInput(new String[] {"1", item.getId(), "test2", "desc2", "2", "y"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder(ME_NU)
                .append("Редактирую заявку" + ln)
                .append("Item was update" + ln)
                .toString()));
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
        assertThat(this.out.toString(), is(new StringBuilder(ME_NU)
                .append("Нахожу заявку по айди" + ln)
                .append("Item was foundtest2" + ln)
                .toString()));
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
        assertThat(this.out.toString(), is(new StringBuilder(ME_NU)
                .append("Удаляю заявку" + ln)
                .append("Item was delete" + ln)
                .toString()));
    }

    @Test
    public void whenAddItemsThenDisplayAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "desc", 1);
        Item item2 = new Item("test2", "desc2", 2);
        Item temp = tracker.add(item);
        Item temp2 = tracker.add(item2);
        Input input = new StubInput(new String[] {"2", "y"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder(ME_NU)
                .append("Заявка с именем " +  temp.getName() + " и айди " + temp.getId() + " выведена" + ln)
                .append("Заявка с именем " +  temp2.getName() + " и айди " + temp2.getId() + " выведена" + ln)
                .toString()));
    }
}

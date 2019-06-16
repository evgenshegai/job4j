
package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/**
 * Основной класс трекера
 * @author Evgenii Shegai
 */


public class StartUI {

    private  final Input input;
    private final Tracker tracker;
    private static final String ADD = "0";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDITEMBYID = "4";
    private static final String FINDITEMBYNAME = "5";
    private static final String EXIT = "6";
    private final Consumer<String> output;



    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        List<Integer> ranges = new ArrayList<>();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            ranges.add(i);
        }

        do {
            menu.show();
            menu.select(input.ask("select:", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    private void showMenu() {
        System.out.println("Пункты меню");
        System.out.println("0 - добавить заявку");
        System.out.println("1 - показать все заявки");
        System.out.println("2 - редактировать заявку");
        System.out.println("3 - удалить заявку");
        System.out.println("4 - найти заявку по айди");
        System.out.println("5 - найти заявку по имени");
        System.out.println("6 - выйти из программы");
    }

    private void createItem() {
        System.out.println("Добавление новой завки");
        String name = this.input.ask("Введите имя заявки");
        String desc = this.input.ask("Введите описание заявки");
        long create = Long.parseLong(this.input.ask("Введите дату создания заявки"));
        Item item = new Item(name, desc, create);
        this.tracker.add(item);
        System.out.println("Завка с именем " + item.getName() + " и с  айди" + item.getId() + " добавлена");
    }

    private void showAll() {
        System.out.println("Вывожу все заявки");
        List<Item> result = tracker.findAll();
        for (Item temp : result) {
            if (temp != null) {
                System.out.println("Заявка с именем " + temp.getName() + " и айди " + temp.getId() + " выведена");
            }
        }
    }

    private void edit() {
        System.out.println("Редактирую заявку");
        String id = this.input.ask("Введите айди завки");
        String name = this.input.ask("Введите имя новой заявки");
        String desc = this.input.ask("Введите описание новой заявки");
        long create = Long.parseLong(this.input.ask("Введите дату создания новой заявки"));
        Item temp = new Item(name, desc, create);
        boolean result = this.tracker.replace(id, temp);
        if (result) {
            System.out.println("Заявка успешно заменена");
        } else {
            System.out.println("попробуйте снова");
        }

    }

    private  void delete() {
        System.out.println("Удаляю заявку");
        String id = this.input.ask(" Введите айди удаляемой заявки");
        boolean result = this.tracker.delete(id);
        if (result) {
            System.out.println("Заявка успешна удалена");
        } else {
            System.out.println("Попробуйте снова");
        }
    }

    private void findById() {
        System.out.println("Нахожу заявку по айди");
        String id = this.input.ask("Введите айди заявки");
        Item result = this.tracker.findById(id);
        System.out.println("Заявка найдена. Ее имя - " + result.getName());
    }

    private void findByName() {
        System.out.println("Нахожу зхаявку по имени");
        String name = this.input.ask("Введите имя заявки");
        List<Item> result = this.tracker.findByName(name);
        for (Item temp : result) {
            if (temp != null) {
                System.out.println("Заявка с именем " + temp.getName() + " найдена");
            }
        }
    }

    public static void main(String[] args) {
         new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }

}


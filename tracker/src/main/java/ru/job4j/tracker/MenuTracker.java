
package ru.job4j.tracker;
/**
 * Реализую события на внутренних классах
 * @author Shegai Evgenii
 * version 0.1
 **/


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }
    private boolean result;
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Удаляю заявку");
        String id = input.ask(" Введите айди удаляемой заявки");
        this.result = tracker.delete(id);
        if (result) {
            System.out.println("Item was delete");
        } else {
            System.out.println("Item not found");
        }
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private Consumer<String> output;


    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public int getActionsLentgh() {
        return this.actions.size();
    }


    public void fillActions() {
        this.actions.add(0, new AddItem(0, "Add the item"));
        this.actions.add(1, new  MenuTracker.UpdateItem(1, "Edit the item"));
        this.actions.add(2, new ShowItems(2, "Show all items"));
        this.actions.add(3, new DeleteItem(3, "Delete item"));
        this.actions.add(4, new FindItemById(4, "Find item by id"));
        this.actions.add(5, new FindItemsByName(5, "Find item by name"));
        this.actions.add(6, new ExitProgramm(6, "Exit from programm"));
    }
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("Создание новой заявки");
            String name = input.ask("Введите имя заявки");
            String desc = input.ask("Введите описание заявки");
            long create = Long.parseLong(input.ask("Введите дату создания заявки"));
            Item item = new Item(name, desc, create);
            tracker.add(item);
        }

    }

    private  class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }
        private boolean result;

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Редактирую заявку");
            output.accept("Редактирую заявку");
            String id = input.ask("Введите айди завки");
            String name = input.ask("Введите имя новой заявки");
            String desc = input.ask("Введите описание новой заявки");
            long create = Long.parseLong(input.ask("Введите дату создания новой заявки"));
            Item temp = new Item(name, desc, create);
            this.result = tracker.replace(id, temp);
            if (result) {
                output.accept("Item was update");
            } else {
                output.accept("Item was not found");
            }
        }

    }
    private class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> result = tracker.findAll();
            for (Item temp : result) {
                if (temp != null) {
                    output.accept("Заявка с именем " + temp.getName() + " и айди " + temp.getId() + " выведена");
                }
            }
        }
    }
    private class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Нахожу заявку по айди");
            output.accept("Нахожу заявку по айди");
            Item result = null;
            String id = input.ask("Введите айди заявки");
            result = tracker.findById(id);
            if (result != null) {
                output.accept("Item was found" + result.getName());
            } else {
                output.accept("Item not found");
            }
        }

    }
    private class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Нахожу зхаявку по имени");
            output.accept("Нахожу зхаявку по имени");
            String name = input.ask("Введите имя заявки");
            List<Item> result = tracker.findByName(name);
            for (Item temp : result) {
                if (temp != null) {
                    output.accept("Заявка с именем " + temp.getName() + " найдена");
                }
            }
        }
    }
    private class ExitProgramm extends BaseAction {
        public ExitProgramm(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("Для выхода из программы нажмите - y");
        }
}
    }
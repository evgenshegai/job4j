package ru.job4j.tracker;

/**
 * Реализую события на внутренних классах
 * @author Shegai Evgenii
 */

import java.util.ArrayList;
import java.util.List;

class DeleteItem implements UserAction {

    private boolean result;

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Удаляю заявку");
        String id = input.ask(" Введите айди удаляемой заявки");
        this.result = tracker.delete(id);
    }

    @Override
    public String info() {
        return String.format("%s. %s. %s",this.key(), "Delete item", result);
    }
}

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(0, new AddItem());
        this.actions.add(1, new  MenuTracker.UpdateItem());
        this.actions.add(2, new ShowItems());
        this.actions.add(3, new DeleteItem());
        this.actions.add(4, new FindItemById());
        this.actions.add(5, new FindItemsByName());
        this.actions.add(6, new ExitProgramm());
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Создание новой заявки");
            String name = input.ask("Введите имя заявки");
            String desc = input.ask("Введите описание заявки");
            long create = Long.parseLong(input.ask("Введите дату создания заявки"));
            Item item = new Item(name, desc, create);
            tracker.add(item);
        }

        @Override
        public String info() {
            return String .format("%s. %s", this.key(), "Add the item");
        }
    }

    private static class UpdateItem implements UserAction {

        private boolean result;

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Редактирую заявку");
            String id = input.ask("Введите айди завки");
            String name = input.ask("Введите имя новой заявки");
            String desc = input.ask("Введите описание новой заявки");
            long create = Long.parseLong(input.ask("Введите дату создания новой заявки"));
            Item temp = new Item(name, desc, create);
            this.result = tracker.replace(id, temp);
        }

        @Override
        public String info() {
            return String .format("%s. %s. %s", this.key(), "Edit the item", result);
        }
    }

    private class ShowItems implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] result = tracker.findAll();
            for (Item temp : result) {
                if (temp != null) {
                    System.out.println("Заявка с именем " + temp.getName() + " и айди " + temp.getId() + " выведена");
                }
            }
        }

        @Override
        public String info() {
            return String .format("%s. %s", this.key(), "Show all items");
        }
    }

   private class FindItemById implements UserAction {

       @Override
       public int key() {
           return 4;
       }

       @Override
       public void execute(Input input, Tracker tracker) {
           System.out.println("Нахожу заявку по айди");
           Item result = null;
           String id = input.ask("Введите айди заявки");
           try {
               result = tracker.findById(id);
               System.out.println("Заявка найдена. Ее имя - " + result.getName());
           } catch (NullPointerException npe) {
               System.out.println("Заявка не найдена . Введите корректное id");
           }


       }

       @Override
       public String info() {
           return String .format("%s. %s", this.key(), "Find item by id");
       }
   }

    private class FindItemsByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Нахожу зхаявку по имени");
            String name = input.ask("Введите имя заявки");
            Item[] result = tracker.findByName(name);
            for (Item temp : result) {
                if (temp != null) {
                    System.out.println("Заявка с именем " + temp.getName() + " найдена");
                }
            }
        }

        @Override
        public String info() {
            return String .format("%s. %s", this.key(), "Find item by name");
        }
    }

    private class ExitProgramm implements  UserAction {


        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Для выхода из программы нажмите - y");
        }

        @Override
        public String info() {
            return "6.Exit from programm";
        }
    }


}

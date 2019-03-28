package ru.job4j.collections;

/**
 * class Account
 * @author Shegai Evgenii
 */

import java.util.*;

public class Account {

    private int value;
    private int requisites;
    private Map<User3, List<Account>> map = new HashMap<>();
    private List<Account> list = new ArrayList<>();

    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public int getRequisites() {
        return requisites;
    }

    public void addUser(User3 user) {
        if (user != null) {
            map.put(user, null);
        }
    }

    public void deleteUser(User3 user) {
            Map.Entry<User3, List<Account>> pair = iterateForMap(user.getPassport());
            map.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        int pass = Integer.valueOf(passport);
        Map.Entry<User3, List<Account>> pair = iterateForMap(pass);
        User3 user3 = pair.getKey();
        list.add(account);
        map.putIfAbsent(user3, list);

    }

    public void deleteAccountFromUser(String passport, Account account) {
        int pass = Integer.valueOf(passport);
            Map.Entry<User3, List<Account>> pair = iterateForMap(pass);
               List<Account> list = pair.getValue();
               for (int i = 0; i < list.size(); i++) {
                   if (list.get(i).getValue() == account.getValue()) {
                       list.remove(i);
            }
        }

    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        List<Account> temp2 = new ArrayList<>();
        int pass = Integer.valueOf(passport);
            Map.Entry<User3, List<Account>> pair = iterateForMap(pass);
                 temp2 = pair.getValue();
        for (Account account : temp2) {
            result.add(account);
        }
         return result;
    }

    public Map<User3, List<Account>> getMap() {
        return map;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        int src = Integer.valueOf(srcPassport);
        int  dest = Integer.valueOf(destPassport);
        int srcReq = Integer.valueOf(srcRequisite);
        int destReq = Integer.valueOf(dstRequisite);
        int count = 0;
            Map.Entry<User3, List<Account>> pair = iterateForMap(src);
                List<Account> list = pair.getValue();
                for (Account account : list) {
                    if (account.getValue() >= amount && account.getRequisites() == srcReq) {
                       count++;
                        break;
                    }
                }

                pair = iterateForMap(dest);
                List<Account> list2 = pair.getValue();
                for (Account account : list2) {
                    if (account.getRequisites() == destReq) {
                        count++;
                        break;
                    }
                }

            if (count == 2) {
                result = true;
            }
       return result;
    }

    private  Map.Entry<User3, List<Account>> iterateForMap(int value) {
        Map.Entry<User3, List<Account>> result = null;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<User3, List<Account>> pair = (Map.Entry<User3, List<Account>>) iterator.next();
            int temp = pair.getKey().getPassport();
            if (temp == value) {
               result = pair;
               break;
            }
        }
        return result;
    }



}

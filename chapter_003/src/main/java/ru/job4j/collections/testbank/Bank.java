package ru.job4j.collections.testbank;

/**
   class Bank
  author@ Shegai Evgenii
 */

import java.util.*;
import ru.job4j.collections.testbank.Account;

public class Bank {

    private Map<User3, List<Account>> map = new HashMap<>();

    public void addUser(User3 user)  {
        map.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User3 user) {
        map.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {

        Set<User3> users = map.keySet();
        for (User3 temp : users) {
            if (temp.getPassport().equals(passport)) {
                List<Account> list = map.get(temp);
                list.add(account);
                break;
            }
        }
     }

    public Map<User3, List<Account>> getMap() {
        return map;
    }


    public void deleteAccountFromUser(String passport, Account account) {

        Set<User3> users = map.keySet();
        for (User3 temp : users) {
            if (temp.getPassport().equals(passport)) {
                for (int i = 0; i < map.get(temp).size(); i++) {
                    if (map.get(temp).get(i).equals(account)) {
                        map.get(temp).remove(i);
                        break;
                    }
                }
            }
        }
    }

    public List<Account> getUserAccounts(String passport)  {

        Set<User3> users = map.keySet();
        List<Account> list = new ArrayList<>();
        for (User3 temp : users) {
            if (temp.getPassport().equals(passport)) {
                 list = map.get(temp);
            }
        }
       return list;
    }


    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        final Account src = this.getAccount(srcPassport, srcRequisite);
        final Account dest = this.getAccount(destPassport, dstRequisite);
        if (src != null && dest != null) {
            result = src.transfer(dest, amount);
        }
        return result;

    }

    private Account getAccount(String passport, String req) {
        Account result = null;
        final  List<Account> list = this.getUserAccounts(passport);
        for (Account account : list) {
            if (account.getRequisites().equals(req)) {
                result = account;
                break;
            }
        }
        return result;
    }



}

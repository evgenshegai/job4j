package ru.job4j.collections.testbank;

/**
   class Bank
  author@ Shegai Evgenii
 */

import java.util.*;

public class Bank {

    private Map<User3, List<Account>> map = new HashMap<>();

    public void addUser(User3 user)  {
        map.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User3 user) {
        map.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        int pass = Integer.valueOf(passport);
        Set<User3> users = map.keySet();
        for (User3 temp : users) {
            if (temp.getPassport() == pass) {
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
        int pass = Integer.valueOf(passport);
        Set<User3> users = map.keySet();
        for (User3 temp : users) {
            if (temp.getPassport() == pass) {
                for (int i = 0; i < map.get(temp).size(); i++) {
                    if (map.get(temp).get(i) == account) {
                        map.get(temp).remove(i);
                        break;
                    }
                }
            }
        }
    }

    public List<Account> getUserAccounts(String passport)  {
       int pass = Integer.valueOf(passport);
        Set<User3> users = map.keySet();
        List<Account> list = new ArrayList<>();
        for (User3 temp : users) {
            if (temp.getPassport() == pass) {
                 list = map.get(temp);
            }
        }
       return list;
    }


    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = true;
        int src = Integer.valueOf(srcPassport);
        int  dest = Integer.valueOf(destPassport);
        int srcReq = Integer.valueOf(srcRequisite);
        int destReq = Integer.valueOf(dstRequisite);
        Set<User3> users = map.keySet();
        int count = 0;
        for (User3 temp : users) {
            if (temp.getPassport() == src) {
                count += checkRequisites(srcReq, temp, amount);
            }
            if (temp.getPassport() == dest) {
                count += checkRequisites(destReq, temp, 0.0);
            }

        }
        if (count != 2)  {
            result = false;
        }
        return  result;
    }

    private int checkRequisites(int req, User3 temp, double amount) {
        int result = 0;
        List<Account> list = map.get(temp);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue() >= amount && list.get(i).getRequisites() == req) {
                result++;
            }
        }
        return result;
    }


}

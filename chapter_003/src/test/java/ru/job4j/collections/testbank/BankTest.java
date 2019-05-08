package ru.job4j.collections.testbank;

/**
 * Test
 * @author Shegai Evgenii
 */

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {

    @Test
    public void whenAddUserInMap() {
        User3 user = new User3("Petr", "12345");
        Bank bank = new Bank();
        bank.addUser(user);
        Map<User3, List<Account>> map = bank.getMap();
        Set<User3> users = map.keySet();
        assertThat(users.contains(user), is(true));
    }

    @Test
    public void whenAddThenDeleteUser() {
        User3 user = new User3("Petr", "12345");
        User3 user3 = new User3("Oleg", "54321");
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addUser(user3);
        bank.deleteUser(user);
        Map<User3, List<Account>> map = bank.getMap();
        Set<User3> users = map.keySet();
        assertThat(users.contains(user), is(false));
    }

    @Test
    public void whenAddAccount() {
        User3 user = new User3("Petr", "12345");
        Bank bank = new Bank();
        bank.addUser(user);
        Account account = new Account(100, "7788");
        bank.addAccountToUser("12345", account);
        Map<User3, List<Account>> map = bank.getMap();
        assertThat(map.get(user).get(0).getRequisites(), is("7788"));
    }

    @Test
    public void whenAddThenDeleteAccount() {
        User3 user = new User3("Petr", "12345");
        Bank bank = new Bank();
        bank.addUser(user);
        Account account = new Account(100, "7788");
        bank.addAccountToUser("12345", account);
        bank.deleteAccountFromUser("12345", account);
        Map<User3, List<Account>> map = bank.getMap();
        assertThat(map.containsValue(account), is(false));
    }

    @Test
    public void whenGetAccountsUser() {
        User3 user = new User3("Petr", "12345");
        Bank bank = new Bank();
        bank.addUser(user);
        Account account = new Account(100, "7788");
        bank.addAccountToUser("12345", account);
        List<Account> list = bank.getUserAccounts("12345");
        assertThat(list.get(0).getRequisites(), is("7788"));
    }

    @Test
    public void whenTransferMoney() {
        User3 user = new User3("Vova", "987654");
        User3 user2 = new User3("Misha", "34562");
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addUser(user2);
        Account account = new Account(100, "7788");
        Account account2 = new Account(10, "6644");
        bank.addAccountToUser("987654", account);
        bank.addAccountToUser("34562", account2);
        boolean result = bank.transferMoney("987654", "7788", "34562", "6644", 50.0);
        assertThat(result, is(true));
    }

}
package ru.job4j.collections;

/**
 * Test
 * @author Shegai Evgenii
 */

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTest {


    @Test
    public void whenAddUser() {
        Account account = new Account(0, 0);
        User3 user = new User3("Petr", 12345);
        account.addUser(user);
        assertThat(account.getMap().size(), is(1));
    }

    @Test
    public void whenDeleteUser() {
        Account account = new Account(0, 0);
        User3 user = new User3("Petr", 12345);
        User3 user2 = new User3("RRR", 23415);
        account.addUser(user);
        account.addUser(user2);
        account.deleteUser(user);
        assertThat(account.getMap().size(), is(1));
    }

    @Test
    public void whenAddAccountToUser() {
        Account account = new Account(100, 6789);
        User3 user = new User3("Petr", 12345);
        account.addUser(user);
        String passport = String.valueOf(user.getPassport());
        account.addAccountToUser(passport, account);
        assertThat(account.getMap().get(user).get(0).getValue(), is(100));
    }

    @Test
    public void whenDeleteAccountToUser() {
        Account account = new Account(100, 6789);
        Account account2 = new Account(200, 3456);
        User3 user = new User3("Petr", 12345);
        account.addUser(user);
        String passport = String.valueOf(user.getPassport());
        account.addAccountToUser(passport, account);
        account.addAccountToUser(passport, account2);
        account.deleteAccountFromUser(passport, account2);
        assertThat(account.getMap().get(user).size(), is(1));
    }

    @Test
    public void whenGetUserAccounts() {
        Account account = new Account(100, 6789);
        Account account2 = new Account(200, 3456);
        User3 user = new User3("Petr", 12345);
        account.addUser(user);
        String passport = String.valueOf(user.getPassport());
        account.addAccountToUser(passport, account);
        account.addAccountToUser(passport, account2);
        List<Account> list =  account.getUserAccounts(passport);
        assertThat(list.size(), is(2));
    }

    @Test
    public void whenTransferMoney() {
        Account account = new Account(100, 6789);
        Account account2 = new Account(200, 3456);
        User3 user = new User3("Petr", 12345);
        User3 user2 = new User3("Vova", 12890);
        account.addUser(user);
        account.addUser(user2);
        String passport1 = String.valueOf(user.getPassport());
        String passport2 = String.valueOf(user2.getPassport());
        String req1 = String.valueOf(6789);
        String req2 = String.valueOf(3456);
        account.addAccountToUser(passport1, account);
        account.addAccountToUser(passport2, account2);
        boolean res = account.transferMoney(passport1, req1, passport2, req2, 100);
        assertThat(res, is(true));
    }
}
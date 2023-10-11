package com.banking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(int accountNumber, String accountHolder, String accountType) {
        Account account = new Account(accountNumber, accountHolder, accountType);
        accounts.add(account);
    }


    public boolean updateAccount(int accountNumber, String newAccountHolder) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                account.updateAccountHolder(newAccountHolder);
                return true;
            }
        }
        return false;
    }

    public boolean closeAccount(int accountNumber) {
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getAccountNumber() == accountNumber) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    
    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null; // Return null if the account with the given number is not found
    }



}

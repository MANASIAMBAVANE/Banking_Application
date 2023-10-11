package com.banking;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class BankTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testCreateAccount() {
        bank.createAccount(1, "John Doe","saving");
        List<Account> accounts = bank.getAccounts();
        assertEquals(1, accounts.size());
    }

    @Test
    public void testUpdateAccount() {
        bank.createAccount(1, "John Doe","current");
        assertTrue(bank.updateAccount(1, "Jane Doe"));
        Account account = bank.getAccountByNumber(1);
        assertEquals("Jane Doe", account.getAccountHolder());
    }

    @Test
    public void testCloseAccount() {
        bank.createAccount(1, "John Doe","saving");
        assertTrue(bank.closeAccount(1));
        List<Account> accounts = bank.getAccounts();
        assertEquals(0, accounts.size());
    }

    
}




package com.banking;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AccountTest1 {
    private Account account;

    @Before
    public void setUp() {
        account = new Account(1, "John Doe","saving");
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        account.deposit(100.0);
        assertTrue(account.withdraw(50.0));
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        assertFalse(account.withdraw(50.0));
        assertEquals(0.0, account.getBalance(), 0.001);
    }
}

package com.banking;

public class Account {
    private int accountNumber;
    private String accountHolder;
    private String accountType;
    
    public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	private double balance;

    public Account(int accountNumber, String accountHolder,String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType=accountType;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\nAccount Holder: " + accountHolder + "\nBalance: $" + balance;
    }

    public void updateAccountHolder(String newAccountHolder) {
        this.accountHolder = newAccountHolder;
    }
}

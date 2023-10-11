package com.banking;

import java.util.List;
import java.util.Scanner;

public class BankingApp {
	private Bank bank;
	private Scanner scanner;
	private static double balance = 10000.00;

	public BankingApp() {
		bank = new Bank();
		scanner = new Scanner(System.in);
	}

	public void run() {
		int choice;

		do {
			displayMenu();
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				createNewAccount();
				break;
			case 2:
				updateAccountDetails();
				break;
			case 3:
				closeAccount();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				deposit();
				break;
			case 6:
				checkBalance();
				break;
			case 7:
				viewAllAccountDetails();
			    break;
			case 0:
				System.out.println("Bye! Thank you for visiting Our Bank.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 0);

		scanner.close();
	}

	private void displayMenu() {
		System.out.println("===== Banking Application Menu =====");
		System.out.println("1. Create New Account");
		System.out.println("2. Update Account Details");
		System.out.println("3. Close Account");
		System.out.println("4. Withdraw");
		System.out.println("5. Deposit");
		System.out.println("6. Check Balance");
		System.out.println("7. View Account Details");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
	}

	private void createNewAccount() {
		try {
			System.out.print("Enter account number: ");
			int accountNumber = scanner.nextInt();
			System.out.print("Enter account holder name: ");
			String accountHolder = scanner.next();
			scanner.nextLine();
			if (!isString(accountHolder)) {
				System.out.println("Invalid account holder name. Please enter a valid string.");
			}
			System.out.print("Enter account type: "); // Prompt for account type
	        String accountType = scanner.nextLine();
	        if (!isString(accountType)) {
				System.out.println("Invalid account type. Please enter a valid string.");
			}
			bank.createAccount(accountNumber, accountHolder,accountType);
			System.out.println("Account created successfully!");
		} catch (java.util.InputMismatchException e) {
			System.out.println("Invalid input for account number. Please enter a valid integer.");
			// Clear the invalid input from the scanner
			scanner.nextLine();
		}
	}

	private void updateAccountDetails() {
	    try {
	        System.out.print("Enter account number: ");
	        int accountNumber = scanner.nextInt();

	        try {
	            System.out.print("Enter new account holder name: ");
	            String newAccountHolder = scanner.next();
	            scanner.nextLine();
	            if (!isString(newAccountHolder)) {
	                System.out.println("Invalid new account holder name. Please enter a valid string.");
	            } else {
	                if (bank.updateAccount(accountNumber, newAccountHolder)) {
	                    System.out.println("Account details updated successfully!");
	                } else {
	                    System.out.println("Account not found.");
	                }
	            }
	        } catch (java.util.InputMismatchException e) {
	            System.out.println("Invalid input for account holder name. Please enter a valid string.");
	            // Clear the invalid input from the scanner
	            scanner.nextLine();
	        }

	    } catch (java.util.InputMismatchException e) {
	        System.out.println("Invalid input for account number. Please enter a valid integer.");
	        // Clear the invalid input from the scanner
	        scanner.nextLine();
	    }
	}


	private void closeAccount() {
		try {
		System.out.print("Enter account number: ");
		int accountNumber = scanner.nextInt();

		if (bank.closeAccount(accountNumber)) {
			System.out.println("Account closed successfully!");
		} else {
			System.out.println("Account not found.");
		}
	}
		catch (java.util.InputMismatchException e) {
	        System.out.println("Invalid input for account number. Please enter a correct account number.");
	        // Clear the invalid input from the scanner
	        scanner.nextLine();
	    }
	}

	private void withdraw() {
	    try {
	        System.out.println("Withdraw Amount: ");
	        System.out.println("Please enter amount:");
	        double withdrawAmount = scanner.nextDouble();
	        if (withdrawAmount > getBalance()) {
	            System.out.println("Insufficient Funds!");
	            System.out.println("A/C Balance: " + getBalance());
	        } else {
	            setBalance(getBalance() - withdrawAmount);
	            System.out.println("Please Collect Amount!");
	            System.out.println("Withdraw Successful!");
	        }
	    } catch (java.util.InputMismatchException e) {
	        System.out.println("Invalid input for withdraw amount. Please enter a valid number.");
	        // Clear the invalid input from the scanner
	        scanner.nextLine();
	    }
	}


	private void deposit() {
		try {
		System.out.println("Deposit Amount");
		System.out.println("Please enter amount: ");
		double depositAmount = scanner.nextDouble();
		setBalance(getBalance() + depositAmount);
		System.out.println("Processing, Please wait!");
		System.out.println("Deposit Successful! ");
	}
	catch (java.util.InputMismatchException e) {
        System.out.println("Invalid input for deposit amount. Please enter a valid number.");
        // Clear the invalid input from the scanner
        scanner.nextLine();
	}
}

	private void checkBalance() {
		System.out.println("Your Balance Amount: " + getBalance());
	}
	
	private void viewAllAccountDetails() {
	    List<Account> accounts = bank.getAccounts();

	    if (accounts.isEmpty()) {
	        System.out.println("No accounts found.");
	    } else {
	        System.out.println("All Created Accounts:");
	        for (Account account : accounts) {
	            System.out.println("Account Number: " + account.getAccountNumber() + " Account Holder: " + account.getAccountHolder() + " Account Type: " + account.getAccountType());
	            System.out.println(); // Add a line break between accounts
	        }
	    }
	}






	private static boolean isString(String str) {
		return str.matches("^[a-zA-Z]*$");
	}

	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		BankingApp.balance = balance;
	}
}

package service;

import model.Account;
import exception.BankException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

public class MiniBank {
    public static void main(String[] args) {

        Account a1 = new Account("AC101", "Pal", 1000);
        Account a2 = new Account("AC102", "Dhruvi", 500);

        System.out.println("Initial Account Details:");
        System.out.println(a1);
        System.out.println(a2);

        try {
            a1.withdraw(5000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Shortfall: " + e.getShortfall());
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Withdrawal attempt finished.");
        }

        System.out.println("Balance after withdrawal: " +
                a1.getBalance());

        try {
            a1.deposit(500);
            System.out.println("Deposit successful.");
            System.out.println("Balance: " + a1.getBalance());
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        try {
            a1.transfer(a2, 200);
            System.out.println("Transfer successful.");
        } catch (BankException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        System.out.println("Account 1 Balance: " + a1.getBalance());
        System.out.println("Account 2 Balance: " + a2.getBalance());

        try {
            a1.deposit(-100);
        } catch (InvalidAmountException e) {
            System.out.println("Invalid deposit: " + e.getMessage());
        }

        try (BankResource resource = new BankResource()) {
            resource.performTask();
        }

        System.out.println("Program completed.");
    }
}
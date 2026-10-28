package model;

import exception.BankException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

public class Account {
    private String accountNumber;
    private String ownerName;
    private long balance;

    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount)
            throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero.");
        }

        balance += amount;
    }

    public synchronized void withdraw(long amount)
            throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }

        balance -= amount;
    }

    public void transfer(Account to, long amount) throws BankException {
        if (to == null) {
            throw new BankException("Destination account not found.");
        }

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Transfer amount must be greater than zero.");
        }

        if (this == to) {
            throw new BankException(
                    "Cannot transfer to the same account.");
        }

        Account first = this;
        Account second = to;

        if (first.getAccountNumber().compareTo(
                second.getAccountNumber()) > 0) {
            first = to;
            second = this;
        }

        try {
            synchronized (first) {
                synchronized (second) {
                    withdraw(amount);
                    to.deposit(amount);
                }
            }
        } catch (BankException e) {
            throw e;
        } finally {
            System.out.println("Transfer operation completed.");
        }
    }

    @Override
    public String toString() {
        return accountNumber + " | " + ownerName +
                " | Balance: " + balance;
    }
}
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private String accountNumber;
    private String ownerName;
    private double balance;
    private ArrayList<String> history;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.history = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposit: " + amount);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdraw: " + amount);
        }
    }

    public synchronized ArrayList<String> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public String toString() {
        return accountNumber + " | " + ownerName + " | Balance: " + getBalance();
    }
}
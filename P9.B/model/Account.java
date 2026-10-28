package model;

public class Account {
    private String accountNumber;
    private String ownerName;
    private long balance;

    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
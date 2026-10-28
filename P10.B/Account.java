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

    public String getAccountNumber() {
        return accountNumber;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public synchronized boolean withdraw(long amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void transferTo(Account target, long amount) {
        if (target == this || amount <= 0) {
            return;
        }

        Account first;
        Account second;

        if (this.accountNumber.compareTo(target.accountNumber) < 0) {
            first = this;
            second = target;
        } else {
            first = target;
            second = this;
        }

        synchronized (first) {
            synchronized (second) {
                if (this.balance >= amount) {
                    this.balance -= amount;
                    target.balance += amount;
                    System.out.println("Transfer completed: " + amount);
                } else {
                    System.out.println("Insufficient balance");
                }
            }
        }
    }

    @Override
    public String toString() {
        return accountNumber + " | " + ownerName + " | Balance: " + getBalance();
    }
}
package model;

public abstract class Account implements Transactable, InterestBearing {
    private static int counter = 1001;

    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    public Account(String ownerName, long balance) {
        this.accountNumber = "AC" + counter++;
        this.ownerName = ownerName;
        this.balance = balance;
        this.active = true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public boolean withdraw(long amount) {
        if (amount > 0 && active && canWithdraw(amount)) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public abstract boolean canWithdraw(long amount);

    public void setActive(boolean active) {
        this.active = active;
    }
}
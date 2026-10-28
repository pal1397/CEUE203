public abstract class Account {

    private String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    private static long counter = 0;

    public Account(String ownerName, long balance) {
        counter++;
        this.accountNumber = String.format("AC%04d", counter);
        this.ownerName = ownerName;
        this.balance = balance;
        this.active = true;
    }

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);

    public boolean withdraw(long amount) {
        if (amount > 0 && active && canWithdraw(amount)) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(long amount) {
        if (amount > 0 && active) {
            balance += amount;
        }
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
}
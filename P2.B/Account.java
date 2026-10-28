public class Account {

    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    private static long accountCounter = 0;

    public Account(String ownerName, long openingBalance) {
        accountCounter++;
        this.accountNumber = String.format("AC%04d", accountCounter);
        this.ownerName = ownerName;
        this.balance = Math.max(0, openingBalance);
        this.active = true;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    public void deposit(long amount) {
        if (amount > 0 && active) {
            balance += amount;
        }
    }

    public boolean withdraw(long amount) {
        if (amount > 0 && active && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
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
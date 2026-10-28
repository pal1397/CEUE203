public class Main {

    public static void main(String[] args) {

        Account[] accounts = {
            new SavingsAccount("Pal", 10000, 2000),
            new CurrentAccount("Dhruvi", 5000, 3000),
            new FixedDepositAccount("Riya", 20000)
        };

        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Owner Name: " + account.getOwnerName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Interest Rate: " + account.interestRate() + "%");

            if (account instanceof SavingsAccount savings) {
                System.out.println("Minimum Balance: " + savings.getBalance());
            }

            System.out.println("--------------------------");
        }

        System.out.println("Savings Withdrawal: " + accounts[0].withdraw(3000));
        System.out.println("Current Withdrawal: " + accounts[1].withdraw(7000));
        System.out.println("Fixed Deposit Withdrawal: " + accounts[2].withdraw(1000));
    }
}
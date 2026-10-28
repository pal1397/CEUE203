public class Main {

    public static void main(String[] args) {

        Account[] accounts = {
            new Account("Pal", 5000),
            new Account("Dhruvi", 3000),
            new Account("Riya")
        };

        accounts[0].deposit(1000);
        accounts[1].deposit(2000);

        accounts[0].withdraw(1500);
        accounts[1].withdraw(5000);
        accounts[2].deposit(2500);

        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Owner Name: " + account.getOwnerName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Active: " + account.isActive());
            System.out.println("--------------------------");
        }
    }
}
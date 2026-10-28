import model.Account;
import java.util.ArrayList;

public class MiniBank {
    public static void main(String[] args) {
        AccountStore store = new AccountStore();

        Account a1 = new Account("AC0001", "Pal", 5000);
        Account a2 = new Account("AC0002", "Dhruvi", 2000);
        Account a3 = new Account("AC0003", "Aarav", 9000);

        store.add(a1);
        store.add(a2);
        store.add(a3);

        System.out.println("Searching Account AC0002:");

        Account found = store.get("AC0002");

        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Account not found");
        }

        a1.deposit(1000);
        a2.withdraw(500);

        System.out.println("\nTransaction History of AC0001:");
        ArrayList<String> history = a1.getHistory();

        for (String transaction : history) {
            System.out.println(transaction);
        }

        System.out.println("\nAccounts Sorted by Balance:");

        ArrayList<Account> sortedAccounts = store.sortedByBalance();

        for (Account account : sortedAccounts) {
            System.out.println(account);
        }
    }
}
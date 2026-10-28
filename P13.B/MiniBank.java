import model.Account;
import model.Customer;
import java.util.ArrayList;

public class MiniBank {
    public static void main(String[] args) {
        Repository<Account> accountRepository = new Repository<>();

        Account a1 = new Account("AC0001", "Pal", 5000);
        Account a2 = new Account("AC0002", "Dhruvi", 2000);
        Account a3 = new Account("AC0003", "Aarav", 9000);

        accountRepository.saveAll(a1, a2, a3);

        System.out.println("Searching Account AC0002:");
        System.out.println(accountRepository.findById("AC0002"));

        System.out.println("\nAll Accounts:");

        ArrayList<Account> accounts = accountRepository.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }

        System.out.println("\nAverage Balance:");

        Double[] balances = {5000.0, 2000.0, 9000.0};
        System.out.println(Repository.average(balances));

        Repository<Customer> customerRepository = new Repository<>();

        Customer c1 = new Customer("CU001", "Pal");
        Customer c2 = new Customer("CU002", "Dhruvi");

        customerRepository.saveAll(c1, c2);

        System.out.println("\nAll Customers:");

        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
    }
}
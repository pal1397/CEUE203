import model.Account;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

public class AccountStore {
    private ConcurrentHashMap<String, Account> accounts;

    public AccountStore() {
        accounts = new ConcurrentHashMap<>();
    }

    public void add(Account a) {
        accounts.put(a.getAccountNumber(), a);
    }

    public Account get(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean remove(String accountNumber) {
        return accounts.remove(accountNumber) != null;
    }

    public ArrayList<Account> sortedByBalance() {
        ArrayList<Account> list = new ArrayList<>(accounts.values());

        list.sort(Comparator.comparingDouble(Account::getBalance).reversed());

        return list;
    }
}
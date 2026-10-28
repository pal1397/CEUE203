import model.Account;
import model.AccountWorker;

public class MiniBank {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account("AC101", "Pal", 1000);

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            AccountWorker worker = new AccountWorker(account, 1000, 1);
            threads[i] = new Thread(worker, "Worker-" + (i + 1));
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
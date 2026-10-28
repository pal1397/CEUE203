import model.Account;

public class MiniBank {
    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("AC001", "Pal", 10000);
        Account accountB = new Account("AC002", "Dhruvi", 5000);

        TransactionProcessor processor = new TransactionProcessor();

        for (int i = 1; i <= 10; i++) {
            final int id = i;

            processor.submit(() -> {
                if (id % 2 == 0) {
                    accountA.deposit(100);
                    System.out.println(Thread.currentThread().getName()
                            + " deposited 100");
                } else {
                    accountA.withdraw(50);
                    System.out.println(Thread.currentThread().getName()
                            + " withdrew 50");
                }
            });
        }

        processor.stop();

        System.out.println("\nAfter thread pool transactions:");
        System.out.println(accountA);

        TransactionBuffer buffer = new TransactionBuffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.put(i * 100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    int amount = buffer.take();
                    System.out.println("Processed transaction: " + amount);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        Thread transfer1 = new Thread(
                () -> accountA.transferTo(accountB, 1000),
                "Transfer-1"
        );

        Thread transfer2 = new Thread(
                () -> accountB.transferTo(accountA, 500),
                "Transfer-2"
        );

        transfer1.start();
        transfer2.start();

        transfer1.join();
        transfer2.join();

        System.out.println("\nFinal Account Details:");
        System.out.println(accountA);
        System.out.println(accountB);
    }
}
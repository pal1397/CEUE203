import java.util.Scanner;

record BankInfo(String name, String branch) {
}

enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT
}

public class MiniBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank", "Anand");

        System.out.println("Welcome to " + bank.name());
        System.out.println("Branch: " + bank.branch());

        int choice;

        do {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            String message = switch (choice) {
                case 1 -> "Open Account - to be implemented in a later lab";
                case 2 -> "Deposit - to be implemented in a later lab";
                case 3 -> "Withdraw - to be implemented in a later lab";
                case 4 -> "Transfer - to be implemented in a later lab";
                case 5 -> "Thank you for using MiniBank!";
                default -> "Invalid choice";
            };

            System.out.println(message);

        } while (choice != 5);

        sc.close();
    }
}
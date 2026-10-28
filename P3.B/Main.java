public class Main {

    public static void main(String[] args) {

        Account a1 = new Account("AC001", "Pal", 5000);
        Account a2 = new Account("AC001", "Pal Patel", 7000);
        Account a3 = new Account("AC002", "Dhruvi", 3000);

        System.out.println("Account 1:");
        System.out.println(a1);

        System.out.println("\nAccount 2:");
        System.out.println(a2);

        System.out.println("\nAccount 3:");
        System.out.println(a3);

        System.out.println("\nAccount 1 equals Account 2: " + a1.equals(a2));
        System.out.println("Account 1 equals Account 3: " + a1.equals(a3));

        System.out.println("\nHash Code of Account 1: " + a1.hashCode());
        System.out.println("Hash Code of Account 2: " + a2.hashCode());

        Account clonedAccount = a1.clone();

        System.out.println("\nCloned Account:");
        System.out.println(clonedAccount);

        Account.Address address = new Account.Address("Anand", "Gujarat");

        System.out.println("\nAccount Address:");
        System.out.println(address);

        Object obj = a1;

        if (obj instanceof Account) {
            System.out.println("\nObject belongs to Account class.");
        }
    }
}
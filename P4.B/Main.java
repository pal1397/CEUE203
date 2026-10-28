public class Main {

    public static void main(String[] args) {

        System.out.println("Mobile Validation:");
        System.out.println(Validator.isValidMobile("9876543210"));
        System.out.println(Validator.isValidMobile("12345"));

        System.out.println("\nEmail Validation:");
        System.out.println(Validator.isValidEmail("pal@gmail.com"));
        System.out.println(Validator.isValidEmail("palgmail.com"));

        System.out.println("\nPAN Validation:");
        System.out.println(Validator.isValidPan("ABCDE1234F"));
        System.out.println(Validator.isValidPan("ABC123"));

        System.out.println("\nIFSC Validation:");
        System.out.println(Validator.isValidIfsc("SBIN0001234"));
        System.out.println(Validator.isValidIfsc("SBI123"));

        Command command = CommandParser.parse("DEPOSIT AC0001 500");

        System.out.println("\nCommand Details:");
        System.out.println("Type: " + command.type());
        System.out.println("Account Number: " + command.accountNumber());
        System.out.println("Amount: " + command.amount());

        Account account = new Account("AC0001", "Pal", 5000);

        System.out.println("\n" + StatementFormatter.buildStatement(account));
    }
}
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import model.Account;

public class MiniBank {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Path dataFile = Path.of("accounts.dat");
        Path logsFolder = Path.of("logs");
        Path logFile = logsFolder.resolve("transactions.txt");
        Path reportFile = Path.of("report.txt");

        Files.createDirectories(logsFolder);

        Account[] accounts = {
            new Account("AC001", "Pal", 5000),
            new Account("AC002", "Dhruvi", 3000)
        };

        StatePersister.save(accounts, dataFile);
        System.out.println("Accounts saved successfully.");

        Account[] loadedAccounts = StatePersister.load(dataFile);

        System.out.println("\nLoaded Accounts:");

        for (Account account : loadedAccounts) {
            System.out.println(account);
        }

        TransactionLog.append(logFile, "DEPOSIT,1000");
        TransactionLog.append(logFile, "WITHDRAW,200");
        TransactionLog.append(logFile, "DEPOSIT,500");
        TransactionLog.append(logFile, "WITHDRAW,100");

        System.out.println("\nTransaction logs saved successfully.");

        ReportGenerator.generate(logsFolder, reportFile);

        System.out.println("\nReport saved to: " + reportFile.toAbsolutePath());
    }
}
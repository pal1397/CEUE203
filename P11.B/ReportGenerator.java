import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class ReportGenerator {

    public static void generate(Path logsFolder, Path reportFile)
            throws IOException {

        long totalDeposits = 0;
        long totalWithdrawals = 0;

        StringBuilder report = new StringBuilder();

        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(logsFolder)) {

            for (Path file : stream) {
                if (!Files.isRegularFile(file)) {
                    continue;
                }

                report.append("File: ")
                      .append(file.getFileName())
                      .append(System.lineSeparator());

                try (BufferedReader reader = Files.newBufferedReader(
                        file, StandardCharsets.UTF_8)) {

                    String line;

                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");

                        if (parts.length != 2) {
                            continue;
                        }

                        try {
                            long amount = Long.parseLong(parts[1].trim());

                            if (parts[0].trim().equals("DEPOSIT")) {
                                totalDeposits += amount;
                            } else if (parts[0].trim().equals("WITHDRAW")) {
                                totalWithdrawals += amount;
                            }
                        } catch (NumberFormatException e) {
                            report.append("Invalid entry: ")
                                  .append(line)
                                  .append(System.lineSeparator());
                        }
                    }
                }

                BasicFileAttributes attributes =
                        Files.readAttributes(file, BasicFileAttributes.class);

                report.append("Size: ")
                      .append(attributes.size())
                      .append(" bytes")
                      .append(System.lineSeparator());

                report.append("Last Modified: ")
                      .append(attributes.lastModifiedTime())
                      .append(System.lineSeparator())
                      .append(System.lineSeparator());
            }
        }

        report.append("Total Deposits: ").append(totalDeposits)
              .append(System.lineSeparator());

        report.append("Total Withdrawals: ").append(totalWithdrawals)
              .append(System.lineSeparator());

        Files.writeString(
                reportFile,
                report.toString(),
                StandardCharsets.UTF_8
        );

        System.out.println(report);
    }
}
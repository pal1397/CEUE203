package service;

import model.Account;
import model.SavingsAccount;
import util.AnnotationValidator;

public class MiniBank {

    public static void main(String[] args) {

        Account invalidAccount =
                new SavingsAccount("Pal", -100, 1000);

        String[] errors =
                AnnotationValidator.validate(invalidAccount);

        System.out.println("Validation Errors:");

        if (errors.length == 0) {
            System.out.println("No errors found.");
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
        }

        Account validAccount =
                new SavingsAccount("Dhruvi", 5000, 1000);

        String[] validErrors =
                AnnotationValidator.validate(validAccount);

        System.out.println("\nValid Account:");

        if (validErrors.length == 0) {
            System.out.println("No errors found.");
        } else {
            for (String error : validErrors) {
                System.out.println(error);
            }
        }
    }
}
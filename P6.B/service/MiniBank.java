package service;

import model.*;
import util.Validator;

import static util.Validator.isValidAmount;

public class MiniBank {
    public static void main(String[] args) {
        Account savings = new SavingsAccount("Pal", 10000, 1000);
        Account current = new CurrentAccount("Dhruvi", 5000, 2000);
        Account fixed = new FixedDepositAccount("Riya", 20000);

        Account[] accounts = {savings, current, fixed};

        for (Account account : accounts) {
            System.out.println("Account: " + account.getAccountNumber());
            System.out.println("Owner: " + account.getOwnerName());
            System.out.println("Interest Rate: " + account.interestRate());
            System.out.println("Yearly Interest: " +
                    account.yearlyInterest(account.getBalance()));
            System.out.println();
        }

        WithdrawRule rule = new WithdrawRule() {
            @Override
            public boolean allow(Account account, long amount) {
                return account.canWithdraw(amount);
            }
        };

        WithdrawRule lambdaRule =
                (account, amount) -> account.canWithdraw(amount);

        Account account = accounts[0];
        long amount = 2000;

        System.out.println("Anonymous Rule: " + rule.allow(account, amount));
        System.out.println("Lambda Rule: " + lambdaRule.allow(account, amount));

        System.out.println("Valid Amount: " + isValidAmount(500));
        System.out.println("Valid Name: " + Validator.isValidName("Pal"));
    }
}
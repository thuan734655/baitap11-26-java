package org.example;
public class CheckingAccount extends BankAccount {
    private final double withdrawLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawLimit = withdrawLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds in CheckingAccount.");
        }
        if (amount > withdrawLimit) {
            throw new IllegalArgumentException("Withdraw amount exceeds the daily limit.");
        }
        balance -= amount;
    }
}

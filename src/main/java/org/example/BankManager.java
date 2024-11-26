package org.example;

import java.util.ArrayList;
import java.util.List;
public class BankManager {
    private final List<BankAccount> accounts;

    public BankManager() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void showAccounts() {
        for (BankAccount account : accounts) {
            System.out.printf("Account: %s, Owner: %s, Balance: %.2f%n",
                    account.getAccountNumber(),
                    account.getOwnerName(),
                    account.getBalance());
        }
    }

    public BankAccount getAccountByNumber(String accountNumber) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null); // Trả về null nếu không tìm thấy
    }
}

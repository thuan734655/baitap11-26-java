package org.example;
public class Main {
    public static void main(String[] args) {
        // Khởi tạo các tài khoản
        SavingsAccount savings = new SavingsAccount("SA123", "John Doe", 1000, 0.05);
        CheckingAccount checking = new CheckingAccount("CA456", "Jane Smith", 2000, 500);

        // Thực hiện giao dịch
        savings.deposit(500);
        savings.withdraw(300);
        System.out.printf("Savings Account Balance: %.2f%n", savings.getBalance());
        System.out.printf("Savings Account Interest: %.2f%n", savings.calculateInterest());

        checking.deposit(1000);
        try {
            checking.withdraw(600); // Thử rút quá giới hạn
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Quản lý tài khoản bằng BankManager
        BankManager manager = new BankManager();
        manager.addAccount(savings);
        manager.addAccount(checking);

        System.out.println("List of accounts:");
        manager.showAccounts();

        // Tìm tài khoản theo số tài khoản
        BankAccount foundAccount = manager.getAccountByNumber("CA456");
        if (foundAccount != null) {
            System.out.printf("Found Account: %s, Balance: %.2f%n",
                    foundAccount.getOwnerName(),
                    foundAccount.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}

import java.util.Scanner;

class JointAccount {
    private double balance;  

    public JointAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private JointAccount account;
    private double amount;

    public DepositThread(JointAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
    }
}

class WithdrawalThread extends Thread {
    private JointAccount account;
    private double amount;

    public WithdrawalThread(JointAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        JointAccount account = new JointAccount(1000.0);

        System.out.print("Enter the deposit amount: ");
        double depositAmount = sc.nextDouble();

        System.out.print("Enter the withdrawal amount: ");
        double withdrawalAmount = sc.nextDouble();

        DepositThread depositThread = new DepositThread(account, depositAmount);
        WithdrawalThread withdrawalThread = new WithdrawalThread(account, withdrawalAmount);

        depositThread.start(); 
        withdrawalThread.start();

        try {

            depositThread.join();
            withdrawalThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("\nFinal Account Balance: " + account.getBalance());

        sc.close();  
    }
}

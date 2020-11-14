package classstructureintegrate;

import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        String accountNumber, owner;
        int balance;
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the account number of Account1: ");
        accountNumber = scanner.nextLine();
        System.out.print("Enter the account owner's name: ");
        owner = scanner.nextLine();
        System.out.print("Enter the opening balance of the account: ");
        balance = scanner.nextInt();

        BankAccount account1 = new BankAccount(accountNumber, owner, balance);

        System.out.println(account1.getInfo());

       System.out.println("Enter the new additional deposit amount for Account1: ");
        balance = scanner.nextInt();
        account1.deposit(balance);

        System.out.println(account1.getInfo());

        System.out.println("Enter a withdraw amount for Account1: ");
        balance = scanner.nextInt();
        account1.withdraw(balance);

        System.out.println(account1.getInfo());


        scanner.nextLine();

        System.out.print("\nEnter the account number of Account2: ");
        accountNumber = scanner.nextLine();
        System.out.print("Enter the account owner's name: ");
        owner = scanner.nextLine();
        System.out.print("Enter the opening balance of the account: ");
        balance = scanner.nextInt();
        scanner.nextLine();

        BankAccount account2 = new BankAccount(accountNumber, owner, balance);

        System.out.println(account2.getInfo());

        System.out.println("Enter the new additional deposit amount for Account2: ");
        balance = scanner.nextInt();
        account2.deposit(balance);

        System.out.println(account2.getInfo());

        System.out.println("Enter a withdraw amount for Account2: ");
        balance = scanner.nextInt();
        account2.withdraw(balance);

        System.out.println(account2.getInfo());

        System.out.println("Enter the amount of transfer from Account1 to Account2: ");
        balance = scanner.nextInt();
        account1.transfer(account2, balance);


        System.out.println("Account balance info for Account1:");
        System.out.println(account1.getInfo());

        System.out.println("Account balance info for Account2:");
        System.out.println(account2.getInfo());

    }
}

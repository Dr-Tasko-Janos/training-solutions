package classstructureintegrate;

public class BankAccount {
    private String accountNumber, owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance){
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount){
        System.out.println("The amount of deposit was: " + amount);
        System.out.println("Your previous balance was: " + balance);
        this.balance += amount;
        System.out.println("Your new balance is: " + balance);
    }

    public void withdraw(int amount){
        System.out.println("The amount of withdraw was: " + amount);
        System.out.println("Your previous balance was: " + balance);
        this.balance -= amount;
        System.out.println("Your new balance is: " + balance);
    }

    public void transfer(BankAccount bankAccount, int amount){
        System.out.println("The owner's name and the number of the receiver bank account is: " +bankAccount.owner + " " + bankAccount.accountNumber);
        System.out.println("The amount of transfer was: " + amount);
        System.out.println("Your previous balance was: " + balance);
        this.balance -= amount;
        System.out.println("Your new balance is: " + balance);
        bankAccount.deposit(amount);
    }

    public String getInfo(){
        return owner + " (" + accountNumber + "): " + balance;
    }

}

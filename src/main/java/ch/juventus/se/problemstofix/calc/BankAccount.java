package ch.juventus.se.problemstofix.calc;


public class BankAccount {

    private double balance;

    public BankAccount (double balance) {
        this.balance = balance;
    }

    public void withdraw (double amount) throws InsufficientFundsException{
        if(amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds! " + (amount-balance));
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

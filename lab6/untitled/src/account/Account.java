package account;

public class Account {
    protected double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
      if (amount > 10000) {
            System.out.println(Thread.currentThread().getName() + " deposit limit exceeded for: $" + amount);
        }else if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " Successfully deposited: $" + amount + " | New Balance: $" + balance);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " tried to deposit a negative amount.");
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + "Successfully withdrew: $" + amount + " | New Balance: $" + balance);
        } else if (amount > balance) {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw $" + amount + " but not enough balance. Balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw a negative amount.");
        }
    }


}

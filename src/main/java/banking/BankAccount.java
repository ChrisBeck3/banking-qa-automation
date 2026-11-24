package banking;

// All monetary amounts are stored as cents to avoid rounding errors.
public class BankAccount {
    private long balance;

    public BankAccount(long openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Negative opening balance");
        balance = openingBalance;
    }
    public long getBalance() { return balance; }
    public void deposit(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance = Math.addExact(balance, amount);
    }
    public void withdraw(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }
}

package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    @BeforeEach void setUp() { account = new BankAccount(50000); }
    @Test void openingBalance() { assertEquals(50000, account.getBalance()); }
    @Test void validDeposit() { account.deposit(20000); assertEquals(70000, account.getBalance()); }
    @Test void validWithdrawal() { account.withdraw(10000); assertEquals(40000, account.getBalance()); }
    @Test void insufficientFunds() { assertThrows(IllegalArgumentException.class, () -> account.withdraw(50001)); assertEquals(50000, account.getBalance()); }
    @Test void negativeDeposit() { assertThrows(IllegalArgumentException.class, () -> account.deposit(-100)); assertEquals(50000, account.getBalance()); }
    @Test void negativeWithdrawal() { assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100)); assertEquals(50000, account.getBalance()); }
    @Test void zeroDeposit() { assertThrows(IllegalArgumentException.class, () -> account.deposit(0)); assertEquals(50000, account.getBalance()); }
    @Test void zeroWithdrawal() { assertThrows(IllegalArgumentException.class, () -> account.withdraw(0)); assertEquals(50000, account.getBalance()); }
    @Test void fullWithdrawal() { account.withdraw(50000); assertEquals(0, account.getBalance()); }
    @Test void negativeOpeningBalance() { assertThrows(IllegalArgumentException.class, () -> new BankAccount(-1)); }
    @Test void multipleTransactions() { account.deposit(20000); account.withdraw(10000); account.withdraw(5000); assertEquals(55000, account.getBalance()); }
    @Test void zeroOpeningBalance() { assertEquals(0, new BankAccount(0).getBalance()); }
}

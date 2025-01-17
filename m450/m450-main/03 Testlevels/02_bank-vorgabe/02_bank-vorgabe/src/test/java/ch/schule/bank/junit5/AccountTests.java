package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
public class AccountTests {
    /**
     * Testet die Initialisierung eines Kontos.
     */
    @Test
    public void testInit() {
        Account account = new SalaryAccount("1234", -10000);  // SalaryAccount is a subclass of Account
        assertEquals("1234", account.getId());
        assertEquals(0, account.getBalance());
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        Account account = new SalaryAccount("1234", -10000);

        // Deposit a positive amount
        boolean success = account.deposit(20231001, 1000);  // Deposit of 1000 units
        assertTrue(success);
        assertEquals(1000, account.getBalance());

        // Try to deposit a negative amount, should fail
        boolean failure = account.deposit(20231002, -500);
        assertFalse(failure);
        assertEquals(1000, account.getBalance());  // Balance should not change
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        Account account = new SalaryAccount("1234", -10000);

        // First, deposit an amount to allow for withdrawal
        account.deposit(20231001, 2000);

        // Successful withdrawal
        boolean success = account.withdraw(20231002, 500);
        assertTrue(success);
        assertEquals(1500, account.getBalance());

        // Try to withdraw more than the balance, should fail
        boolean failure = account.withdraw(20231003, 30000);
        assertFalse(failure);
        assertEquals(1500, account.getBalance());  // Balance should remain unchanged
    }

    /**
     * Testet die Referenz von SavingsAccount.
     */
    @Test
    public void testReferences() {
        Account savingsAccount = new SavingsAccount("4321");
        assertEquals("4321", savingsAccount.getId());
        assertEquals(0, savingsAccount.getBalance());
    }

    /**
     * Testet das canTransact Flag.
     */
    @Test
    public void testCanTransact() {
        Account account = new SalaryAccount("1234", -10000);

        // Initially, any transaction should be allowed
        assertTrue(account.canTransact(20231001));

        // Deposit a transaction on a certain date
        account.deposit(20231001, 1000);

        // Now, transactions before this date should not be allowed
        assertFalse(account.canTransact(20230930));

        // Transactions on or after the deposit date should be allowed
        assertTrue(account.canTransact(20231001));
        assertTrue(account.canTransact(20231002));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Account account = new SalaryAccount("1234", -10000);
        account.deposit(20231001, 500);
        account.withdraw(20231002, 200);

        // Just call the method to ensure no exceptions occur
        account.print();
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    public void testMonthlyPrint() {
        Account account = new SalaryAccount("1234", -10000);
        account.deposit(20231001, 1000);
        account.withdraw(20231010, 200);

        // Print the transactions for October 2023
        account.print(2023, 10);
    }

}

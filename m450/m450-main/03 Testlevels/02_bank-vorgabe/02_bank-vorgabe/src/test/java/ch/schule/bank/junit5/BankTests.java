package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
public class BankTests {

    /**
     * Tests to create new Accounts.
     */
    @Test
    public void testCreate() {
        Bank bank = new Bank();

        // Create a SavingsAccount
        String savingsId = bank.createSavingsAccount();
        assertNotNull(savingsId);
        assertTrue(savingsId.startsWith("S-"));

        // Create a PromoYouthSavingsAccount
        String promoYouthId = bank.createPromoYouthSavingsAccount();
        assertNotNull(promoYouthId);
        assertTrue(promoYouthId.startsWith("Y-"));

        // Create a SalaryAccount with a credit limit
        String salaryId = bank.createSalaryAccount(-5000);  // Credit limit -5000
        assertNotNull(salaryId);
        assertTrue(salaryId.startsWith("P-"));

        // Invalid SalaryAccount with positive credit limit
        String invalidSalaryId = bank.createSalaryAccount(1000);
        assertNull(invalidSalaryId);  // Should return null for invalid input
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        Bank bank = new Bank();

        // Create a new account
        String accountId = bank.createSavingsAccount();
        assertNotNull(accountId);

        // Deposit into the account
        boolean depositSuccess = bank.deposit(accountId, 20230915, 1000);
        assertTrue(depositSuccess);

        // Check the balance after deposit
        long balance = bank.getBalance(accountId);
        assertEquals(1000, balance);

        // Test invalid deposit (negative amount)
        boolean invalidDeposit = bank.deposit(accountId, 20230916, -500);
        assertFalse(invalidDeposit);
        assertEquals(1000, bank.getBalance(accountId));  // Balance should remain unchanged
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        Bank bank = new Bank();

        // Create a new account
        String accountId = bank.createSavingsAccount();
        assertNotNull(accountId);

        // Deposit an amount to allow withdrawal
        bank.deposit(accountId, 20230915, 2000);

        // Successful withdrawal
        boolean withdrawSuccess = bank.withdraw(accountId, 20230916, 500);
        assertTrue(withdrawSuccess);
        assertEquals(1500, bank.getBalance(accountId));

        // Invalid withdrawal (more than balance)
        boolean invalidWithdraw = bank.withdraw(accountId, 20230917, 3000);
        assertFalse(invalidWithdraw);
        assertEquals(1500, bank.getBalance(accountId));  // Balance should remain unchanged
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Bank bank = new Bank();

        // Create a new account
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 20230915, 1000);
        bank.withdraw(accountId, 20230916, 300);

        // Call print method to ensure no exceptions occur
        bank.print(accountId);
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {
        Bank bank = new Bank();

        // Create a new account
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 20230901, 1000);
        bank.withdraw(accountId, 20230910, 200);

        // Print the statement for September 2023
        bank.print(accountId, 2023, 9);
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        Bank bank = new Bank();

        // Create accounts and add balances
        String accountId1 = bank.createSavingsAccount();
        String accountId2 = bank.createSalaryAccount(-5000);
        bank.deposit(accountId1, 20230901, 2000);
        bank.deposit(accountId2, 20230901, 3000);

        // Check the total balance of the bank (should subtract the balances)
        long totalBalance = bank.getBalance();
        assertEquals(-5000, totalBalance);  // -2000 - 3000 = -5000
    }

    /**
     * Tested die Ausgabe der "top 5" Konten.
     */
    @Test
    public void testTop5() {
        Bank bank = new Bank();

        // Create multiple accounts and deposit different amounts
        bank.createSavingsAccount();
        bank.deposit("S-1000", 20230901, 500);
        bank.createSalaryAccount(-1000);
        bank.deposit("P-1001", 20230901, 300);
        bank.createSavingsAccount();
        bank.deposit("S-1002", 20230901, 700);
        bank.createPromoYouthSavingsAccount();
        bank.deposit("Y-1003", 20230901, 1000);

        // Just call the method to ensure no exceptions occur
        bank.printTop5();
    }

    /**
     * Tested die Ausgabe der "bottom 5" Konten.
     */
    @Test
    public void testBottom5() {
        Bank bank = new Bank();

        // Create multiple accounts and deposit different amounts
        bank.createSavingsAccount();
        bank.deposit("S-1000", 20230901, 500);
        bank.createSalaryAccount(-1000);
        bank.deposit("P-1001", 20230901, 300);
        bank.createSavingsAccount();
        bank.deposit("S-1002", 20230901, 700);
        bank.createPromoYouthSavingsAccount();
        bank.deposit("Y-1003", 20230901, 1000);

        // Just call the method to ensure no exceptions occur
        bank.printBottom5();
    }
}

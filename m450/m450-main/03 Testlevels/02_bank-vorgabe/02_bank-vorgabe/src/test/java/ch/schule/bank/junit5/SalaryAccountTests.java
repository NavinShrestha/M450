package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests der Klasse SalaryAccount.
 *
 * @author XXX
 * @version 1.1
 */
public class SalaryAccountTests {

	/**
	 * Testet erfolgreiche Abhebung innerhalb der Kreditlimite.
	 */
	@Test
	public void testWithdrawWithinCreditLimit() {
		// Create a SalaryAccount with a specific ID and credit limit (-10000 Millirappen)
		String accountId = "S-1001";
		long creditLimit = -10000; // -100 CHF credit limit
		SalaryAccount account = new SalaryAccount(accountId, creditLimit);

		// Initial deposit
		int date = 19001; // arbitrary date
		account.deposit(date, 5000); // Deposit 5000 Millirappen (50 CHF)

		// Attempt to withdraw an amount within the credit limit
		boolean success = account.withdraw(date, 3000); // Withdraw 3000 Millirappen (30 CHF)

		// Check if the withdrawal was successful
		assertTrue(success, "Withdrawal within credit limit should be successful");

		// Check the resulting balance (5000 - 3000 = 2000 Millirappen)
		assertEquals(2000, account.getBalance(), "The balance should be 2000 Millirappen after the withdrawal");
	}

	/**
	 * Testet Abhebung über die Kreditlimite hinaus (nicht erfolgreich).
	 */
	@Test
	public void testWithdrawExceedingCreditLimit() {
		// Create a SalaryAccount with a specific ID and credit limit (-10000 Millirappen)
		String accountId = "S-1002";
		long creditLimit = -10000; // -100 CHF credit limit
		SalaryAccount account = new SalaryAccount(accountId, creditLimit);

		// Initial deposit
		int date = 19001; // arbitrary date
		account.deposit(date, 2000); // Deposit 2000 Millirappen (20 CHF)

		// Attempt to withdraw an amount exceeding the credit limit
		boolean success = account.withdraw(date, 13000); // Try to withdraw 13000 Millirappen (130 CHF)

		// Check if the withdrawal was unsuccessful
		assertFalse(success, "Withdrawal exceeding the credit limit should fail");

		// The balance should remain the same as before the attempted withdrawal
		assertEquals(2000, account.getBalance(), "The balance should remain unchanged at 2000 Millirappen");
	}

	/**
	 * Testet eine ungültige Abhebung (negativer Betrag).
	 */
	@Test
	public void testInvalidWithdrawal() {
		// Create a SalaryAccount with a specific ID and credit limit
		String accountId = "S-1003";
		long creditLimit = -10000; // -100 CHF credit limit
		SalaryAccount account = new SalaryAccount(accountId, creditLimit);

		// Deposit into the account
		int date = 19001; // arbitrary date
		account.deposit(date, 5000); // Deposit 5000 Millirappen (50 CHF)

		// Try to withdraw a negative amount (invalid)
		boolean success = account.withdraw(date, -5000); // Invalid negative withdrawal

		// Check if the withdrawal was unsuccessful
		assertFalse(success, "Withdrawal of a negative amount should fail");

		// Check that the balance remains unchanged
		assertEquals(5000, account.getBalance(), "The balance should remain unchanged after a failed withdrawal");
	}
}

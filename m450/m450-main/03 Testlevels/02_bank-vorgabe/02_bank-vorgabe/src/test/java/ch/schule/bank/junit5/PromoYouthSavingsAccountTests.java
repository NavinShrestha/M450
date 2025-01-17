package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author XXXX
 * @version 1.0
 */
public class PromoYouthSavingsAccountTests
{
	/**
	 * Testet die Einzahlung inklusive Bonus.
	 */
	@Test
	public void testDepositWithBonus() {
		// Create a PromoYouthSavingsAccount with a specific ID
		String accountId = "Y-1001";
		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount(accountId);

		// Initial deposit and date
		int date = 19001;  // arbitrary date
		long initialDeposit = 10000;  // deposit of 10000 Millirappen (100 CHF)

		// Deposit into the account
		boolean success = account.deposit(date, initialDeposit);

		// Check if the deposit was successful
		assertTrue(success, "Deposit should be successful");

		// Expected balance after deposit, including 1% bonus (100 Millirappen)
		long expectedBalance = 10000 + 100;  // 10000 deposit + 1% bonus (100 Millirappen)

		// Verify that the balance matches the expected balance
		assertEquals(expectedBalance, account.getBalance(), "The balance should include the 1% bonus");
	}

	/**
	 * Testet eine ungültige Einzahlung (negativer Betrag).
	 */
	@Test
	public void testInvalidDeposit() {
		// Create a PromoYouthSavingsAccount with a specific ID
		String accountId = "Y-1002";
		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount(accountId);

		// Try to deposit a negative amount
		int date = 19001;  // arbitrary date
		long negativeDeposit = -5000;  // invalid negative deposit

		// Deposit into the account
		boolean success = account.deposit(date, negativeDeposit);

		// Check if the deposit was unsuccessful
		assertFalse(success, "Deposit of a negative amount should fail");

		// Verify that the balance is still zero
		assertEquals(0, account.getBalance(), "The balance should remain 0 after a failed deposit");
	}
}

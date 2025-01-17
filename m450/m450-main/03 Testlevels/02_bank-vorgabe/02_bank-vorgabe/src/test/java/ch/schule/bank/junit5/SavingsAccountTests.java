package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTests
{
	private SavingsAccount account;
	private static final int TEST_DATE = 20240913;

	@BeforeEach
	public void setUp() {
		account = new SavingsAccount("12345");
		// Initialize with a deposit for testing
		account.deposit(TEST_DATE, 1000); // Deposit 1000 units for testing
	}

	@Test
	public void testWithdrawSuccessful() {
		boolean result = account.withdraw(TEST_DATE, 500);
		assertTrue(result, "Withdrawal should be successful");
		assertEquals(500, account.getBalance(), "Balance should be 500 after withdrawal");
	}

	@Test
	public void testWithdrawInsufficientFunds() {
		boolean result = account.withdraw(TEST_DATE, 1500);
		assertFalse(result, "Withdrawal should fail due to insufficient funds");
		assertEquals(1000, account.getBalance(), "Balance should remain 1000 after failed withdrawal");
	}

	@Test
	public void testWithdrawNegativeAmount() {
		boolean result = account.withdraw(TEST_DATE, -100);
		assertFalse(result, "Withdrawal should fail due to negative amount");
		assertEquals(1000, account.getBalance(), "Balance should remain 1000 after failed withdrawal");
	}
}

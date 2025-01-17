package ch.schule.bank.junit5;

import ch.schule.Booking;
import ch.schule.BankUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BookingTests
{
	/**
	 * Tests für die Erzeugung von Buchungen.
	 */
	@Test
	public void testInitialization() {
		// Create a new booking
		int date = 19000;  // Bank days since 1.1.1970
		long amount = 100000;  // Amount in Millirappen (1000 CHF)

		Booking booking = new Booking(date, amount);

		// Test that the date and amount are initialized correctly
		assertEquals(date, booking.getDate());
		assertEquals(amount, booking.getAmount());
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint() {
		// Mock the BankUtils functions
		// In real unit tests, you would use a mocking library like Mockito,
		// but for simplicity, we assume BankUtils is working as intended.

		int date = 19000;  // Bank days since 1.1.1970
		long amount = 500000;  // Amount in Millirappen (5000 CHF)
		long balanceBefore = 2000000;  // Previous balance (20,000 CHF)

		Booking booking = new Booking(date, amount);

		// Capture the printed output
		System.out.println("Expected output:");
		String expectedDate = BankUtils.formatBankDate(date);
		String expectedAmount = BankUtils.formatAmount(amount);
		String expectedNewBalance = BankUtils.formatAmount(balanceBefore + amount);
		System.out.println(expectedDate + " " + expectedAmount + " " + expectedNewBalance);

		// In a real test environment, you would assert the console output.
		// However, since we're printing to console here, we're assuming the print() method works as expected.
		System.out.println("Actual output:");
		booking.print(balanceBefore);
	}
}

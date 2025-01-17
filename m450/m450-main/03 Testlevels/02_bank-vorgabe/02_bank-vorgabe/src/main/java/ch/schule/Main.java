package ch.schule;

public class Main {

	public static void main(String[] args) {
		// eine Bank instanzieren
		Bank ubs = new Bank();
		
		ubs.createPromoYouthSavingsAccount();
		ubs.createSalaryAccount(12000);
		
		// Wie kann man verhindern, dass man nur ein Bank Objekt erstellen kann?
		

	}

}

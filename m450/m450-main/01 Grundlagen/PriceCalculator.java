public class PriceCalculator {

    static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;

        if (extras >= 5) 
            addon_discount = 15;
        else if (extras >= 3)
            addon_discount = 10;
        else 
            addon_discount = 0;
        
        if (discount > addon_discount)
            addon_discount = discount;
        
        result = baseprice/100.0 * (100-discount) + specialprice
                + extraprice/100.0 * (100-addon_discount);
        
        return result;
    }

    public static void main(String[] args) {
        if (test_calculate_price()) {
            System.out.println("All tests passed (3/3)");
        }
        else {
            System.out.println("Some tests failed");
        }
    }

    public static boolean test_calculate_price() {
        boolean test_ok = true;
        double price;
        
        // Test 1: Keine Zusatzausstattungen, nur Grundpreis und Sondermodellaufschlag
        price = calculatePrice(10000.0, 2000.0, 0.0, 0, 0.05);  // 5% Händlerrabatt
        if (price != (10000 / 100 * (100 - 0.05) + 2000)) {
            System.out.println("Test 1 failed: Expected " + (10000 / 100 * (100 - 0.05) + 2000) + ", got " + price);
            test_ok = false;
        }
    
        // Test 2: Drei Zusatzausstattungen, 10% Rabatt auf Zubehör
        price = calculatePrice(10000.0, 2000.0, 1000.0, 3, 0.05);
        if (price != (10000 / 100 * (100 - 0.05) + 2000 + 1000 * 0.9)) {
            System.out.println("Test 3 failed: Expected " + ((10000 / 100 * (100 - 0.05) + 2000 + 1000) + 2000 + 1000 * 0.9) + ", got " + price);
            test_ok = false;
        }
    
        // Test 3: Fünf Zusatzausstattungen, 15% Rabatt auf Zubehör
        price = calculatePrice(10000.0, 2000.0, 2000.0, 5, 0.05);
        if (price != (10000 / 100 * (100 - 0.05) + 2000 + 2000 * 0.85)) {
            System.out.println("Test 4 failed: Expected " + (10000 / 100 * (100 - 0.05) + 2000 + 2000 * 0.85) + ", got " + price);
            test_ok = false;
        }
    
        // Test 4: Kein Rabatt auf Grundpreis, vier Zusatzausstattungen, 10% Rabatt auf Zubehör
        price = calculatePrice(10000.0, 2000.0, 1500.0, 4, 0.0);
        if (price != (10000 + 2000 + 1500 * 0.9)) {
            System.out.println("Test 5 failed: Expected " + (10000 + 2000 + 1500 * 0.9) + ", got " + price);
            test_ok = false;
        }
    
        return test_ok;
    }
    
}

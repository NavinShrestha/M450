package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressComparatorTest {

    private Address address1;
    private Address address2;
    private Address address3;
    private Address address4;
    private List<Address> addressList;

    @BeforeEach
    void setUp() {
        // Erstelle Address-Objekte mit unterschiedlichen Attributen
        address1 = new Address(1, "John", "Doe", "1234567890", new Date(2024, 9, 1));
        address2 = new Address(2, "Jane", "Smith", "0987654321", new Date(2024, 8, 1));
        address3 = new Address(3, "Alice", "Doe", "5432167890", new Date(2024, 7, 1));
        address4 = new Address(4, "Alice", "Doe", "1234567890", new Date(2024, 6, 1));

        addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);
        addressList.add(address4);
    }

    @Test
    void testComparatorSortOrder() {
        // Sortiere die Liste mit dem erweiterten AddressComparator
        Collections.sort(addressList, new AddressComparator());

        // Überprüfe die korrekte Sortierreihenfolge
        assertEquals("Doe", addressList.get(0).getLastname());
        assertEquals("Alice", addressList.get(0).getFirstname());
        assertEquals("1234567890", addressList.get(0).getPhonenumber());
        assertEquals(new Date(2024, 6, 1), addressList.get(0).getRegistrationDate());

        assertEquals("Doe", addressList.get(1).getLastname());
        assertEquals("Alice", addressList.get(1).getFirstname());
        assertEquals("5432167890", addressList.get(1).getPhonenumber());
        assertEquals(new Date(2024, 7, 1), addressList.get(1).getRegistrationDate());

        assertEquals("Doe", addressList.get(2).getLastname());
        assertEquals("John", addressList.get(2).getFirstname());
        assertEquals("1234567890", addressList.get(2).getPhonenumber());
        assertEquals(new Date(2024, 9, 1), addressList.get(2).getRegistrationDate());

        assertEquals("Smith", addressList.get(3).getLastname());
        assertEquals("Jane", addressList.get(3).getFirstname());
        assertEquals("0987654321", addressList.get(3).getPhonenumber());
        assertEquals(new Date(2024, 8, 1), addressList.get(3).getRegistrationDate());
    }
}

package ch.tbz.m450.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address(1, "John", "Doe", "1234567890", new Date());
    }

    @Test
    void testGetters() {
        assertEquals(1, address.getId());
        assertEquals("John", address.getFirstname());
        assertEquals("Doe", address.getLastname());
        assertEquals("1234567890", address.getPhonenumber());
    }

    @Test
    void testSetters() {
        address.setFirstname("Jane");
        address.setLastname("Smith");
        address.setPhonenumber("0987654321");

        assertEquals("Jane", address.getFirstname());
        assertEquals("Smith", address.getLastname());
        assertEquals("0987654321", address.getPhonenumber());
    }
}

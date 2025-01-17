package ch.tbz.m450.service;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    private Address address;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        address = new Address(1, "John", "Doe", "1234567890", null);
    }

    @Test
    void testSave() {
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        Address savedAddress = addressService.save(address);

        assertEquals("John", savedAddress.getFirstname());
        assertEquals("Doe", savedAddress.getLastname());
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void testGetAll() {
        List<Address> addressList = Arrays.asList(
                new Address(1, "John", "Doe", "1234567890", null),
                new Address(2, "Jane", "Smith", "0987654321", null)
        );

        when(addressRepository.findAll()).thenReturn(addressList);

        List<Address> result = addressService.getAll();

        assertEquals(2, result.size());
        assertEquals("Doe", result.get(0).getLastname());
        assertEquals("Smith", result.get(1).getLastname());
    }

    @Test
    void testGetAddress() {
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));

        Optional<Address> result = addressService.getAddress(1);

        assertEquals(true, result.isPresent());
        assertEquals("John", result.get().getFirstname());
    }
}

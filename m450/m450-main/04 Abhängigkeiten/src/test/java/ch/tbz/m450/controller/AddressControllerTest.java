package ch.tbz.m450.controller;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address(1, "John", "Doe", "1234567890", null);
    }

    @Test
    void testCreateAddress() throws Exception {
        when(addressService.save(any(Address.class))).thenReturn(address);

        mockMvc.perform(post("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"firstname\":\"John\",\"lastname\":\"Doe\",\"phonenumber\":\"1234567890\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstname").value("John"));
    }

    @Test
    void testGetAddresses() throws Exception {
        when(addressService.getAll()).thenReturn(Arrays.asList(address));

        mockMvc.perform(get("/address"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstname").value("John"));
    }

    @Test
    void testGetAddress() throws Exception {
        when(addressService.getAddress(1)).thenReturn(Optional.of(address));

        mockMvc.perform(get("/address/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname").value("John"));
    }
}

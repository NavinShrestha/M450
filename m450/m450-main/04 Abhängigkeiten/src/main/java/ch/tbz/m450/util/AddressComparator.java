package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        // Zuerst nach Nachnamen sortieren
        int lastNameComparison = a1.getLastname().compareToIgnoreCase(a2.getLastname());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        // Wenn Nachnamen gleich sind, nach Vornamen sortieren
        int firstNameComparison = a1.getFirstname().compareToIgnoreCase(a2.getFirstname());
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        // Wenn Vornamen auch gleich sind, nach Telefonnummer sortieren
        int phoneComparison = a1.getPhonenumber().compareToIgnoreCase(a2.getPhonenumber());
        if (phoneComparison != 0) {
            return phoneComparison;
        }

        // Wenn Telefonnummern auch gleich sind, nach Registrierungsdatum sortieren
        return a1.getRegistrationDate().compareTo(a2.getRegistrationDate());
    }
}

package com.learning.springpetclinicdemo.testsupport.factories;

import com.learning.springpetclinicdemo.entity.Owner;

public class OwnerFactory {

    public static Owner createJohnDoe() {
        return new Owner("John", "Doe", "123 Main St", "Anytown", "555-1234");
    }

    public static Owner createJaneSmith() {
        return new Owner("Jane", "Smith", "456 Elm St", "Othertown", "555-5678");
    }

    // Method to create an Owner with dynamic data
    public static Owner createOwner(String firstName, String lastName, String address, String city, String telephone) {
        return new Owner(firstName, lastName, address, city, telephone);
    }
}

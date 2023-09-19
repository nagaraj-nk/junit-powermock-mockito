package com.srjons;

public class GeocodeApi {

    public static String getAddress(String zipcode) {
        return zipcode.equalsIgnoreCase("600100") ? "Chennai" : "";
    }
}

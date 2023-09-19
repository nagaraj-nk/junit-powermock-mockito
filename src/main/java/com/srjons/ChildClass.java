package com.srjons;

import java.util.List;
import java.util.function.Supplier;

public class ChildClass extends ParentClass {

    DatabaseRepo databaseRepo = new DatabaseRepo();

    public String childMethod() {
        return parentMethod();
    }

    public String someTestForPrivateMethod() {
        return privateMethod();
    }

    public String privateMethod() {
        return "privateMethod";
    }

    public List<String> findAll() {
        return databaseRepo.findItems();
    }

    public String validateZipcode(String zipcode) {
        return GeocodeApi.getAddress(zipcode);
    }
}

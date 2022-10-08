package com.srjons;

import java.util.List;

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
}

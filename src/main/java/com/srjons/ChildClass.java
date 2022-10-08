package com.srjons;

public class ChildClass extends ParentClass {

    MockDatabaseRepo mockDatabaseRepo;

    public String childMethod() {
        return parentMethod();
    }
}

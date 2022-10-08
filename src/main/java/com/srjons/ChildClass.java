package com.srjons;

public class ChildClass extends ParentClass {

    MockDatabaseRepo mockDatabaseRepo;

    public String childMethod() {
        return parentMethod();
    }

    public String someTestForPrivateMethod() {
        return privateMethod();
    }

    public String privateMethod() {
        return "privateMethod";
    }
}

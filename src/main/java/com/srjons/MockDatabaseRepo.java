package com.srjons;

import java.util.List;

public class MockDatabaseRepo {

    public List<String> findItems() {
        return List.of("Hi", "Hello");
    }
}

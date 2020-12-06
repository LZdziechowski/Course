package com.kodilla.spring.library;

import org.springframework.stereotype.Repository;

@Repository
public class LibraryDbController {

    public void saveData() {
        System.out.printf("Saving data to the database.");
    }

    public void loadData() {
        System.out.printf("Loaded data from the database");
    }
}

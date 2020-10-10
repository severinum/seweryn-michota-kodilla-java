package com.kodilla.spring.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public Library() {
    }

    public Library(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public void saveToDb(){
        libraryDbController.saveData();
    }

    public void loadFromDb(){
        libraryDbController.loadData();
    }
}

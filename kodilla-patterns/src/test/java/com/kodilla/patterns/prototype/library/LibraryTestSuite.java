package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuite {

    @Test
    void testGetBooks(){
        // given
        Library library = new Library("National Library");

        library.getBooks().add(new Book("The lean startup","Eric Ries", LocalDate.of(2018,01,20)));
        library.getBooks().add(new Book("Design Data-Intensive Applications","Martin Kleppmann", LocalDate.of(2017,05,10)));
        library.getBooks().add(new Book("Code Complete","Steve McConnel", LocalDate.of(1993,04,05)));
        library.getBooks().add(new Book("The C Programming Language","Dennis Ritchie", LocalDate.of(1978,02,01)));

        // making shallow copy of the object library
        Library councilLibrary = null;
        try {
            councilLibrary = library.shallowCopy();
            councilLibrary.setName("Council Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // making a deep copy of the object library
        Library townHallLibrary = null;
        try {
            townHallLibrary = library.deepCopy();
            townHallLibrary.setName("Town Hall Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // add new book to deep copy of the library object
        townHallLibrary.getBooks().add(new Book("Clean Code","Robert Cecil Martin", LocalDate.of(2008, 07, 01)));

        // when
        // then
        assertEquals(4, library.getBooks().size());
        assertEquals(4, councilLibrary.getBooks().size());
        assertEquals(5, townHallLibrary.getBooks().size());
        assertEquals(councilLibrary.getBooks(), library.getBooks());
        assertNotEquals(townHallLibrary.getBooks(), library.getBooks());
    }

}
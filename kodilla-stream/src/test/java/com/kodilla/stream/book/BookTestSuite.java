package com.kodilla.stream.book;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BookTestSuite {

    @Test
    void testGetListUsingFor(){
        // given
        BookDirectory bookDirectory = new BookDirectory();
        // when
        List<Book> books = bookDirectory.getList();
        // then
        int numberOfBooksPublishedAfter2007 = 0;
        for(Book book: books){
            if(book.getYearOfPublication() > 2007){
                numberOfBooksPublishedAfter2007++;
            }
        }
        assertEquals(3, numberOfBooksPublishedAfter2007);
    }

    @Test
    void testGetListUsingIntStream(){
        // given
        BookDirectory bookDirectory = new BookDirectory();
        // when
        List<Book> books = bookDirectory.getList();
        // then
        int numberOfBooksPublishedAfter2007 = IntStream.range(0, books.size())
                .filter( n -> books.get(n).getYearOfPublication() > 2007)
                .map(n -> 1)
                .sum();
        assertEquals(3, numberOfBooksPublishedAfter2007);
    }

    @Test
    void testButUseCount_toMakeItEasier() {
        // given
        BookDirectory bookDirectory = new BookDirectory();
        // when
        List<Book> books = bookDirectory.getList();
        // then
        long numberOfBooksPublishedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();
        assertEquals(3, numberOfBooksPublishedAfter2007);
    }
}
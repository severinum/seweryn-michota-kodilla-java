package com.kodilla.stream.immutable;

public final class Book {
    private final String title;
    private final String author;
    private final int yearOfPublication;

    public Book(final String title, final String author, final int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    /*
    It is not allowed to declate setter. Field has final value and can not be changed.
    public void modifyYearOfPublication(int year){
        this.yearOfPublication = year;
    }
     */
}

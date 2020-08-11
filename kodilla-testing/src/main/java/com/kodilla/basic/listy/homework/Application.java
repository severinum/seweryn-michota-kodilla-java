package com.kodilla.basic.listy.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        calculateAverageWithoutExtremes();
        displayBooks();
    }

    public static void calculateAverageWithoutExtremes(){
        List<Integer> marks = new ArrayList<>(){{
            add(3);
            add(3);
            add(3);
            add(4);
            add(4);
            add(4);
            add(5);
            add(5);
            add(5);
            add(5);
            add(6);
            add(6);
        }};

        double average = 0;
        int sum = 0;

        for ( int i = 1; i < marks.size()-1; i++) {
            System.out.println(marks.get(i));
            sum += marks.get(i);
        }
        average = (double) sum / (marks.size()-2);

        System.out.println("Average (without extreme values): " + average);
    }

    public static void displayBooks(){
        System.out.println("\n#------------------ BOOKS ----------------- #");
        List<Book> books = new LinkedList<>(){{
            add(new Book("Middlematch", 1980));
            add(new Book("The Human Stain", 2001));
            add(new Book("Angels and Demons", 2000));
            add(new Book("Crow Lake", 2002));
            add(new Book("The Road", 2006));
            add(new Book("The Eye of The World", 1990));
        }};

        for (Book book : books)
            if(book.getYear() >= 2000)
                System.out.println(book);

    }

}

class Book {
    private String title;
    private int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return title + ", " + year;
    }
}
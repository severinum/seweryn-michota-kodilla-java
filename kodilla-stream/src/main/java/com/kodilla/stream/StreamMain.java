package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        /*
        Processor processor = new Processor();
        processor.execute(()-> System.out.println("This is an example tex."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);


        // String beautifier test
        System.out.println("String beautifier test");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String basicString = "Ala ma kota";
        String str1 = poemBeautifier.beautify(basicString, (str) -> "ABC " + str);
        String str2 = poemBeautifier.beautify(basicString, (str) -> str + " ABC");
        String str3 = poemBeautifier.beautify(basicString, (str) -> str.toUpperCase());
        String str4 = poemBeautifier.beautify(basicString, (str) -> str.toLowerCase());
        String str5 = poemBeautifier.beautify(basicString, (str) -> str.replace(" ", "-"));

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);

        // Streams

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

         */

        /* OPERACJE NA STREAMACH
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);

        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0,1).equals("M"))
                .forEach(System.out::println);

         */

        /* BOOK - streams
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());
        System.out.println("# eements: "  + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);


        Map<String, Book> booksMap = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        booksMap.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);


        System.out.println("\nCollectors.joining - zastosowanie\n");
        String theResultString = theBookDirectory.getList().stream()
               .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<", ">>"));

        System.out.println(theResultString);


        /* FORUM USER HOMEWORK
        System.out.println("\nForum Users Filtering\n");
        Forum forum = new Forum();
        Map<Integer, ForumUser> filteredForumUsers = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> {
                    LocalDate now = LocalDate.now();
                    return Period.between(user.getBday(), now).getYears() >= 20;
                })
                .filter(user -> user.getPostNumber() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        filteredForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);

         */



    }
}

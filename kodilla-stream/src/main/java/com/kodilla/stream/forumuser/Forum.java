package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        usersList.add(new ForumUser(1,"Adam", 'M', LocalDate.of(1980, 01, 01), 2));
        usersList.add(new ForumUser(2,"Thomas", 'M', LocalDate.of(1982, 05, 12), 15));
        usersList.add(new ForumUser(3,"Keith", 'M', LocalDate.of(2000, 11, 03), 50));
        usersList.add(new ForumUser(4,"Natasha", 'F', LocalDate.of(1990, 01, 22), 57));
        usersList.add(new ForumUser(5,"Stewart", 'M', LocalDate.of(1980, 01, 07), 0));
        usersList.add(new ForumUser(6,"Brandon", 'M', LocalDate.of(1999, 11, 10), 23));
        usersList.add(new ForumUser(7,"Anna", 'F', LocalDate.of(1980, 02, 19), 523));
        usersList.add(new ForumUser(8,"Martha", 'F', LocalDate.of(1998, 12, 20), 8));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(usersList);
    }
}

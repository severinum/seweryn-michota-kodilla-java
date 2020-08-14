package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String name;
    private final char sex;
    private final LocalDate bday;
    private final int postNumber;

    public ForumUser(int id, String name, char sex, LocalDate bday, int postNumber) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.bday = bday;
        this.postNumber = postNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBday() {
        return bday;
    }

    public int getPostNumber() {
        return postNumber;
    }

    @Override
    public String toString() {
        return "ForumUser {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", bday=" + bday +
                ", postNumber=" + postNumber +
                '}';
    }
}

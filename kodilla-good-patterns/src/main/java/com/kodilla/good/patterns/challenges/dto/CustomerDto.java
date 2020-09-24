package com.kodilla.good.patterns.challenges.dto;

public class CustomerDto {

    private int id;
    private String fname;
    private String lname;

    public CustomerDto(int id, String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}

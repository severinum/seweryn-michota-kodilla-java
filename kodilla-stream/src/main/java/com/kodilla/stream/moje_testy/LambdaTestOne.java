package com.kodilla.stream.moje_testy;

import java.util.*;

public class LambdaTestOne {

    public static void main(String[] args) {
        new Thread( () -> {
            System.out.println("Ala ma kota");
            System.out.println("Kot ma alę");
        } ).start();

        Employee joh = new Employee("John", 33);
        Employee tim = new Employee("Tim", 29);
        Employee jack = new Employee("Jack", 33);
        Employee snow = new Employee("White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(joh);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        for(Employee employee: employees){
            System.out.println(employee.getName());
        }




    }

}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
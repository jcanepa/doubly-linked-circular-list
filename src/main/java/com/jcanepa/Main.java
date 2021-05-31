package com.jcanepa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main
{
    public static void main(String[] args)
    {
        Person[] people = {
                new Person("Walter", "White"),
                new Person("Jesse", "Pinkman"),
                new Person("Saul", "Goodman"),
                new Person("Mike", "Ehrmantraut"),
                new Person("Hank", "Schroder"),
                new Person("Gustavo", "Fring"),
        };

        // Sort using Comparable
        System.out.println("~ Natural ordering (by Id):");
        Arrays.sort(people);
        Arrays.stream(people).forEach(System.out::println);

        // sort using Comparator field
        System.out.println("~ Sort by last name:");
        Arrays.sort(people, Person.sortByLastName);
        Arrays.stream(people).forEach(System.out::println);

        // sort using Comparator field
        System.out.println("~ Sort by id:");
        Arrays.sort(people, Person.sortById);
        Arrays.stream(people).forEach(System.out::println);

        // add them to a DLCL:
        var list = new DoublyLinkedCircularList<Person>();
        System.out.println("~ As a doubly-linked circular list:");
        Arrays.stream(people).forEach(list::add);
        System.out.println(list);
    }
}

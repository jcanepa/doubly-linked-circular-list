package com.jcanepa;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) {
        var list = new DoublyLinkedCircularList<Person>();

        var walter = new Person("Walter", "White");
        var jesse = new Person("Jesse", "Pinkman");

        list.add(walter);
        list.add(jesse);
        list.add(new Person("Saul", "Goodman"));
        list.add(new Person("Mike", "Ehrmantraut"));
//        list.add(new Person("Hank", "Schroder"));
//        list.add(new Person("Gustavo", "Fring"));

        System.out.println(list);

        Person son = new Person("Walter", "White, Jr.");
        son.setId(walter.getId());
//        System.out.println(list);
//
//        System.out.println(list.contains(son));
//        list.add(son);
//        System.out.println(list);

        // sort
        Person[] people = {
                walter,
                jesse,
                new Person("Saul", "Goodman"),
                new Person("Mike", "Ehrmantraut"),
                son
        };

        Arrays.sort(people);
        Arrays.stream(people)
              .forEach(System.out::println);

        // another way to do it
        var ppl = new ArrayList<Person>(
                Arrays.asList(people));
        ppl.forEach(System.out::println);
    }
}

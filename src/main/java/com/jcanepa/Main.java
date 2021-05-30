package com.jcanepa;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class Main
{
    public static void main(String[] args) {
        var list = new DoublyLinkedCircularList<Person>();

        var walter = new Person("Walter", "White");

        list.add(walter);
        list.add(new Person("Jesse", "Pinkman"));
        list.add(new Person("Saul", "Goodman"));
        list.add(new Person("Mike", "Ehrmantraut"));
        list.add(new Person("Hank", "Schroder"));
        list.add(new Person("Gustavo", "Fring"));

        System.out.println(list);

        Person other = new Person("Walter", "White");
        other.setId(walter.getId());
        System.out.println(list);

        System.out.println(list.contains(other));
        list.add(other);
        System.out.println(list);
    }
}

package com.jcanepa;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) {
        var list = new DoublyLinkedCircularList<Person>();

        list.add(new Person("Walter", "White"));
        list.add(new Person("Jesse", "Pinkman"));
        list.add(new Person("Saul", "Goodman"));
        list.add(new Person("Mike", "Ehrmantraut"));
        list.add(new Person("Hank", "Schroder"));
        list.add(new Person("Gustavo", "Fring"));

        list.removeLast();

        System.out.println(list);
    }
}

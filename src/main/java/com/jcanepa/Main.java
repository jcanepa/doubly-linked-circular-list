package com.jcanepa;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class Main
{
    public static void main(String[] args) {
        var list = new DoublyLinkedCircularList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        System.out.println(list);
    }
}

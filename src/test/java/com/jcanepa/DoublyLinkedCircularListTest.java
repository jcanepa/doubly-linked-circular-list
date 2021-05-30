package com.jcanepa;

import junit.framework.TestCase;

public class DoublyLinkedCircularListTest extends TestCase {

    public void testAddFirst() {
        var list = new DoublyLinkedCircularList<String>();
        String string = "foo";

        list.add(string);

        assertEquals(string, list.getFirst());
        assertEquals(string, list.getLast());
        assertTrue(list.contains(string));
    }

    public void testAddLast() {
    }

    public void testGetNextNode() {
    }

    public void testGetPreviousNode() {
    }
}
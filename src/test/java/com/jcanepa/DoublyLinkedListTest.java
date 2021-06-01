package com.jcanepa;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    @Test
    public void testAdd()
    {
        var list = new DoublyLinkedList<String>();
        String string = "foo";

        assertTrue(list.add(string));
        assertEquals(1, list.size());
        assertTrue(list.contains(string));
        assertEquals(string, list.getLast());
    }

    @Test
    public void testAddAtIndex()
    {
        var list = new DoublyLinkedList<String>();
        String data = "foo";
        int index = 1;

        list.add(0, "bar");
        list.add(0, "qux");
        list.add(index, data);
        // foo, qux, bar

        assertEquals(data, list.get(index));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtInvalidIndexThrowsException()
    {
        var list = new DoublyLinkedList<String>();
        list.add(99, "foo");
    }

    @Test
    public void testAddFirst()
    {
        var list = new DoublyLinkedList<String>();
        int size = 0;
        String one = "foo";
        String two = "bar";

        list.addFirst(one);
        size ++;

        assertEquals(size, list.size());
        assertEquals(one, list.getFirst());

        list.addFirst(two);
        size ++;

        assertEquals(size, list.size());
        Assert.assertNotSame(one, list.getFirst());
        assertEquals(two, list.getFirst());
    }

    @Test
    public void testAddLast()
    {
        var list = new DoublyLinkedList<String>();

        String string = "foo";

        list.addFirst("baz");
        list.addFirst("buzz");
        list.addFirst("qux");
        list.addLast(string);
        // qux, buzz, baz, foo

        assertEquals(4, list.size());
        assertEquals(string, list.getLast());
    }

    @Test
    public void testRemove()
    {
        var list = new DoublyLinkedList<String>();
        String string1 = "first";
        String string2 = "middle";
        String string3 = "last";

        list.add(string1);
        list.add(string2);
        list.add(string3);
        assertEquals(3, list.size());

        list.remove(1);

        assertEquals(2, list.size());
        assertFalse(list.contains(string2));
    }

    @Test
    public void testRemoveFirst()
    {
        var list = new DoublyLinkedList<String>();
        String first = "foo";
        list.addFirst(first);

        assertEquals(
                first,
                list.getFirst());

        String returnedString = list.removeFirst();
        assertEquals(
                first,
                returnedString);

        assertFalse(
                list.contains(first));

        assertNotEquals(
                first,
                list.getFirst());

        assertEquals(
                0,
                list.size());
    }

    @Test
    public void testRemoveLast()
    {
        var list = new DoublyLinkedList<String>();
        String last = "last";

        list.add("one");
        list.add("two");
        list.add("three");
        list.add(last);

        assertEquals(
                last,
                list.getLast());

        assertTrue(
                list.contains(last));

        String returnedValue = list.removeLast();

        assertEquals(last, returnedValue);

        assertFalse(
                list.contains(last));

        assertNotEquals(
                last,
                list.getLast());

        assertEquals(
                3,
                list.size());
    }

    @Test
    public void testGet()
    {
        var list = new DoublyLinkedList<String>();
        String target = "a";

        list.addFirst(target);
        list.addFirst("b");
        list.addFirst("c");

        assertEquals(
                target,
                list.get(2));
    }

    @Test
    public void testGetFirst()
    {
        var list = new DoublyLinkedList<Integer>();
        Integer first = 1;

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        assertEquals(
                first,
                list.getFirst());
    }

    @Test
    public void testGetLast()
    {
        var list = new DoublyLinkedList<String>();
        String last = "foo";

        list.addLast("bar");
        list.addLast("baz");
        list.addLast(last);

        assertEquals(
                last,
                list.getLast());
    }

    @Test
    public void testEmptyListReturnsNull()
    {
        var list = new DoublyLinkedList<String>();

        Assert.assertNull(list.getLast());
        Assert.assertNull(list.getFirst());
    }

    @Test
    public void testSize()
    {
        var list = new DoublyLinkedList<Integer>();
        int items = 9;

        for (int i = 0; i < items; i ++) {
            list.add(i);
        }

        assertEquals(items, list.size());
    }

    @Test
    public void testClear()
    {
        var list = new DoublyLinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    public void testContains()
    {
        var list = new DoublyLinkedList<Integer>();
        int max = 3;

        for (int i = 0; i < max; i ++) {
            list.add(i);
            assertTrue(list.contains(i));
        }
    }

    @Test
    public void testSet()
    {
        var list = new DoublyLinkedList<String>();
        String insert = "kotlin";
        int position = 1;

        // 0
        list.add("java");
        // 1
        list.add("php");
        // 2
        list.add("python");

        list.set(position, insert);

        // 0 - php
        // 1 - kotlin
        // 2 - python
        assertEquals(insert, list.get(position));
    }
}
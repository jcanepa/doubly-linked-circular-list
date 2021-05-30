package com.jcanepa;

import junit.framework.TestCase;

public class PersonTest extends TestCase {

    public void testGetFirstName() {
        String first = "Walter";

        var person = new Person(first, "White");

        assertEquals(first, person.getFirstName());
    }

    public void testGetLastName() {
        String last = "Pinkman";

        Person person = new Person("Jesse", last);

        assertEquals(last, person.getLastName());
    }

    public void testGetId() {
        var person = new Person("Gus", "Fring");

        assertEquals(9, person.getId().length());
    }

    public void testGetFullName() {
        String first = "Saul";
        String last = "Goodman";

        var person = new Person(first, last);

        assertEquals(
                first + " " + last,
                person.getName()
        );
    }
}
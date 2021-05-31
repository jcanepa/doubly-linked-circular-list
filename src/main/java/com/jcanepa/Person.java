package com.jcanepa;

import java.util.Objects;
import java.util.Random;

public class Person implements Comparable<Person>{
    private String id;
    private final String last;
    private final String first;

    public Person(String firstName, String lastName)
    {
        setId(generateId());
        this.last = lastName;
        this.first = firstName;
    }

    /**
     * @return The person's first name.
     */
    public String getFirstName() {
        return first;
    }

    /**
     * @return The person's last name.
     */
    public String getLastName() {
        return last;
    }

    /**
     * @return The person's ID number.
     */
    public String getId() {
        return id;
    }

    /**
     * Generate a random 9-digit ID.
     */
    private String generateId() {
        StringBuilder randomId = new StringBuilder();

        var rand = new Random();

        for (int i = 0; i < 9; i++) {
            randomId.append(
                    rand.nextInt(10));
        }

        return randomId.toString();
    }

    /**
     * Temporary to test equality for contains method in linked list classes.
     * @// TODO: 5/30/21 Remove this method, or make it protected
     */
    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return Objects.equals(first, person.first)
                && Objects.equals(last, person.last)
                && Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, getId());
    }

    @Override
    public int compareTo(Person o) {
        return Integer.parseInt(id) - Integer.parseInt(o.getId());
    }

    /**
     * @return The person's full name.
     */
    public String getName() {
        return getFirstName()
                + " "
                + getLastName();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name: '" + getName() + '\'' +
                ", id: '" + id + '\'' +
                '}';
    }
}

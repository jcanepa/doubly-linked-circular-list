package com.jcanepa;

import java.util.Comparator;
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
     * @return The person's full name.
     */
    public String getName() {
        return getFirstName()
                + " "
                + getLastName();
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

    private void setId(String id)
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

    public static final Comparator<Person> sortByLastName = new Comparator<Person>() {
        @Override
        public int compare(Person a, Person b) {
            return a.getLastName().compareTo(b.getLastName());
        }
    };

    public static final Comparator<Person> sortById = new Comparator<Person>() {
        @Override
        public int compare(Person a, Person b) {
            return Integer.parseInt(a.getId()) - Integer.parseInt(b.getId());
        }
    };

    @Override
    public String toString() {
        return "Person{" +
                "name: '" + getName() + '\'' +
                ", id: '" + id + '\'' +
                '}';
    }
}

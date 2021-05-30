package com.jcanepa;

import java.util.Random;

public class Person {
    private final String first;
    private final String last;
    private String id;

    public Person(String firstName, String lastName)
    {
        generateId();

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
    private void generateId() {
        StringBuilder randomID = new StringBuilder();

        var rand = new Random();

        for (int i = 0; i < 9; i++) {
            randomID.append(
                    rand.nextInt(10));
        }

        id = randomID.toString();
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
        return "Person {" +
                "first: '" + first + '\'' +
                ", last: '" + last + '\'' +
                ", id: '" + id + '\'' +
                '}';
    }
}

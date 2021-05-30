package com.jcanepa;

public interface LinkedList<T>
{
    /**
     * Inserts the specified element at the specified position in this list.
     */
    void add(int index, T element);

    /**
     * Inserts the specified element to the end of this list.
     */
    boolean add(T element);

    /**
     * Inserts the specified element at the beginning of this list.
     */
    void addFirst(T element);

    /**
     * Appends the specified element to the end of this list.
     */
    void addLast(T element);

    /**
     * Retrieves and removes the head (first element) of this list.
     */
    T remove(int index);

    /**
     * Removes and returns the first element from this list.
     */
    T removeFirst();

    /**
     * Removes and returns the last element from this list.
     */
    T removeLast();

    /**
     * Returns the element at the specified position in this list.
     */
    T get(int index);

    /**
     * Returns the first element in this list.
     */
    T getFirst();

    /**
     * Returns the last element in this list.
     */
    T getLast();

    /**
     * Returns the number of elements in this list.
     */
    int size();

    /**
     * Removes all of the elements from this list.
     */
    void clear();

    /**
     *  Returns true if this list contains the specified element.
     */
    boolean contains(T element);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     */
    void set(int index, T data);
}

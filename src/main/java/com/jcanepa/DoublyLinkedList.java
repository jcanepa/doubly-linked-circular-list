package com.jcanepa;

import java.util.function.Predicate;

public class DoublyLinkedList<T> implements LinkedList<T>
{
    private Node<T> head;
    private int size;

    public DoublyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add a new node to the end of the list and the insertion result.
     * @return Whether the data was inserted successfully.
     */
    public boolean add(T data)
    {
        int prior = size();

        addLast(data);

        return (prior + 1) == size()
                && getLast() == data;
    }

    /**
     * Add a new node at the given index.
     * @param index to place a new node.
     * @param data of type T.
     */
    @Override
    public void add(int index, T data)
    {
        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size()) {
            addLast(data);
            return;
        }

        Node<T> existing = getNode(index);

        if (existing == null)
            throw new IndexOutOfBoundsException();

        Node<T> node = new Node<>(data);
        Node<T> previous = existing.getPrevious();

        previous.setNext(node);
        node.setPrevious(previous);
        node.setNext(existing);
        existing.setPrevious(node);

        incrementSize();
    }

    /**
     * Add a new node to the front of the list.
     * @param data of type T.
     */
    @Override
    public void addFirst(T data)
    {
        Node<T> node = new Node<>(data);

        if (head != null) {
            node.setNext(head);
            head.setPrevious(node);
        }

        head = node;
        incrementSize();
    }

    /**
     * Add a new element to the end of the list.
     * @param data of type T.
     */
    @Override
    public void addLast(T data)
    {
        if (size() == 0) {
            addFirst(data);
            return;
        }

        Node<T> node = new Node<>(data);
        Node<T> last = getLastNode();

        last.setNext(node);
        node.setPrevious(last);

        incrementSize();
    }

    /**
     * Remove the list node at a given index and return its data.
     * @param index of the element to be removed.
     * @return T data of the node removed.
     */
    @Override
    public T remove(int index)
    {
        if (index == 0) {
            return removeFirst();
        }

        if (index == (size() - 1)) {
            return removeLast();
        }

        T data = null;

        if (getNode(index) != null) {
            Node<T> node = getNode(index);

            if (node.hasPrevious()) {
                getPreviousNode(node).setNext(
                    getNextNode(node)
                );
            }

            if (node.hasNext()) {
                getNextNode(node).setPrevious(
                    getPreviousNode(node)
                );
            }

            data = node.getData();

            node.setPrevious(null);
            node.setNext(null);

            decrementSize();
        }
        return data;
    }

    /**
     * Remove the first item in the list by detaching
     * pointer references. Finally, return its data.
     * @return T data of the node removed.
     */
    @Override
    public T removeFirst()
    {
        T data = null;

        if (head != null) {
            data = head.getData();

            /*
             * If there's no next node because the head
             * was the only one in the list, this will be null
             */
            head = head.getNext();

            /* Detach pointers if needed */
            if (head != null) {
                resetHeadPrevious();
            }

            decrementSize();
        }
        return data;
    }

    /**
     * Remove the last item in the list by detaching all
     * pointer references. Finally, return the removed node's data.
     * @return T data of the node removed.
     */
    @Override
    public T removeLast()
    {
        T data = null;

        Node<T> last = getLastNode();

        if (last != null) {
            data = getLast();

            last.getPrevious().setNext(null);
            last.setPrevious(null);

            decrementSize();
        }
        return data;
    }

    /**
     * Get the data at a given index.
     * @param index of the desired node.
     * @return data of type T.
     */
    @Override
    public T get(int index)
    {
        Node<T> node = getNode(index);

        return (node != null)
                ? node.getData()
                : null;
    }

    /**
     * Return the node at a valid given index if it exists. Otherwise, return null.
     * @param index of the desired node.
     * @return The node at a valid given index.
     */
    protected Node<T> getNode(int index)
    {
        Node<T> result = null;

        if (isExisting.test(index)) {
            Node<T> node = head;
            int count = 0;

            while (count < index) {
                node = getNextNode(node);
                count ++;
            }

            result = node;
        }
        return result;
    }


    /**
     * Return the first node that heads the list.
     * @return the node that occupies the list's first position.
     */
    protected Node<T> getFirstNode() {
        return head;
    }

    /**
     * Return the last node in the list.
     * @return the node that occupies the list's last position.
     */
    protected Node<T> getLastNode()
    {
        return getNode(size() - 1);
    }

    /**
     * Get the data of the first node in the list.
     * @return the data of type T.
     */
    @Override
    public T getFirst()
    {
        return (getFirstNode() != null)
                ? getFirstNode().getData()
                : null;
    }

    /**
     * Get the data of the last node in the list.
     * @return the data of type T.
     */
    @Override
    public T getLast()
    {
        return (size() > 0)
            ? getLastNode().getData()
            : null;
    }

    /**
     * Get a given node's next pointer node.
     * @param node to check.
     * @return node next to a given node.
     */
    protected Node<T> getNextNode(Node<T> node) {
        return node.getNext();
    }

    /**
     * Get a given node's previous pointer node.
     * @param node to check.
     * @return node previous to a given node.
     */
    protected Node<T> getPreviousNode(Node<T> node) {
        return node.getPrevious();
    }

    /**
     * Set the head's previous node.
     * Sets value to null to detach it's pointer.
     */
    protected void resetHeadPrevious()
    {
        head.setPrevious(null);
    }

    /**
     * Return the number of nodes within the list.
     * @return the amount of nodes in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Increase the list's size by one.
     */
    protected void incrementSize() {
        size ++;
    }

    /**
     * Decrease the list's size by one.
     */
    protected void decrementSize() {
        size --;
    }

    /**
     * Detach all nodes in the list.
     */
    @Override
    public void clear()
    {
        while (getFirstNode() != null) {
            removeFirst();
        }
    }

    /**
     * Determine whether data of type T is stored in the list.
     * @param data of type T to check.
     * @return if the list contains a given data.
     */
    @Override
    public boolean contains(T data)
    {
        Node<T> node = head;
        int count = 0;

        while (node != null && count < size()) {
            if (node.getData().equals(data)) {
                return true;
            }
            node = node.getNext();
            count ++;
        }
        return false;
    }

    /**
     * Replaces the node at a specified list position with the specified element.
     * @param index of node to replace.
     * @param data of type T to replace the existing node with.
     */
    @Override
    public void set(int index, T data)
    {
        remove(index);
        add(index, data);
    }

    /**
     * Determine if a given index is within a valid range of list nodes.
     */
    private final Predicate<Integer> isExisting = index ->
            index < size && index >= 0;

    /**
     * Detail the list type, size and its nodes.
     * @return a string representation of the list and its contents.
     */
    @Override
    public String toString()
    {
        var output = new StringBuilder();

        output.append(getClass().getSimpleName())
              .append(" with ")
              .append(size())
              .append(" nodes:\n");

        for (int i = 0; i < size(); i ++) {
            output.append(
                    getNode(i));
        }
        return output.toString();
    }

    static class Node<T>
    {
        protected T data;
        protected Node<T> next;
        protected Node<T> previous;

        protected Node(T data) {
            this.data = data;
            next = null;
            previous = null;
        }

        protected void setNext(Node<T> node) {
            next = node;
        }

        protected void setPrevious(Node<T> node) {
            previous = node;
        }

        public T getData() {
            return data;
        }

        protected Node<T> getNext() {
            return next;
        }

        protected Node<T> getPrevious() {
            return previous;
        }

        protected boolean hasNext() {
            return getNext() != null;
        }

        protected boolean hasPrevious() {
            return getPrevious() != null;
        }

        @Override
        public String toString()
        {
            var output = new StringBuilder();

            output.append("Node{")
                  .append(data);

            if (hasPrevious()) {
                output.append(", previous: ")
                      .append(
                          getPrevious().getData());
            }

            if (hasNext()) {
                output.append(", next: ")
                      .append(
                          getNext().getData());
            }

            output.append("}\n");

            return output.toString();
        }
    }
}

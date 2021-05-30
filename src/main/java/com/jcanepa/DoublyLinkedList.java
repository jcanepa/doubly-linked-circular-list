package com.jcanepa;

import java.util.function.Predicate;

public class DoublyLinkedList<T> implements LinkedList<T> {
    protected Node<T> head;
    private int size;

    public DoublyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add a new node to the end of the list.
     * @return Whether the data was inserted successfully.
     */
    public boolean add(T data)
    {
        int prior = size();

        addLast(data);

        return (prior + 1) == size()
                && contains(data);
    }

    /**
     * Add a new node at the given index.
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

        // Update all three node pointers accordingly.
        if (previous != null) {
            previous.setNext(node);
            node.setPrevious(previous);
        }

        node.setNext(existing);
        existing.setPrevious(node);

        size ++;
    }

    /**
     * Add a new node to the front of the list.
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
        size ++;
    }

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

        size ++;
    }

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
        }
        return data;
    }

    /**
     * Remove the first item in the list by detaching
     * all pointer references. Finally, return its data.
     * @return T data
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

            /* Detach pointers */
            if (head != null) {
                head.setPrevious(null);
            }

            size --;
        }
        return data;
    }

    /**
     * Remove the last item in the list by detaching all
     * pointer references. Finally, return the removed node's data.
     * @return the data of type T.
     */
    @Override
    public T removeLast()
    {
        T data = null;

        if (getLastNode() != null) {
            data = getLast();

            Node<T> last = getLastNode();
            last.getPrevious().setNext(null);
            last.setPrevious(null);

            size --;
        }
        return data;
    }

    /**
     * Get the node at the given index.
     * @param index in the list
     * @return the data of type T.
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
     * Return the node at a valid given index if it exists.
     * Otherwise, return null.
     * @param index in the list
     * @return The node at a valid given index
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
     */
    protected Node<T> getFirstNode() {
        return head;
    }

    protected Node<T> getLastNode()
    {
        return getNode(size() - 1);
    }

    @Override
    public T getFirst()
    {
        return (getFirstNode() != null)
                ? getFirstNode().getData()
                : null;
    }

    @Override
    public T getLast()
    {
        return (size() > 0)
            ? getLastNode().getData()
            : null;
    }

    /**
     * Get a given node's next pointer node.
     */
    protected Node<T> getNextNode(Node<T> node) {
        return node.getNext();
    }

    /**
     * Get a given node's previous pointer node.
     */
    protected Node<T> getPreviousNode(Node<T> node) {
        return node.getPrevious();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear()
    {
        while (getFirstNode() != null) {
            removeFirst();
        }
    }

    @Override
    public boolean contains(T data)
    {
        Node<T> node = head;

        while (node != null) {
            if (node.getData().equals(data)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public void set(int index, T data)
    {
        remove(index);
        add(index, data);
    }

    /**
     * Determine if a given index is within the valid range.
     */
    private final Predicate<Integer> isExisting = index ->
            index < size && index >= 0;

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
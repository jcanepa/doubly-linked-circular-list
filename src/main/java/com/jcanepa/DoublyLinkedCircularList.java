package com.jcanepa;

public class DoublyLinkedCircularList<T> extends DoublyLinkedList<T>
{
    public DoublyLinkedCircularList() {
        super();
    }

    @Override
    public void addFirst(T data) {
        super.addFirst(data);
        linkFirstAndLastNodes();
    }

    @Override
    public void addLast(T data) {
        super.addLast(data);
        linkFirstAndLastNodes();
    }

    @Override
    protected Node<T> getNextNode(Node<T> node)
    {
        if (node.getNext() == null) {
            return getFirstNode();
        }
        return super.getNextNode(node);
    }

    @Override
    protected Node<T> getPreviousNode(Node<T> node)
    {
        if (node.getPrevious() == null) {
            return getLastNode();
        }
        return super.getPreviousNode(node);
    }

    /**
     * Connect the list's fist and last nodes together.
     */
    private void linkFirstAndLastNodes()
    {
        linkFirstNodeToLast();
        linkLastNodeToFirst();
    }

    /**
     * Attach the first node's pointer reference to the last.
     */
    private void linkFirstNodeToLast()
    {
        getFirstNode().setPrevious(
                getLastNode());
    }

    /**
     * Attach the last node's pointer reference to the first.
     */
    private void linkLastNodeToFirst()
    {
        getLastNode().setNext(
                getFirstNode());
    }
}
package com.jcanepa;

public class DoublyLinkedCircularList<T> extends DoublyLinkedList<T>
{
    /**
     * Link the first and last nodes after adding a new element to the beginning of the list.
     */
    @Override
    public void addFirst(T data) {
        super.addFirst(data);
        linkFirstAndLastNodes();
    }

    /**
     * Link the first and last nodes after adding a new element to the end of the list.
     */
    @Override
    public void addLast(T data) {
        super.addLast(data);
        linkFirstAndLastNodes();
    }

    /**
     * For nodes with a null next pointer (e.g. the list's last node), link to the first node.
     * Otherwise default to the next node when it is set.
     */
    @Override
    protected Node<T> getNextNode(Node<T> node)
    {
        if (node.getNext() == null) {
            return getFirstNode();
        }
        return super.getNextNode(node);
    }

    /**
     * For nodes with a null previous pointer (e.g. the list's first node), link to the last node.
     * Otherwise default to the previous node when it is set.
     */
    @Override
    protected Node<T> getPreviousNode(Node<T> node)
    {
        if (node.getPrevious() == null) {
            return getLastNode();
        }
        return super.getPreviousNode(node);
    }

    /**
     * Since all nodes in a circular linked list have next and previous nodes,
     * protect against infinite loops using a counter.
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
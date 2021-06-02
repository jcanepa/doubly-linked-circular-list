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

            node.getPrevious().setNext(
                        node.getNext());

            node.getNext().setPrevious(
                    node.getPrevious());

            data = node.getData();

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

        if (getLastNode() != null) {
            data = getLast();

            Node<T> last = getLastNode();

            // setup the new last element
            Node<T> newLast = last.getPrevious();
            newLast.setNext(getFirstNode());
            getFirstNode().setPrevious(newLast);

            // detach the existing last
            last.setPrevious(null);
            last.setNext(null);

            decrementSize();
        }
        return data;
    }

    /**
     * Set the head node's previous node to the list's last node.
     */
    @Override
    protected void resetHeadPrevious() {
        linkFirstNodeToLast();
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
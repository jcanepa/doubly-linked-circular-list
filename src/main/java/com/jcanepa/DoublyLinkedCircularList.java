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

            size --;
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
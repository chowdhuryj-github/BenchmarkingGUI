/*
 * Course: CSC1120
 * Fall 2023
 * Labs 5 and 6
 * Name: Chris Taylor
 * Created: 6/27/2023
 */
package datastructures;

import java.util.List;

/**
 * Extends csc1120.LinkedList to provide improved performance when
 * calling {@code get()} sequentially.
 *
 * @author taylor
 * @version 20231011.0
 * @param <E> Type stored in the List
 * @see LinkedList
 * @see java.util.Collection
 * @see List
 */
public class LinkedListTurbo<E> extends LinkedList<E> implements List<E> {
    /**
     * The index most recently access by a call to {@code get()}.
     */
    private int lastIndex;

    /**
     * The node most recently access by a call to {@code get()}.
     */
    private Node<E> lastNode;

    /**
     * Constructs an empty list.
     */
    public LinkedListTurbo() {
        lastIndex = Integer.MAX_VALUE;
        lastNode = head;
    }

    /**
     * Constructs a list with the elements passed in
     * @param elements elements to be added to the list
     */
    public LinkedListTurbo(E[] elements) {
        super(elements);
        lastIndex = Integer.MAX_VALUE;
        lastNode = head;
    }

    /**
     * Returns the element at the specified position in this list.
     * To improve performance, the method keeps track of the
     * most recently accessed node and uses it to navigate to
     * the desired index if doing so would reduce the number
     * of nodes that must be visited.
     *
     * @param index {@code index} of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        }
        int count = 0;
        Node<E> walker = head;
        if (index >= lastIndex) {
            walker = lastNode;
            count = lastIndex;
        }
        while (count < index) {
            walker = walker.next;
            count++;
        }
        lastIndex = index;
        lastNode = walker;
        return walker.value;
    }
}

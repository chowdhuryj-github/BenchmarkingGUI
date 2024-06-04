/*
 * Course: CSC1120
 * Fall 2023
 * Labs 5 and 6
 * Name: Chris Taylor
 * Created: 6/27/2023
 */
package datastructures;

import java.util.*;

/**
 * A simple singly-linked list implementation of the java.util.List interface.
 * This is a partial implementation to be used for benchmarking.
 *
 * @author taylor
 * @version 20231011.0
 * @param <E> Type stored in the List
 * @see Collection
 * @see List
 */
public class LinkedList<E> implements List<E> {
    /**
     * Reference to the first element in the list
     */
    protected Node<E> head;

    /**
     * The number of elements in the list
     */
    protected int size;

    /**
     * Inner class representing a node in the list.
     * @param <E> Type stored in the Node
     */
    protected static class Node<E> {
        /**
         * The value of the element in the list.
         */
        protected E value;

        /**
         * Link to the next node in the list
         */
        protected Node<E> next;

        /**
         * Creates a node with the specified {@code value} and
         * {@code next} node.
         */
        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Constructs an empty list.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Constructs a list with the elements passed in
     * @param elements elements to be added to the list
     */
    public LinkedList(E[] elements) {
        size = 0;
        head = null;
        for (E element : elements) {
            add(0, element);
        }
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code target} such that
     * {@code Objects.equals(target, e)}.
     *
     * @param target {@code target} element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(Object target) {
        boolean found = false;
        Node<E> walker = head;
        while (!found && walker != null) {
            found = Objects.equals(target, walker.value);
            walker = walker.next;
        }
        return found;
    }

    /**
     * Removes all elements from this list.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
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
        while (count < index) {
            walker = walker.next;
            count++;
        }
        return walker.value;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index {@code index} at which the specified element is to be inserted
     * @param element {@code element} to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws UnsupportedOperationException thrown if the index is not 0
     */
    @Override
    public void add(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index > 0) {
            throw new UnsupportedOperationException("Implementation only works for index == 0.");
        }
        head = new Node<>(element, head);
        size++;
    }

    //region Methods without implementation
    /**
     * Not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param <T> not implemented
     * @param a not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param e ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param o ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param c ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param c ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param index ignored
     * @param c ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param c ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param c ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param index ignored
     * @param element ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param index ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param o ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param o ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param index ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     *
     * @param fromIndex ignored
     * @param toIndex ignored
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not implemented.");
    }
    //endregion
}

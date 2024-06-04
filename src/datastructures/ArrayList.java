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
 * A simple array-based implementation of the java.util.List interface.
 * This is a partial implementation to be used for benchmarking.
 *
 * @author taylor
 * @version 20230627.1
 * @param <E> Type stored in the list
 * @see Collection
 * @see List
 */
public class ArrayList<E> implements List<E> {
    /**
     * Array that holds the elements in the list
     */
    private Object[] data;

    /**
     * Constructs an empty list.
     */
    public ArrayList() {
        data = new Object[0];
    }

    /**
     * Constructs a list with the elements passed in
     * @param elements elements to be added to the list
     */
    public ArrayList(E[] elements) {
        data = Arrays.copyOf(elements, elements.length);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return data.length;
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
        for (int i = 0; !found && i < data.length; i++) {
            found = Objects.equals(target, data[i]);
        }
        return found;
    }

    /**
     * Removes all elements from this list.
     */
    @Override
    public void clear() {
        data = new Object[0];
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index {@code index} of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        return (E) data[index];
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index {@code index} at which the specified element is to be inserted
     * @param element {@code element} to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws UnsupportedOperationException if index is not 0
     */
    @Override
    public void add(int index, E element) throws UnsupportedOperationException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index > 0) {
            throw new UnsupportedOperationException("Implementation only works for index == 0.");
        }
        Object[] temp = new Object[data.length + 1];
        temp[0] = element;
        System.arraycopy(data, 0, temp, 1, data.length);
        data = temp;
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
     * @param <T> Type stored in the array
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
     * @param e not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param o not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param c not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param c not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param index not implemented
     * @param c not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param c not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param c not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param index not implemented
     * @param element not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param index not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param o not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param o not implemented
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
     * @param index not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Not implemented
     * @param fromIndex not implemented
     * @param toIndex not implemented
     * @return not implemented
     * @throws UnsupportedOperationException not implemented
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not implemented.");
    }
    //endregion
}

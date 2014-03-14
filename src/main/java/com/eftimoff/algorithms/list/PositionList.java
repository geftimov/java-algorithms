package com.eftimoff.algorithms.list;

import java.util.Iterator;

public interface PositionList<T> extends Iterable<T> {

    /** Returns the number of elements in this list. */
    public int size();

    /** Returns whether the list is empty. */
    public boolean isEmpty();

    /** Returns the first node in the list. */
    public Position<T> first() throws EmptyListException;

    /** Returns the last node in the list. */
    public Position<T> last() throws EmptyListException;

    /** Returns the node after a given node in the list. */
    public Position<T> next(Position<T> p) throws InvalidPositionException,
	    BoundaryViolationException;

    /** Returns the node before a given node in the list. */
    public Position<T> prev(Position<T> p) throws InvalidPositionException,
	    BoundaryViolationException;

    /** Inserts an element at the front of the list, returning new position. */
    public void addFirst(T e);

    /** Inserts and element at the back of the list, returning new position. */
    public void addLast(T e);

    /** Inserts an element after the given node in the list. */
    public void addAfter(Position<T> p, T e) throws InvalidPositionException;

    /** Inserts an element before the given node in the list. */
    public void addBefore(Position<T> p, T e) throws InvalidPositionException;

    /** Removes a node from the list, returning the element stored there. */
    public T remove(Position<T> p) throws InvalidPositionException;

    /** Replaces the element stored at the given node, returning old element. */
    public T set(Position<T> p, T e) throws InvalidPositionException;

    public Iterator<T> iterator();

    /** Returns an iterable collection of all the nodes in the list. */
    public Iterable<Position<T>> positions();
}

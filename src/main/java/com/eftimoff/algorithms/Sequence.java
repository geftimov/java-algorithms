package com.eftimoff.algorithms;

import com.eftimoff.algorithms.deque.Deque;
import com.eftimoff.algorithms.list.BoundaryViolationException;
import com.eftimoff.algorithms.list.IndexList;
import com.eftimoff.algorithms.list.InvalidPositionException;
import com.eftimoff.algorithms.list.Position;
import com.eftimoff.algorithms.list.PositionList;

/**
 * An interface for a sequence, a data structure supporting all operations of a
 * deque, indexed list and position list.
 */
public interface Sequence<E> extends Deque<E>, IndexList<E>, PositionList<E> {
    /** Returns the position containing the element at the given index. */
    public Position<E> atIndex(int r) throws BoundaryViolationException;

    /** Returns the index of the element stored at the given position. */
    public int indexOf(Position<E> p) throws InvalidPositionException;
}
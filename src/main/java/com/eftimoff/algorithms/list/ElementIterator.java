package com.eftimoff.algorithms.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementIterator<T> implements Iterator<T> {
    protected PositionList<T> list; // the underlying list
    protected Position<T> cursor; // the next position

    /** Creates an element iterator over the given list. */
    public ElementIterator(PositionList<T> L) {
	list = L;
	cursor = (list.isEmpty()) ? null : list.first();
    }

    public boolean hasNext() {
	return (cursor != null);
    }

    public T next() throws NoSuchElementException {
	if (cursor == null)
	    throw new NoSuchElementException("No next element");
	T toReturn = cursor.element();
	cursor = (cursor == list.last()) ? null : list.next(cursor);
	return toReturn;
    }

    @Override
    public void remove() {

    }
}
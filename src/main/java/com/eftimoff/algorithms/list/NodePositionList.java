package com.eftimoff.algorithms.list;

import java.util.Iterator;

public class NodePositionList<T> implements PositionList<T> {

    private DNode<T> header;
    private DNode<T> trailer;
    private int size;

    public NodePositionList() {
	header = new DNode<T>();
	trailer = new DNode<T>();
	trailer.setPrev(header);
	header.setNext(trailer);
	size = 0;
    }

    @Override
    public int size() {
	return size;
    }

    @Override
    public boolean isEmpty() {
	return size == 0;
    }

    @Override
    public Position<T> first() throws EmptyListException {
	if (isEmpty()) {
	    throw new EmptyListException("The List is empty");
	}
	return header.getNext();
    }

    @Override
    public Position<T> last() throws EmptyListException {
	if (isEmpty())
	    throw new EmptyListException("List is empty");
	return trailer.getPrev();
    }

    @Override
    public Position<T> next(Position<T> p) throws InvalidPositionException,
	    BoundaryViolationException {
	DNode<T> dNode = checkPosition(p);
	DNode<T> next = dNode.getNext();
	if (next == trailer) {
	    throw new BoundaryViolationException(
		    "Can not advance pasth the beginning of the list.");
	}
	return next;
    }

    @Override
    public Position<T> prev(Position<T> p) throws InvalidPositionException,
	    BoundaryViolationException {
	DNode<T> dNode = checkPosition(p);
	DNode<T> prev = dNode.getPrev();
	if (prev == header) {
	    throw new BoundaryViolationException(
		    "Can not advance pasth the beginning of the list.");
	}
	return prev;
    }

    @Override
    public void addFirst(T element) {
	DNode<T> newNode = new DNode<T>();
	newNode.setElement(element);
	newNode.setPrev(header);
	newNode.setNext(header.getNext());
	header.getNext().setPrev(newNode);
	header.setNext(newNode);
	size++;
    }

    @Override
    public void addLast(T element) {
	DNode<T> newNode = new DNode<T>(element, trailer, trailer.getPrev());
	trailer.setPrev(newNode);
	trailer.getPrev().setNext(newNode);
	size++;
    }

    @Override
    public void addAfter(Position<T> position, T element)
	    throws InvalidPositionException {
	DNode<T> dNode = checkPosition(position);
	DNode<T> newPosition = new DNode<T>(element, dNode.getNext(), dNode);
	dNode.getNext().setPrev(newPosition);
	dNode.setNext(newPosition);
	size++;
    }

    @Override
    public void addBefore(Position<T> position, T element)
	    throws InvalidPositionException {
	DNode<T> dNode = checkPosition(position);
	DNode<T> newPosition = new DNode<T>(element, dNode, dNode.getPrev());
	dNode.getPrev().setNext(newPosition);
	dNode.setPrev(newPosition);
	size++;
    }

    @Override
    public T remove(Position<T> position) throws InvalidPositionException {
	DNode<T> dNode = checkPosition(position);
	T temp = dNode.element();
	dNode.getPrev().setNext(dNode.getNext());
	dNode.getNext().setPrev(dNode.getPrev());
	dNode.setNext(null);
	dNode.setPrev(null);
	size--;
	return temp;
    }

    @Override
    public T set(Position<T> position, T element)
	    throws InvalidPositionException {
	DNode<T> dNode = checkPosition(position);
	T temp = dNode.element();
	dNode.setElement(element);
	return temp;
    }

    /**
     * Checks if position is valid for this list and converts it to DNode if it
     * is valid; O(1) time
     */
    protected DNode<T> checkPosition(Position<T> p)
	    throws InvalidPositionException {
	if (p == null)
	    throw new InvalidPositionException(
		    "Null position passed to NodeList");
	if (p == header)
	    throw new InvalidPositionException(
		    "The header node is not a valid position");
	if (p == trailer)
	    throw new InvalidPositionException(
		    "The trailer node is not a valid position");
	try {
	    DNode<T> temp = (DNode<T>) p;
	    if ((temp.getPrev() == null) || (temp.getNext() == null))
		throw new InvalidPositionException(
			"Position does not belong to a valid NodeList");
	    return temp;
	} catch (ClassCastException e) {
	    throw new InvalidPositionException(
		    "Position is of wrong type for this list");
	}
    }

    @Override
    public Iterator<T> iterator() {
	return new ElementIterator<T>(this);
    }

    /** Returns an iterable collection of all the nodes in the list. */
    @Override
    public Iterable<Position<T>> positions() { // create a list of posiitons
	PositionList<Position<T>> P = new NodePositionList<Position<T>>();
	if (!isEmpty()) {
	    Position<T> p = first();
	    while (true) {
		P.addLast(p); // add position p as the last element of list P
		if (p == last())
		    break;
		p = next(p);
	    }
	}
	return P; // return P as our Iterable object
    }

    @Override
    public String toString() {
	Iterator<T> iterator = iterator();
	for (Iterator iterator2 = iterator(); iterator2.hasNext();) {
	    T type = (T) iterator2.next();
	    System.out.print(type+"   ");

	}
	return super.toString();
    }
}

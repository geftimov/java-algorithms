package com.eftimoff.algorithms.list;

public class DNode<T> implements Position<T> { // The element stored in the node
    private T element;
    // Links to the next and previous node
    private DNode<T> next, prev;

    public DNode() {
	this(null, null, null);
    }

    // Constructor (element, next, previous)
    public DNode(T e, DNode<T> n, DNode<T> p) {
	this.element = e;
	this.next = n;
	this.prev = p;
    }

    public DNode<T> getNext() {
	return next;
    }

    public DNode<T> getPrev() {
	return this.prev;
    }

    // Update methods
    public void setElement(T e) {
	this.element = e;
    }

    public void setNext(DNode<T> n) {
	this.next = n;
    }

    public void setPrev(DNode<T> p) {
	this.prev = p;
    }

    // Implemented method
    public T element() throws InvalidPositionException {
	if ((prev == null) && (next == null)) {
	    throw new InvalidPositionException("The position is not valid.");
	}
	return this.element;
    }
}

package com.eftimoff.algorithms.deque;

public class NodeDeque<T> implements Deque<T> {

    private DNode<T> header;
    private DNode<T> trailer;
    private int size;

    public NodeDeque() {
	this.header = new DNode<T>();
	this.trailer = new DNode<T>();
	this.header.setNext(this.trailer);
	this.trailer.setPrev(this.header);
	this.size = 0;
    }

    @Override
    public int size() {
	return this.size;
    }

    @Override
    public boolean isEmpty() {
	return size == 0;
    }

    @Override
    public T getFirst() throws EmptyDequeException {
	if (isEmpty()) {
	    throw new EmptyDequeException("Deque is empty.");
	}
	return this.header.getNext().getElement();
    }

    @Override
    public T getLast() throws EmptyDequeException {
	if (isEmpty()) {
	    throw new EmptyDequeException("Deque is empty.");
	}
	return this.trailer.getNext().getElement();
    }

    @Override
    public void addFirst(T element) {
	final DNode<T> node = new DNode<T>(element);
	DNode<T> next = this.header.getNext();
	node.setNext(next);
	this.header = new DNode<T>();
	this.header.setNext(node);
	node.setPrev(this.header);
	next.setPrev(node);
	size += 1;
    }

    @Override
    public void addLast(T element) {
	final DNode<T> node = new DNode<T>(element);
	DNode<T> prev = this.trailer.getPrev();
	node.setNext(this.trailer);
	node.setPrev(prev);
	this.trailer = new DNode<T>();
	this.trailer.setPrev(node);
	prev.setNext(node);
	size += 1;
    }

    @Override
    public T removeFirst() throws EmptyDequeException {
	if (size == 0) {
	    throw new AssertionError("Deque is empty.");
	}
	T element = this.header.getNext().getElement();
	final DNode<T> preNext = this.header.getNext().getNext();
	this.header.setNext(preNext);
	preNext.setPrev(this.header);
	size -= 1;
	return element;
    }

    @Override
    public T removeLast() throws EmptyDequeException {
	if (size == 0) {
	    throw new AssertionError("Deque is empty.");
	}
	T element = this.trailer.getPrev().getElement();
	final DNode<T> prePrev = this.trailer.getPrev().getPrev();
	this.trailer.setPrev(prePrev);
	prePrev.setNext(this.trailer);
	size -= 1;
	return element;
    }

    public static class DNode<T> {
	private T element;
	private DNode<T> next;
	private DNode<T> prev;

	public DNode() {
	    this(null, null, null);
	}

	public DNode(T element) {
	    this(element, null, null);
	}

	public DNode(T element, DNode<T> next, DNode<T> prev) {
	    this.element = element;
	    this.next = next;
	    this.prev = prev;
	}

	public T getElement() {
	    return element;
	}

	public DNode<T> getNext() {
	    return next;
	}

	public DNode<T> getPrev() {
	    return prev;
	}

	public void setElement(T element) {
	    this.element = element;
	}

	public void setNext(DNode<T> next) {
	    this.next = next;
	}

	public void setPrev(DNode<T> prev) {
	    this.prev = prev;
	}
    }

}

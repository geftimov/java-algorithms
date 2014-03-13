package com.eftimoff.algorithms.stack;

public class NodeStack<T> implements Stack<T> {

    private Node<T> head;
    private int size;

    public NodeStack() {
	head = null;
	size = 0;
    }

    @Override
    public int size() {
	return this.size;
    }

    @Override
    public boolean isEmpty() {
	if (this.head == null) {
	    return true;
	}
	return false;
    }

    @Override
    public T top() throws EmptyStackException {
	if (isEmpty()) {
	    throw new EmptyStackException("Stack if empty.");
	}
	return this.head.getElement();
    }

    @Override
    public void push(T element) {
	Node<T> node = new Node<T>(element, this.head);
	this.head = node;
	size++;
    }

    @Override
    public T pop() throws EmptyStackException {
	if (isEmpty()) {
	    throw new EmptyStackException("Stack if empty.");
	}
	T element = head.getElement();
	Node<T> next = head.getNext();
	head = next;
	size--;
	return element;
    }

    public static class Node<T> {
	private T element;
	private Node<T> next;

	public Node() {
	    this(null, null);
	}

	public Node(T element, Node<T> next) {
	    this.element = element;
	    this.next = next;
	}

	public T getElement() {
	    return element;
	}

	public Node<T> getNext() {
	    return next;
	}

	public void setElement(T element) {
	    this.element = element;
	}

	public void setNext(Node<T> next) {
	    this.next = next;
	}
    }
}

package com.eftimoff.algorithms.queue;

public class NodeQueue<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public NodeQueue() {
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
    public T front() throws EmptyQueueException {
	return head.getElement();
    }

    @Override
    public void enqueue(T element) {
	Node<T> node = new Node<T>(element, null);
	if (size == 0) {
	    head = node;
	} else {
	    tail.setNext(node);
	}
	tail = node;
	size++;

    }

    @Override
    public T dequeue() throws EmptyQueueException {
	if (size == 0) {
	    throw new EmptyQueueException("Queue is empty.");
	}
	T element = this.head.getElement();
	head = head.getNext();
	size--;
	if (size == 0) {
	    tail = null;
	}
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

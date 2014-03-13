package com.eftimoff.algorithms.slinkedlist;

public class SLinkedList<T> {

    protected Node<T> head;
    protected Node<T> tail;
    protected long size;

    public SLinkedList() {
	this.tail = null;
	this.head = null;
	this.size = 0;
    }

    public void addFirst(final T element) {
	final Node<T> node = new Node<T>(element, this.head);
	node.setNext(head);
	this.head = node;
	size += 1;
	if (size == 1) {
	    this.tail = node;
	}
    }

    public void addLast(final T element) {
	final Node<T> node = new Node<T>(element, null);
	this.tail = node;
	this.tail.setNext(node);
	size += 1;
	if (size == 1) {
	    this.head = node;
	}
    }

    public void removeFirst() {
	if (this.head == null) {
	    throw new AssertionError("List is empty.");
	}
	this.head = this.head.next;
	size -= 1;
    }

    public static class Node<T> {
	private T element;
	private Node<T> next;

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

package com.eftimoff.algorithms.stack;

public class ArrayStack<T> implements Stack<T> {

    public static final int CAPACITY = 1000;
    protected int capacity;
    protected T array[];
    protected int top = -1;

    public ArrayStack() {
	this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int cap) {
	capacity = cap;
	array = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
	return (top + 1);
    }

    @Override
    public boolean isEmpty() {
	return top < 0;
    }

    @Override
    public T top() throws EmptyStackException {
	if (isEmpty()) {
	    throw new EmptyStackException("Stack if empty.");
	}
	return array[top];
    }

    @Override
    public void push(T element) {
	if (size() == capacity) {
	    throw new FullStackException("Stack is full.");
	}
	array[++top] = element;
    }

    @Override
    public T pop() throws EmptyStackException {
	if (isEmpty()) {
	    throw new EmptyStackException("Stack if empty.");
	}
	T element = array[top];
	array[top--] = null;
	return element;
    }

    @Override
    public String toString() {
	String s;
	s = "[";
	for (int i = 0; i < size(); i++) {
	    if (i == size() - 1) {
		s += array[i];
		break;
	    }
	    s += array[i] + ", ";
	}
	return s += "]";
    }

}

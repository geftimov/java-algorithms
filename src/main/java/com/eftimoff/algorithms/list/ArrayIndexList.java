package com.eftimoff.algorithms.list;

import java.util.Arrays;

public class ArrayIndexList<T> implements IndexList<T> {

    private T[] array;
    private int capacity = 16;
    private int size = 0;

    public ArrayIndexList() {
	array = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
	return this.size;
    }

    @Override
    public boolean isEmpty() {
	return this.size == 0;
    }

    private void checkIndex(int index, int capacity)
	    throws IndexOutOfBoundsException {
	if (index < 0 || index > capacity - 1) {
	    throw new IndexOutOfBoundsException("Index is out of range.");
	}
    }

    private void checkCapacity(int capacity) {
	if (this.capacity == capacity) {
	    array = Arrays.copyOf(array, capacity * 2);
	    this.capacity = capacity * 2;
	}
    }

    @Override
    public void add(int i, T element) throws IndexOutOfBoundsException {
	checkIndex(i, this.size() + 1);
	checkCapacity(this.size());
	// shift elements up
	for (int j = size - 1; j >= i; j--) {
	    array[j + 1] = array[j];
	}
	array[i] = element;
	size++;
    }

    @Override
    public T get(int i) throws IndexOutOfBoundsException {
	checkIndex(i, this.size() + 1);
	return array[i];
    }

    @Override
    public T remove(int i) throws IndexOutOfBoundsException {
	checkIndex(i, this.size() + 1);
	T t = array[i];
	for (int j = i; j < size - 1; j++) {
	    array[j] = array[j + 1];
	}
	size--;
	return t;
    }

    @Override
    public void set(int i, T element) throws IndexOutOfBoundsException {
	checkIndex(i, this.size() + 1);
	array[i] = element;
    }

}

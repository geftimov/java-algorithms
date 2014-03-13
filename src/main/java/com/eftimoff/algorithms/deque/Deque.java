package com.eftimoff.algorithms.deque;

public interface Deque<T> {

    int size();

    boolean isEmpty();

    T getFirst() throws EmptyDequeException;

    T getLast() throws EmptyDequeException;

    void addFirst(T element);

    void addLast(T element);

    T removeFirst() throws EmptyDequeException;

    T removeLast() throws EmptyDequeException;

}

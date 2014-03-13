package com.eftimoff.algorithms.queue;

public interface Queue<T> {
    int size();

    boolean isEmpty();

    T front() throws EmptyQueueException;

    void enqueue(T element);

    T dequeue() throws EmptyQueueException;
}

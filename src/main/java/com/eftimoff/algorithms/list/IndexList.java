package com.eftimoff.algorithms.list;

public interface IndexList<T> {

    int size();

    boolean isEmpty();

    void add(int i, T element) throws IndexOutOfBoundsException;

    T get(int i) throws IndexOutOfBoundsException;

    T remove(int i) throws IndexOutOfBoundsException;

    void set(int i, T element) throws IndexOutOfBoundsException;
}

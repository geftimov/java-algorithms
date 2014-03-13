package com.eftimoff.algorithms.deque;

public class EmptyDequeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmptyDequeException(String err) {
	super(err);
    }
}

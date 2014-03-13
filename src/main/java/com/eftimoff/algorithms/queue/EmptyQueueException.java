package com.eftimoff.algorithms.queue;

public class EmptyQueueException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmptyQueueException(String err) {
	super(err);
    }
}

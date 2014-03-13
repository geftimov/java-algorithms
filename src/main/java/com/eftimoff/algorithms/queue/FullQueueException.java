package com.eftimoff.algorithms.queue;

public class FullQueueException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FullQueueException(String err) {
	super(err);
    }
}

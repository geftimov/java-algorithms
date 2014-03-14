package com.eftimoff.algorithms.list;

public class EmptyListException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmptyListException(String err) {
	super(err);
    }
}

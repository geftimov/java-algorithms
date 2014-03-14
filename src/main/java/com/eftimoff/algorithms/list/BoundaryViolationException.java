package com.eftimoff.algorithms.list;

public class BoundaryViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BoundaryViolationException(String err) {
	super(err);
    }
}

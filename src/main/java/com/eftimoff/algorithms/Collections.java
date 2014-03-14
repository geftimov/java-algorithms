package com.eftimoff.algorithms;

import java.util.Iterator;

import com.eftimoff.algorithms.list.PositionList;
import com.eftimoff.algorithms.stack.ArrayStack;
import com.eftimoff.algorithms.stack.Stack;

public class Collections {
    public static <T> void reverse(T[] a) {
	Stack<T> stack = new ArrayStack<T>();
	for (int i = 0; i < a.length; i++) {
	    stack.push(a[i]);
	}
	for (int i = 0; i < a.length; i++) {
	    stack.pop();
	}
    }

    /** Returns a textual representation of a given node list */
    public static <E> String toString(PositionList<E> l) {
	Iterator<E> it = l.iterator();
	String s = "[";
	while (it.hasNext()) {
	    s += it.next(); // implicit cast of the next element to String
	    if (it.hasNext())
		s += ", ";
	}
	s += "]";
	return s;
    }
}

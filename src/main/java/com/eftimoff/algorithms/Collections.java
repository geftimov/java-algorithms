package com.eftimoff.algorithms;

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
}

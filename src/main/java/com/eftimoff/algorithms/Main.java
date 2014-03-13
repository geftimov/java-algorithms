package com.eftimoff.algorithms;

import com.eftimoff.algorithms.deque.Deque;
import com.eftimoff.algorithms.deque.NodeDeque;
import com.eftimoff.algorithms.queue.NodeQueue;
import com.eftimoff.algorithms.queue.Queue;

public class Main {
    public static void main(String[] args) {
	Deque<String> stack = new NodeDeque<String>();
	System.out.println(stack.size());
	stack.addFirst("edno");
	System.out.println(stack.size());
	stack.addFirst("dve");
	stack.addFirst("tri");
	stack.addFirst("chetiri");
	System.out.println(stack.size());
	System.out.println(stack.removeFirst());
	System.out.println(stack.removeFirst());
	System.out.println(stack.removeLast());
	System.out.println(stack.removeLast());
	System.out.println(stack.size());
    }

}

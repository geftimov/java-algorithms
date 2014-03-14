package com.eftimoff.algorithms;

import com.eftimoff.algorithms.list.NodePositionList;
import com.eftimoff.algorithms.list.PositionList;

public class Main {
    public static void main(String[] args) {
	PositionList<String> nodePositionList = new NodePositionList<String>();
	nodePositionList.addFirst("one");
	System.out.println(nodePositionList.size());
	nodePositionList.addFirst("one");
	System.out.println(nodePositionList.size());
	nodePositionList.addFirst("one");
	System.out.println(nodePositionList.size());
	System.out.println(9 >> 1);
    }

}

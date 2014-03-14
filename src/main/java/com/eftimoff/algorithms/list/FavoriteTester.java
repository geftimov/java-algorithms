package com.eftimoff.algorithms.list;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.util.Random;

/** Example program for the FavoriteList and FavoriteListMTF classes */
public class FavoriteTester {
    public static void main(String[] args) {
	String[] urlArray = { "http://wiley.com", "http://datastructures.net",
		"http://algorithmdesign.net", "http://www.brown.edu",
		"http://uci.edu" };
	FavoriteList<String> L1 = new FavoriteList<String>();
	FavoriteListMTF<String> L2 = new FavoriteListMTF<String>();
	int n = 20; // number of access operations
	// Simulation scenario: access n times a random URL
	Random rand = new Random();
	for (int k = 0; k < n; k++) {
	    System.out.println("-------------------------------------------");
	    int i = rand.nextInt(urlArray.length); // random index
	    String url = urlArray[i]; // random URL
	    System.out.println("Accessing: " + url);
	    L1.access(url);
	    System.out.println("L1 = " + L1);
	    L2.access(url);
	    System.out.println("L2 = " + L2);
	}
	int t = L1.size() / 2;
	System.out.println("-------------------------------------------");
	System.out.println("Top " + t + " in L1 = " + L1.top(t));
	System.out.println("Top " + t + " in L2 = " + L2.top(t));
	// Pop up a browser window displaying the most popular URL in L1
	try {
	    String popular = L1.top(1).iterator().next(); // most popular URL in
							  // L1
	    JEditorPane jep = new JEditorPane(popular);
	    jep.setEditable(false);
	    JFrame frame = new JFrame(popular);
	    frame.getContentPane().add(new JScrollPane(jep),
		    BorderLayout.CENTER);
	    frame.setSize(640, 480);
	    frame.setVisible(true);
	} catch (IOException e) { // ignore I/O exceptions
	}
    }
}
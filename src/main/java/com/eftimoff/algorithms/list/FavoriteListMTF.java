package com.eftimoff.algorithms.list;

public class FavoriteListMTF<E> extends FavoriteList<E> {
    /** Default constructor */
    public FavoriteListMTF() {
    }

    /** Moves up an entry to the first position; O(1) time */
    protected void moveUp(Position<Entry<E>> pos) {
	fList.addFirst(fList.remove(pos));
    }

    /** Returns the k most accessed elements, for a given k; O(kn) time */
    public Iterable<E> top(int k) {
	if (k < 0 || k > size())
	    throw new IllegalArgumentException("Invalid argument");
	PositionList<E> T = new NodePositionList<E>(); // top-k list
	if (!isEmpty()) {
	    // copy entries into temporary list C
	    PositionList<Entry<E>> C = new NodePositionList<Entry<E>>();
	    for (Entry<E> e : fList)
		C.addLast(e);
	    // find the top k elements, one at a time
	    for (int i = 0; i < k; i++) {
		Position<Entry<E>> maxPos = null; // position of top entry
		int maxCount = -1; // access count of top entry
		for (Position<Entry<E>> p : C.positions()) {
		    // examine all entries of C
		    int c = count(p);
		    if (c > maxCount) { // found an entry with higher access
					// count
			maxCount = c;
			maxPos = p;
		    }
		}
		T.addLast(value(maxPos)); // add top entry to list T
		C.remove(maxPos); // remove top entry from list C
	    }
	}
	return T;
    }
}

package com.eftimoff.algorithms.dlinkedlist;


public class DLinkedList<T> {
    private DNode<T> header;
    private DNode<T> trailer;
    private long size;

    public DLinkedList() {
	this.header = new DNode<T>();
	this.trailer = new DNode<T>();
	this.header.setNext(this.trailer);
	this.trailer.setPrev(this.header);
	this.size = 0;
    }

    public void addFirst(final T element) {
	final DNode<T> node = new DNode<T>(element);
	DNode<T> next = this.header.getNext();
	node.setNext(next);
	this.header = new DNode<T>();
	this.header.setNext(node);
	node.setPrev(this.header);
	next.setPrev(node);
	size += 1;
    }

    public void addAfter(final T destination, final T node) {
	final DNode<T> desireNode = new DNode<T>(node);
	DNode<T> loopNode = this.header;
	while (loopNode.hasNext()) {
	    DNode<T> next = loopNode.getNext();
	    if (next.getElement().equals(destination)) {
		DNode<T> next2 = next.getNext();
		next2.setPrev(desireNode);
		next.setNext(desireNode);
		desireNode.setNext(next2);
		desireNode.setPrev(next);
		size += 1;
		return;
	    } else {
		loopNode = loopNode.getNext();
	    }
	}
    }

    public void remove(final T node) {
	DNode<T> loopNode = this.header;
	while (loopNode.hasNext()) {
	    DNode<T> next = loopNode.getNext();
	    if (next.getElement().equals(node)) {
		DNode<T> prev = next.getPrev();
		DNode<T> next2 = next.getNext();
		prev.setNext(next2);
		next2.setPrev(prev);
		size -= 1;
		return;
	    } else {
		loopNode = loopNode.getNext();
	    }
	}
    }

    public void addLast(final T element) {
	final DNode<T> node = new DNode<T>(element);
	DNode<T> prev = this.trailer.getPrev();
	node.setNext(this.trailer);
	node.setPrev(prev);
	this.trailer = new DNode<T>();
	this.trailer.setPrev(node);
	prev.setNext(node);
	size += 1;
    }

    public void removeFirst() {
	if (size == 0) {
	    throw new AssertionError("List is empty.");
	}
	final DNode<T> preNext = this.header.getNext().getNext();
	this.header.setNext(preNext);
	preNext.setPrev(this.header);
	size -= 1;
    }

    public void removeLast() {
	if (size == 0) {
	    throw new AssertionError("List is empty.");
	}
	final DNode<T> prePrev = this.trailer.getPrev().getPrev();
	this.trailer.setPrev(prePrev);
	prePrev.setNext(this.trailer);
	size -= 1;
    }

    public static class DNode<T> {
	private T element;
	private DNode<T> next;
	private DNode<T> prev;

	public DNode() {
	}

	public DNode(T element) {
	    this.element = element;
	}

	public T getElement() {
	    return element;
	}

	public DNode<T> getNext() {
	    return next;
	}

	public DNode<T> getPrev() {
	    return prev;
	}

	public void setElement(T element) {
	    this.element = element;
	}

	public void setNext(DNode<T> next) {
	    this.next = next;
	}

	public void setPrev(DNode<T> prev) {
	    this.prev = prev;
	}

	public boolean hasNext() {
	    boolean result = false;
	    if (getNext() != null) {
		result = true;
	    }
	    return result;
	}

	public boolean hasPrev() {
	    boolean result = false;
	    if (getPrev() != null) {
		result = true;
	    }
	    return result;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result
		    + ((element == null) ? 0 : element.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    @SuppressWarnings("unchecked")
	    DNode<T> other = (DNode<T>) obj;
	    if (element == null) {
		if (other.element != null)
		    return false;
	    } else if (!element.equals(other.element))
		return false;
	    return true;
	}
    }

    public long getSize() {
	return this.size;
    }

    @Override
    public String toString() {
	return "DLinkedList [header=" + header.getNext().getElement()
		+ ", trailer=" + trailer.getPrev().getElement() + ", size="
		+ size + "]";
    }
}

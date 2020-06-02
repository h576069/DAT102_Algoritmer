package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class TabellIterator<T> implements Iterator<T> {
	private int antall;
	private int pos;
	private T[] element;
	
	public TabellIterator(T[] tab) {
		this.element = tab;
	}
	
	@Override
	public boolean hasNext() {
		// Om vi har flere elementer igjen
		return (pos < antall);
	}
	
	@Override
	public T next() {
		if (hasNext()) {
			pos++;
			return element[pos-1];
		} else {
			return null;
		}
	}
	
	@Override
	public void remove() {
		// Fjerner elementet vi står på.
	}
}

package no.hvl.dat102;

import java.util.Iterator;

public class KjedetIterator<T> implements Iterator<T> {
	private LinearNode<T> aktuell;
	
	public KjedetIterator(LinearNode<T> samling) {
		this.aktuell = samling;
	}
	
	@Override
	public boolean hasNext() {
		return (this.aktuell != null);
	}
	
	@Override
	public T next() {
		T resultat = null;
		if (hasNext()) {
			resultat = this.aktuell.getElement();
			this.aktuell = this.aktuell.getNeste();
		}
		return resultat;
	}
	
}

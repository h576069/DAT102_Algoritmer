package no.hvl.dat102.kjedet;

import java.util.Iterator;
import java.util.NoSuchElementException;

import no.hvl.dat102.noder.LinearNode;

public class KjedetIterator<T> implements Iterator<T> {
	private LinearNode<T> aktuell; // den aktuelle posisjonen.

	/**
	 * @param samling
	 */
	public KjedetIterator(LinearNode<T> samling) {
		aktuell = samling;
	}

	@Override
	public boolean hasNext() {
		return (aktuell != null);
	}

	@Override
	public T next() {
		T resultat = null;
		if (!hasNext())
			throw new NoSuchElementException();
		resultat = aktuell.getElement();
		aktuell = aktuell.getNeste();
		return resultat;
	}

	@Override
	public void remove() {
		System.out.println("Denne er ikke implementert.");
	}
}

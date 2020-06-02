package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.PriKoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class PriKoe<T extends Comparable<T>> implements PriKoeADT<T> {
	private TabellHaug<T> koe;

	public PriKoe() {
		koe = new TabellHaug<T>();
	}

	public PriKoe(int startKapasitet) {
		koe = new TabellHaug<T>(startKapasitet);
	}

	public void settInn(T el) {
		koe.leggTilElement(el);
	}

	public T neste() throws EmptyCollectionException {
		return koe.finnMinste();
	}

	public T fjern() throws EmptyCollectionException {
		return koe.fjernMinste();
	}

	public int antall() {
		return koe.antall();
	}

	public boolean erTom() {
		return koe.erTom();
	}
}

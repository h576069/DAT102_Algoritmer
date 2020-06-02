package no.hvl.dat102;

import no.hvl.dat102.adt.*;

//********************************************************************
//
//  Representerer en samling kø, implementert vha en tabell.
// foran er i posisjon 0.
//********************************************************************

public class TabellKoe<T> implements KoeADT<T> {
	private final static int STDK = 100;
	private int bak;
	private T[] koe;

	// Oppretter en tom kø med standard størrelse.
	public TabellKoe() {
		this(STDK);
	}

	// Oppretter en tom kø med kapasitet gitt ved parameter
	public TabellKoe(int startKapasitet) {
		bak = 0;
		koe = (T[]) (new Object[startKapasitet]);
	}

	@Override
	public int antall() {
		return this.bak;
	}
	
	@Override
	public boolean erTom() {
		return (bak == 0);
	}
	
	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("Koe");
		
		return this.koe[0];
	}
	
	private void utvid() {
		int new_length = (int) (this.koe.length * 1.1);
		T[] new_koe    = (T[]) (new Object[new_length]);
		for (int i = 0; i < this.bak; i++) {
			new_koe[i] = this.koe[i];
		}
		this.koe = new_koe;
		
	}
	// void innKoe(T)
	@Override
	public void innKoe(T element) {
		if (this.bak == this.koe.length) {
			utvid();
		}
		this.koe[this.bak] = element;
		this.bak++;
		
	}
	// T utKoe()
	@Override
	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("Koe");
		
		T resultat = this.koe[0];
		this.bak--;
		for (int i = 0; i < bak; i++) {
			this.koe[i] = this.koe[i+1];
		}
		this.koe[bak] = null;
		return resultat;
	}

}// class

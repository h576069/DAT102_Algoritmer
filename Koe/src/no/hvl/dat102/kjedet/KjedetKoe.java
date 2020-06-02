package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.exception.*;

public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> front, bak;

	// Konstruktør:
	public KjedetKoe() {
		this.antall = 0;
		this.front = this.bak = null;
	}

	@Override
	public void innKoe(T element) {
		// Oppretter ny node:
		LinearNode<T> nyNode = new LinearNode<T>(element);
		if (this.antall == 0) {
			this.front = nyNode;
			this.bak = nyNode;
		} else {
			// Setter inn den bakerste etter denne nye noden
			nyNode.setNeste(this.bak);
			// Oppdaterer bakerste
			this.bak = nyNode;
		}
		// Øker antallet med 1
		this.antall++;
	}

	@Override
	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");

		// Oppretter en dummy variabel
		LinearNode<T> forrige = this.bak;
		// Oppretter variabel for resultatet:
		T resultat = null;
		
		// Hvis vi kun har et element:
		if (this.antall==1) {
			resultat = this.bak.getElement();
			this.bak = null;
			this.front = null;
		} else {
			for (int i = 0; i < this.antall-2; i++) {
				forrige = forrige.getNeste();
			}
			resultat = forrige.getNeste().getElement();
			forrige.setNeste(null);
			this.front = forrige;
		}
		this.antall--;

		return resultat;

	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("koe");

		return this.front.getElement();
	}

	@Override
	public int antall() {
		return this.antall;
	}

	@Override
	public boolean erTom() {
		return (this.antall == 0);
	}

}

package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.exception.*;

public class TabellKoe<T> implements KoeADT<T> {
	private final static int STDK = 100;
	private int bak;
	private T[] koe;

	public TabellKoe() {
		this(STDK);
	}

	public TabellKoe(int startKapasitet) {
		bak = 0;
		koe = (T[]) (new Object[startKapasitet]);
	}

	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[2 * this.koe.length]);
		for (int i = 0; i <= this.bak; i++) {
			hjelpetabell[i] = this.koe[i];
		}
		this.koe = hjelpetabell;
	}

	@Override
	public void innKoe(T element) {
		// Hvis tabellen er full:
		if (this.bak == this.koe.length - 1) {
			utvid();
		}

		// øker bak med 1:
		
		this.koe[this.bak] = element;
		this.bak++;

	}

	@Override
	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");

		// Henter ut det fremste elementet så vi kan returnere det
		T resultat = this.koe[0];
		
		this.bak--;
		
		// Fjerner det fremste elementet:
		for (int i = 0; i < this.bak; i++) {
			this.koe[i] = this.koe[i + 1];
		}
		// Setter det siste elementet til null for å unngå duplikat
		this.koe[this.bak] = null;

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("koe");

		return this.koe[0];
	}

	@Override
	public boolean erTom() {
		return (this.bak == 0);
	}

	@Override
	public int antall() {
		return this.bak;
	}

}

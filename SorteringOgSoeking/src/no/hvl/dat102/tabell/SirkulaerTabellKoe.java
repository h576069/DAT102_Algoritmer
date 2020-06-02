package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.exception.*;

public class SirkulaerTabellKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int foran, bak, antall;
	private T[] koe;

	public SirkulaerTabellKoe() {
		this(STDK);
	}

	public SirkulaerTabellKoe(int startKapasitet) {
		foran = bak = antall = 0;
		koe = ((T[]) (new Object[startKapasitet]));
	}

	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);
		for (int soek = 0; soek < this.antall; soek++) {
			hjelpetabell[soek] = this.koe[this.foran];
			this.foran = (this.foran + 1) % this.koe.length;
		}
		this.foran = 0;
		this.bak = this.antall;
		this.koe = hjelpetabell;
	}

	@Override
	public void innKoe(T element) {
		if (this.antall == this.koe.length) {
			utvid();
		}
		this.koe[this.bak] = element;
		this.bak = (this.bak + 1) % this.koe.length;
		this.antall++;
	}

	@Override
	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		
		T resultat = this.koe[this.foran];
		this.koe[this.foran] = null;
		this.foran = (this.foran + 1) % this.koe.length;
		this.antall--;
		return resultat;
	}
	
	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		
		return this.koe[this.foran];
	}
	
	@Override
	public boolean erTom() {
		return (this.antall == 0);
	}
	
	@Override
	public int antall() {
		return this.antall;
	}
}

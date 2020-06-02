package no.hvl.dat102;
import no.hvl.dat102.adt.*;

public class SirkulaerKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int foran, bak, antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STDK);
	}

	public SirkulaerKoe(int startKapasitet) {
		this.foran = this.bak = this.antall = 0;
		this.koe = ((T[]) (new Object[startKapasitet]));
	}
     //...
	// int antall()
	public int antall() {
		return this.antall;
	}
	// boolean erTom
	@Override
	public boolean erTom() {
		return (this.foran==this.bak);
	}
	// T foerste()
	public T foerste() {
		return this.koe[this.foran];
	}
	
	private void utvid() {
		T[] hjelpetabell = (T[])(new Object[this.koe.length*2]);
		for (int soek = 0; soek < this.antall; soek++) {
			hjelpetabell[soek] = this.koe[this.foran];
			this.foran = (this.foran + 1) % this.koe.length;
		}
		this.foran = 0;
		this.bak = antall;
		this.koe = hjelpetabell;
	}
	
	// LEGGER TIL ET ELEMENT I KØEN, UTVIDER HVIS NØDVENDIG:
	@Override
	public void innKoe(T element) {
		if (antall() == this.koe.length) {
			utvid();
		}
		this.koe[this.bak] = element;
		this.bak = (this.bak + 1) % this.koe.length;
		this.antall++;
	}
	
	// FJERNER OG RETURNERER ELEMENTET FORAN I KØEN
	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		
		T resultat = this.koe[this.foran];
		this.koe[this.foran] = null;
		this.foran = (this.foran + 1) % this.koe.length;
		this.antall--;
		return resultat;
	}
	
}// class


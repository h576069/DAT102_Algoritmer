package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	private static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;
	
	
	public TabellMengde() {
		this(STDK);
	}
	
	public TabellMengde(int startkapasitet) {
		this.antall = 0;
		this.tab = (T[]) (new Object[startkapasitet]);
	}
	
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == this.tab.length) {
				utvidKapasitet();
			}
			this.tab[this.antall] = element;
			this.antall++;
		}
	}
	
	private void utvidKapasitet() {
		T[] hjelpetabell = (T[])(new Object[2*this.tab.length]);
		for (int i = 0; i < this.antall; i++) {
			hjelpetabell[i] = this.tab[i];
		}
		this.tab = hjelpetabell;
	}
	
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < this.antall)&& (!funnet); i++ ) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return funnet;
	}

	public boolean erLik(MengdeADT<T> m2) {
		// gjør selv
		return false;
	}
	
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			//
		}
	}
	
	public T fjernTilfeldig() {
		if (erTom()) 
			throw new EmptyCollectionException("mengde");
		
		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = this.tab[indeks];
		this.tab[indeks] = this.tab[this.antall-1];
		tab[this.antall-1] = null;
		this.antall--;
		return svar;
	}
	
	public T fjern(T element) {
		if (erTom())
			throw new EmptyCollectionException("mengde");
		
		boolean funnet = false;
		T svar = null;
		int i = 0;
		
		while (oppramser().hasNext() && !funnet) {
			if (this.tab[i].equals(element)) {
				svar = this.tab[i];
				// mer
				
			}
			i++;
		}
		return svar;
	}
	
//	public MengdeADT<T> union(MengdeADT<T> m2) {
//		// Bruk den effektive versjonen
//	}
	
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(this.tab);
	}
	
	public boolean erTom() {
		return (this.antall == 0);
	}
	
	public int antall() {
		return this.antall;
	}
}

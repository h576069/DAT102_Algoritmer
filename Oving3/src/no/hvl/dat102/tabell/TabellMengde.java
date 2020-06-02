package no.hvl.dat102.tabell;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.adt.*;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {
		// Søker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		int i = 0;
		while (!funnet && i < this.antall) {
			if (this.tab[i].equals(element)) {
				svar = this.tab[i];
				funnet = true;
				this.tab[i] = this.tab[this.antall - 1];
				this.tab[this.antall - 1] = null;
				this.antall--;
			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(Object m2) {
		boolean likeMengder = true;
		T element; // Kan vi slette denne?

		// Gjør m2 om til den typen vi vil ha:
		MengdeADT<T> m = (MengdeADT<T>) m2; // Er det sånn vi må gjøre det?

		// Sjekker om vi har likt antall elementer:
		if (this.antall == m.antall()) {
			// Likt antall, fortsetter sammenligning
			// Lager opprams av parameter mengder:
			Iterator<T> it = m.oppramser();
			// Sjekker at vi har flere elementer i parameter mengden m2 og at likeMengder
			// enda er sann:
			while (it.hasNext() && likeMengder) {
				if (!this.inneholder(it.next())) {
					likeMengder = false;
				}
			}
		} else {
			// Ulikt antall elementer:
			likeMengder = false;
		}
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	/*
	 * Denne versjonen av unionen er lite effekktiv
	 * 
	 * @Override public MengdeADT<T> union(MengdeADT<T> m2) { TabellMengde<T> begge
	 * = new TabellMengde<T>(); for (int i = 0; i < antall; i++) {
	 * begge.leggTil(tab[i]); } Iterator<T> teller = m2.oppramser();
	 * 
	 * while (teller.hasNext()) { begge.leggTil(teller.next()); } return
	 * (MengdeADT<T>)begge; }
	 */
	@Override

	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();
		T element = null;

		// Legger til elementene i begge:
		for (int i = 0; i < this.antall; i++) {
			((TabellMengde<T>) begge).settInn(this.tab[i]);
		}

		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			element = teller.next();
			if (!begge.inneholder(element)) {
				((TabellMengde<T>) begge).settInn(element);
			}
		}
		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element = null;

		// Løkke over elementene i m2:
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			element = teller.next();
			if (this.inneholder(element)) {
				((TabellMengde<T>) snittM).settInn(element);
			}
		}

		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element;

		Iterator<T> teller = this.oppramser();
		while (teller.hasNext()) {
			element = teller.next();
			if (!m2.inneholder(element)) {
				((TabellMengde<T>) differensM).settInn(element);
			}
		}

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;

		Iterator<T> teller = m2.oppramser();
		T element = null;
		while (teller.hasNext() && erUnderMengde) {
			element = teller.next();
			if (!this.inneholder(element)) {
				erUnderMengde = false;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	// TOSTRING METODEN:
	public String toString() {
		String resultat = "<"+this.tab[0];
		for (int i = 1; i < this.antall; i++) {
			resultat += ", " + this.tab[i];
		}
		resultat += ">";
		return resultat;
		
		
	}

}// class

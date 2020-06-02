package no.hvl.dat102;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.adt.MengdeADT;

public class KjedetMengde<T> implements MengdeADT<T> {
	private LinearNode<T> start;
	private int antall;
	private Random rand = new Random();

	public KjedetMengde() {
		this.start = null;
		this.antall = 0;
	}
	
	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			LinearNode<T> nyNode = new LinearNode<T>(element);
			nyNode.setNeste(this.start);
			this.start = nyNode;
			this.antall++;
		}

	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = this.start;
		for (int soek = 0; soek < this.antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}
	
	@Override
	public boolean equals(MengdeADT<T> m) {
		// Returnerer sann hvis de to mengdene (this og m) er like, ellers usann
		// Parameter mengde m
		boolean likeMengder = true;
		Iterator<T> nye = m.oppramser();
		if (this.antall == m.antall()) {
			while (nye.hasNext() && likeMengder) {
				// Hvis neste element i m ikke er med i denne mengden --> likeMengder = false
				if (!inneholder(nye.next())) {
					likeMengder = false;
				}
			}
		} else {
			likeMengder = false;
		}
		
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}
	
	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");
		
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		int valg = rand.nextInt(this.antall) + 1;
		
		if (valg == 1) {
			resultat = start.getElement();
			this.start = this.start.getNeste();
		} else {
			forgjenger = this.start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		this.antall--;
		return resultat;
	}
	
	@Override
	public T fjern(T element) {
		T resultat = null;
		boolean funnet = false;
		LinearNode<T> denne = this.start;
		
		if (erTom())
			throw new EmptyCollectionException("mengde");

		if (element.equals(this.start)) {
			resultat = this.start.getElement();
			this.start = this.start.getNeste();
			funnet = true;
		} else {
			while (denne.getNeste() != null && !funnet) {
				if (denne.getNeste().getElement() == element) {
					funnet = true;
				} else {
					denne = denne.getNeste();
				}
			}

		}
		
		if (funnet) {
			resultat = denne.getNeste().getElement();
			denne.setNeste(denne.getNeste().getNeste());
			this.antall--;
		}
		
		return resultat;
	}
	
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = this.start;
		T element;

		// Del 1:
		while (aktuell != null) {
			begge.leggTil(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}

		// Del 2:
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			element = teller.next();

		}
		return begge;
	}
	
	@Override
	public boolean erTom() {
		return (this.antall == 0);
	}
	
	@Override
	public int antall() {
		return this.antall;
	}
	
	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(this.start);
	}
	
}

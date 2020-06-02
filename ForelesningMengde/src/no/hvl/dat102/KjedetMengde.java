package no.hvl.dat102;

import java.util.Iterator;
import java.util.Random;
import no.hvl.dat102.adt.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall;
	private LinearNode<T> start;
	
	public KjedetMengde() {
		this.antall = 0;
		this.start = null;
	}
	
	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(node);
			this.start = node;
			this.antall++;
		}
	}
	
	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
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
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		LinearNode<T> denne = this.start;
		
		if (m2.antall() == this.antall) {
			while (denne.getNeste() != null && likeMengder) {
				if (!m2.inneholder(denne.getNeste().getElement())) {
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
			resultat = this.start.getElement();
			this.start = start.getNeste();
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
	public T fjern (T element) {
		if (erTom())
			throw new EmptyCollectionException("mengde");
		
		LinearNode<T> forgjenger, aktuell;
		boolean funnet = false;
		T resultat = null;
		forgjenger = this.start;
		
		if (element.equals(this.start.getElement())) {
			this.start = this.start.getNeste();
		} else {
			while (forgjenger.getNeste() != null && !funnet) {
				if (forgjenger.getNeste().getElement().equals(element)) {
					funnet = true;
				} else {
					aktuell = forgjenger.getNeste();
				}
			}
		}
		aktuell = forgjenger.getNeste();
		if (funnet) {
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
			this.antall--;
			
		}
		return resultat;
	}
	
	@Override
	public boolean erTom() {
		return (this.antall == 0);
	}
	
	@Override
	public int antall() {
		return this.antall;
	}
	//@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = this.start;
		
		// Del 1:
		while (aktuell != null) {
			begge.leggTil(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}
//		begge.start = this.start; // Må da lage en setAntall metode for å kunne bruke det på begge
//		Lekse å få den over til å virke
		
		// Del 2:
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return begge;
		
	}
	
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}
}

package no.hvl.dat102;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.*;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetListe<T extends Comparable<T>> implements ListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("kjedet liste");

		T resultat = this.foerste.getElement();
		this.foerste = this.foerste.getNeste();
		this.antall--;

		if (erTom()) {
			this.siste = null;
		}

		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();
		this.antall--;
		if (this.antall == 0) {
			this.foerste = null;
			this.siste = null;
		} else {
			this.siste = this.foerste;
			for (int i = 1; i < this.antall; i++) {
				this.siste = this.siste.getNeste();
			}
			this.siste.setNeste(null);
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("kjedet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (this.antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	public void leggTil(T element) {
		// Ikke ordnet liste, bare setter inn bak:
		LinearNode<T> nyNode = new LinearNode<T>(element);
		if (this.antall == 0) {
			this.siste = nyNode;
			this.foerste = nyNode;
			this.antall++;
		} else {
			this.siste.setNeste(nyNode);
			this.siste = nyNode;
			this.antall++;
		}
	}

	@Override
	public T fjern(T element) {
		if (erTom())
			throw new EmptyCollectionException("kjedet liste");

		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		boolean funnet = false;
		while (denne != null && !funnet) {
			if (denne.getNeste().getElement().equals(element)) {
				funnet = true;
			}
			denne = denne.getNeste();
		}
		svar = denne.getNeste().getElement();
		denne.setNeste(denne.getNeste().getNeste());
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		// UORDNET
		while (denne != null && !element.equals(denne.getElement())) {
			denne = denne.getNeste();
		}
		return (denne != null);
	}

	/*
	 * 4a) Lag en metode public int lengde() som ved hjelp av en rekursiv
	 * hjelpemetode finner antall noder i listen. (Egentlig unødvendig siden vi har
	 * antall som egenskap).
	 */

	public int lengde(LinearNode<T> denne) {
		return lengdeRek(this.foerste);
	}
	public int lengdeRek(LinearNode<T> aktuell) {
		int lengde;
		if (aktuell == null) { // Basistilfellet
			lengde = 0;
		} else {
			lengde = 1 + lengdeRek(aktuell.getNeste());
		}
		return lengde;
	}

	/*
	 * 4b) Lag en metode public void skrivBaklengs() som ved hjelp av en rekursiv
	 * hjelpemetode skriver ut elementene baklengs.
	 */
	public void skrivBaklengs() {
		skrivBaklengsRek(this.foerste);
	}
	public void skrivBaklengsRek(LinearNode<T> aktuell) {
		if (aktuell != null) {
			skrivBaklengsRek(aktuell.getNeste());
			System.out.print(aktuell.getElement());;
		}
	}
	
	/*
	 * 4c)
	 */
	private String toStringRek2(LinearNode<T> aktuell){
		/*
		 * Skriver den ut baklengs
		 */
		if (aktuell == null) {  // Vil ikke skrive ut hvis det ikke er noe der
			return "";
		}else {
			return toStringRek2(aktuell.getNeste()) + " " + aktuell.getElement();
		}
	}
	public String toString2(){
		return toStringRek2(this.foerste);
		 }

	public LinearNode<T> getFoerste() {
		return foerste;
	}

	public void setFoerste(LinearNode<T> foerste) {
		this.foerste = foerste;
	}

	public LinearNode<T> getSiste() {
		return siste;
	}

	public void setSiste(LinearNode<T> siste) {
		this.siste = siste;
	}

}// class

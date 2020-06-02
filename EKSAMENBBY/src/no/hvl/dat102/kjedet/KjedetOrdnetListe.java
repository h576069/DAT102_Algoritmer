package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.noder.LinearNode;

public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> første;

	// Konstruktør
	public KjedetOrdnetListe() {
		antall = 0;
		første = null;
	}

	// … get- og set-metoder som kan du anta hvis nødvendig
	
	// Andre metoder
	public boolean inneholder(T element) {
		// … Fyll ut
		return false;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	public LinearNode<T> getFørste() {
		return første;
	}

	public void setFørste(LinearNode<T> første) {
		this.første = første;
	}

	public void settInn(T element) {
		// … Fyll ut
	}

	public void flette(OrdnetListeADT<T> L2) {
		// … Fyll ut
	}

	@Override
	public T fjern(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fjernFoerste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fjernSiste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T foerste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T siste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean erTom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void leggTil(T element) {
		// TODO Auto-generated method stub
		
	}

}

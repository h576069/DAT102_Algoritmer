package no.hvl.dat102;
import no.hvl.dat102.adt.*;
//********************************************************************
// 
//  Representer en samling koe, implementert vha kjedet struktur
//********************************************************************

public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> front, bak;
    
	public KjedetKoe() {
		this.antall = 0;
		this.front = this.bak = null;
	}
	
	// int antall()
	@Override
	public int antall() {
		return this.antall;
	}
	// boolean erTom()
	@Override
	public boolean erTom() {
		return (this.antall == 0);
	}
	// T foerste()
	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		return this.front.getElement();
	}
	// void innKoe(T)
	@Override
	public void innKoe(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		if (erTom()) {
			this.front = nyNode;
		} else {
			this.bak.setNeste(nyNode);
		}
		this.bak = nyNode; // oppdaterer bakerste
		this.antall++;
	}
	// T utKoe()
	@Override
	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		// Setter resultatet til den fremste
		T res = front.getElement();
		// Fjerner det fremste elementet
		this.front = this.front.getNeste();
		// Minker antallet
		this.antall--;
		
		// Ekstra test i tilfelle den nå er blitt tom:
		if (erTom()) {
			this.bak = null;
		}
		
		
		return res;
		
	}
	
}// class

package no.hvl.dat102;

import java.util.*;

/**
 * Klasse som implementerer en InordenIterator
 * 
 *
 */

public class InordenIterator<T> implements Iterator<T> {
	private Stack<BinaerTreNode<T>> s = null;
	private BinaerTreNode<T> aktuell = null;
	
	/**
	 * Metode som går til venstre og stabler venstrebarn på en stack
	 * 
	 * @param p, noden vi går til venstre fra
	 * @return den noden helt til venstre for parameter noden, parameter noden hvis den ikke har
	 */
	private BinaerTreNode<T> gaaTilVenstre(BinaerTreNode<T> p) {
		if (p == null)
			return null;
		
		while (p.getVenstre() != null) {
			this.s.push(p);
			p = p.getVenstre();
		}
		return p;
	}
	
	/**
	 * Oppretter en InordenIterator<T>, går helt til venstre i bs-treet
	 * 
	 * @param rot, rot noden til bs-treet
	 */
	public InordenIterator(BinaerTreNode<T> rot) {
		this.s = new Stack<BinaerTreNode<T>>();
		this.aktuell = gaaTilVenstre(rot);
	}
	
	/**
	 * Metode som sjekker om iterasjonen har flere elementer
	 * 
	 * @return sann hvis flere, usann ellers.
	 */
	public boolean hasNext() {
		return (this.aktuell != null);
	}
	
	/**
	 * Returnerer det neste elementet i iterasjon hvis det fins
	 * 
	 * @return det neste elementet, null ellers.
	 */
	public T next() {
		T resultat = null;
		
		if (hasNext())
			resultat = this.aktuell.getElement();
		
		if (this.aktuell.getHoyre() != null) { // har et høyre undertre
			// stable på node for venstre undertre
			this.aktuell = gaaTilVenstre(this.aktuell.getHoyre());
		} else if (!this.s.isEmpty()) {
			// ingen høyre undertre
			this.aktuell = (BinaerTreNode<T>) this.s.pop();
		} else {
			this.aktuell = null; // slutt på treet
		}
		return resultat;
	}
	
	public void remove() {
		// ikke implementert
	}
}

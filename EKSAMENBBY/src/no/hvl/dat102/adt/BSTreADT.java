package no.hvl.dat102.adt;

import java.util.*;

public interface BSTreADT<T extends Comparable<T>> {
	// Burde hatt javadoc her
	// anbefaler at du fyller ut med javadoc her

	/**
	 * Returnerer antallet noder i det binære treet
	 * @return antallet noder i det binære treet
	 */
	public int antall();

	/**
	 * Returnerer sann hvis det binære treet er tomt, usann ellers.
	 * @return sann hvis treet er tomt
	 */
	public boolean erTom();

	/**
	 * Legger til et element på passende plass i BS treet, like elementer legges til høyre
	 * @param element elementet som skal legges til
	 */
	public void leggTil(T element);

	/**
	 * Returnerer referanse til elementet hvis det fins, null ellers
	 * @param element, elementet vi skal finne
	 * @return elementet eller null.
	 */
	public T finn(T element);
	
	/**
	 * Finner det minste elementet
	 * @return det minste elementet, null hvis tomt
	 */
	public T finnMin();
	
	/**
	 * Finner største elementet
	 * @return største elementet, null hvis tomt
	 */
	public T finnMaks();

	/**
	 * Fjerner minste elementet
	 * @return returnerer minste elementet, eller null
	 */
	public T fjernMin();
	
	/**
	 * Fjerner største elementet
	 * @return største elementet, eller null
	 */
	public T fjernMaks();
}

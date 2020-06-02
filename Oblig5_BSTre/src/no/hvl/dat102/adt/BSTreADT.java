package no.hvl.dat102.adt;

public interface BSTreADT<T extends Comparable<T>> {
	/**
	 * Metode for å finne antallet noder i treet
	 * 
	 * @return antallet noder
	 */
	public int antall();

	/**
	 * Metode for å sjekke om det binære treet er tomt
	 * 
	 * @return sant hvis tomt, usann eller
	 */
	public boolean erTom();

	/**
	 * Legger til det spesifiserte elementet på passende plass i det søkende treet.
	 * Like elementer blir lagt til høyre.
	 * 
	 * @param element, elementet du vil legge til i treet
	 */
	public void leggTil(T element);
	
	/**
	 * Sjekker om et element finnes i treet eller ikke.
	 * 
	 * @param element, elementet du vil se om finnes
	 * @return elementet hvis det finnes, null ellers
	 */
	public T finn(T element);
	
	/**
	 * Finner det minste elementet i treet
	 * 
	 * @return referanse til det minste elementet, null hvis treet er tomt
	 */
	public T finnMin();
	
	/**
	 * Finner det største elementet i treet
	 * 
	 * @return referanse til det største elementet, null hvis treet er tomt
	 */
	public T finnMaks();
	
	/**
	 * Fjerner det minste elementet fra treet
	 * 
	 * @return det elementet som ble fjernet, hvis det finnes, null ellers
	 */
	public T fjernMin();
	
	/**
	 * Fjerner det største elementet fra treet hvis det finnes
	 * 
	 * @return det største elementet, null hvis det ikke finnes
	 */
	public T fjernMaks();
	
	/*
	 * Fjerner et element fra dette treet hvis det fins, ellers returneres null
	 */
	// public T fjern(T element);
	// Ikke implementert
}

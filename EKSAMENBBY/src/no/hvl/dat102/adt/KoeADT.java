package no.hvl.dat102.adt;

public interface KoeADT<T> {
	
	/**
	 * Setter inn et element bakerst i køen.
	 * @param element er elementet vi skal sette inn
	 */
	void innKoe(T element);
	
	/**
	 * Fjerner det fremste elementet i køen så lenge køen ikke er tom
	 * @return elementet som blir fjernet
	 * @exception EmptyCollectionException kastes hvis køen er tom
	 */
	T utKoe();
	
	/**
	 * Henter ut det første elementet i køen
	 * @return Elementet
	 * @exception EmptyCollectionException kastes hvis køen er tom
	 */
	T foerste();
	
	/**
	 * Sjekker om køen er tom
	 * @return sann hvis køen er tom, usann ellers
	 */
	boolean erTom();
	
	/**
	 * Gir ut antallet elementer i køen
	 * @return antallet elementer i køen
	 */
	int antall();
}

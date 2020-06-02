package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;

public interface HaugADT<T extends Comparable<T>> {
	/**
	 *
	 * @param el er elementet som skal legges til haugen
	 */
	public void leggTilElement(T el);

	/**
	 * Fjerner rotelementet fra haugen
	 * 
	 * @return elementet med lavest verdi.
	 * @throws EmptyCollectionException unntak som kastes hvis haugen er tom fra før
	 */
	public T fjernMinste() throws EmptyCollectionException;

	/**
	 * Returnerer antall elementer i haugen
	 * 
	 * @return antall elementer i haugen
	 */
	public int antall();

	/**
	 * Avgjør om haugen er tom
	 * 
	 * @return true hvis haugen er tom, false ellers
	 */
	public boolean erTom();

}

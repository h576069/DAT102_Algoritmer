package no.hvl.dat102.adt;

public interface HaugADT<T extends Comparable<T>> {
	
	/**
	 * Metode som legger til et element i haugen
	 * 
	 * @param el, elementet som skal legges til
	 */
	void leggTilElement(T el);
	
	/**
	 * Fjerner det minste elementet fra haugen
	 * 
	 * @return Elementet med lavest verdi eller null-referanse hvis haugen er tom
	 */
	T fjernMinste();

	/**
	 * Finner det minste elementet i haugen
	 * 
	 * @return Elementet med lavest verdi eller null-referanse hvis haugen er tom
	 */
	T finnMinste();
	
	/**
	 * Avgjør om haugen er tom
	 * 
	 * @return true hvis haugen er tom, false ellers
	 */
	boolean erTom();
}
package no.hvl.dat102.adt;

import no.hvl.dat102.LinearNode;

public interface OrdnetListeADT<T extends Comparable<T>> extends ListeADT<T> {

	
		
	/**
	 * Legger til det spesifiserte elementet til denne listen.
	 *
	 * @param element det nye elementet som skal legges til
	 */
	void leggTil(T element);

	LinearNode<T> getFoerste();

	void setFoerste(LinearNode<T> l);

	void setAntall(int i);


}

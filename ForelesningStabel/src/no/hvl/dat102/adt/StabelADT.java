package no.hvl.dat102.adt;

public interface StabelADT<T> { // En klasse for en hver objekttype vi ønsker siden vi bruker generisk type <T>
	/**
	 * Legger til et element på toppen av stabelen
	 * @param element generisk element som stables på
	 */
	public void push(T element);
	
	/**
	 * Fjerner et element. Kaster unntak hvis stabelen allerede er tom.
	 * @return T element fjernes fra toppen av stabelen
	 * @exception EmptyCollectionException
	 */
	public T pop();
	
	/**
	 * Fjerner ikke, bare kopierer topp elementet
	 * @return
	 */
	public T peek();
	
	/**
	 * Sjekker om stabelen er tom
	 * @return true hvis tom, false ellers
	 */
	public boolean erTom();
	
	/**
	 * Returnerer antall elementer på stabelen
	 * @return antall elementer
	 */
	public int antall();
	
	
}

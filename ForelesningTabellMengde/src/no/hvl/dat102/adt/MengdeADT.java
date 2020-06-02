package no.hvl.dat102.adt;

public interface MengdeADT<T> {
	/* De abstrakte metodene under svarer til operasjoner i en ADT for en mengde */
	
	
	/*
	 * Attributter:
	 * antall - antall elementer i mengden
	 * 
	 * Operasjoner
	 * leggTil(type el) - legge nytt element til mengden hvis det ikke fins fra før
	 * 			forkrav: ingen
	 * 			hensikt: legge til et element til mengden som ikke fins fra før
	 * 			resultat: elementet er lagt til mengden
	 * 			retur: ingen
	 * 
	 * 
	 * leggTilAlle(type m) - legge mengden m til denne mengden
	 * fjern(type el) - fjerne og returnerer element fra mengden
	 * 			forkrav: mengden er ikke-tom
	 * 			hensikt: fjerne og returnerer element, el fra mengden
	 * 			resultat: elementet er fjernet, antall er minket med 1
	 * 			retur: elementet som ble fjernet eller null hvis elementet ikke var i mengden
	 * 
	 * 
	 * 
	 * 
	 * fjernTilfeldig() - fjern og returnere et tilfeldig element fra mengden
	 * inneholder(type el) - returnerer sann dersom el fins i mengden ellers usann
	 * erLik(type m2) - tester om denne mengden er lik parameter
	 * erTom() - tester om denne mengden er tom
	 * antall() - finner antall i mengden
	 * union(type m2) - danner union av denne mengden og parameter
	 * oppramser() - lager et oppramser-objekt
	 */
	
	/**
	 * Legger til et element til dette mengde-objektet (this) hvis det ikke fins fra før
	 * @param elementet som skal legges til betinget
	 */
	void leggTil(T element);
	
	/**
	 * Legger til de elementer i m2 som ikke fins fra før i denne mengden (this)
	 * @param m2 er mengden som skal legges til denne mengden
	 */
	void leggTilAlle(MengdeADT<T> m2);
	
	/**
	 * Fjerner og returnerer et tilfeldig element fra mengden
	 * @return returnerer det tilfeldige ellementet, ellers returnerer null
	 * @exception EmptyCollectionException unntak kastes hvis mengden allerede er tom
	 */
	T fjernTilfeldig();
	
	/**
	 * 
	 * @param element er elementet som skal fjernes hvis det fins ellers returnerer null
	 * @return elementet som fjernes
	 * @exception EmptyCollectionException unntak kastes hvis mengden allerede er tom
	 */
	T fjern(T element);
	
	/**
	 * 
	 * @param elementet er det gitte elementet
	 * @return sann hvis elementet fins ellers usann
	 */
	boolean inneholder(T element);
	
//	/**
//	 * Tester om this-mengden og parameteren inneholder nøyaktig de samme elementene
//	 * @param m2 er parametermengden
//	 * @return sann hvis m1 og m2 er like, ellers usann
//	 */
//	boolean equals(MengdeADT<T> m2);
	
	/**
	 * Tester om mengden er tom (dvs. har 0 element)
	 * @return sann hvis mengden er tom ellers usann
	 */
	boolean erTom();
	
	/**
	 * Finner antall elementer i mengden
	 * @return antall i mengden
	 */
	int antall();
	
//	/**
//	 * 
//	 * @param m2 er mengden det skal lages union med 
//	 * @return er union av mengden m2 og this-mengden
//	 */
//	MengdeADT<T> union(MengdeADT<T> m2);
//	
//	/**
//	 * Lager en ny mengde som er snittet av mengden m1 og m2
//	 * @param m2 er parameter
//	 * @return snittet av de to mengdene
//	 */
//	MengdeADT<T> snitt(MengdeADT<T> m2);
//	
//	/**
//	 * Lager en ny mengde som er differensen av m1 og m2
//	 * 
//	 * @param m2 er parameteren
//	 * @return differensen av de to mengdene
//	 */
//	MengdeADT<T> differens(MengdeADT<T> m2);
//	
//	/**
//	 * 
//	 * @param m2 er parameteren
//	 * @return sann hvis m2 er en undermengde av this-mengden, ellers usann
//	 */
//	boolean undermengde(MengdeADT<T> m2);
	
	/**
	 * Oppretter et 'oppramsobjekt' som kan brukes til å gjennomgå alle elementer
	 * i mengden etter tur en gang
	 * 
	 * @return et oppramsobjekt
	 */
	Iterator<T> oppramser();
	
}

package no.hvl.dat102;
import no.hvl.dat102.adt.*;

public class TabellStabel<T> implements StabelADT<T>{
	private final static int STDK = 100;
	private int topp;
	private T[] stabel;
	
	public TabellStabel() {
		this(STDK);
	}
	
	public TabellStabel(int startKapasitet) {
		this.topp = 0;
		// Kan ikke bruke new T[] på generiske typer
		// Må derfor caste (T[]) en Object tabell
		this.stabel = (T[]) (new Object[startKapasitet]);
	}
	
	// Husk å bruke Override på metodene du implementerer
	
	@Override
	public void push(T element) {
		if (antall() == stabel.length)
			utvid();
		stabel[topp] = element;
		topp++;
		
	}
	
	@Override
	public T pop() {
		if (erTom()) // Når vi kaster i en if så bruker vi ikke {}
			throw new EmptyCollectionException("Stabel");
		
		topp--;
		T resultat = stabel[topp];
		stabel[topp] = null;
		
		return resultat;
	}
	
	@Override
	public T peek() {
		if (erTom()) 
			throw new EmptyCollectionException("Stabel");
		return stabel[topp-1];
	}
	
	@Override
	public boolean erTom() {
		return (topp == 0);
	}
	
	@Override
	public int antall() {
		return topp;
	}
	
	// Hjelpefunksjon for å utvide tabellen:
	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[stabel.length*2]);
		
		for (int i = 0; i < stabel.length; i++) {
			hjelpeTabell[i] = stabel[i];
		}
		stabel = hjelpeTabell;
	}
}

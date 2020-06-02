package no.hvl.dat102;

// Representerer situasjonen når samlingen er tom.

public class EmptyCollectionException extends RuntimeException {
	public EmptyCollectionException(String samling) {
		super("" + samling + " er tom.");
	}
}

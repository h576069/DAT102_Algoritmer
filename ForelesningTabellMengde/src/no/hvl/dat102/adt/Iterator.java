package no.hvl.dat102.adt;

public interface Iterator<T> {
	
	boolean hasNext();
	
	T next();
	
	void remove();

}

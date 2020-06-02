package no.hvl.dat102;
import no.hvl.dat102.adt.*;

public class KjedetStabel<T> implements StabelADT<T> {
	private LinearNode<T> topp;
	private int antall;
	
	public KjedetStabel() {
		this.topp = null;
		this.antall = 0;
	}
	
	@Override
	public void push(T el) {
		LinearNode<T> nynode = new LinearNode<T>(el);
		nynode.setNeste(this.topp);
		this.topp = nynode;
		this.antall++;
	}
	
	@Override
	public T pop() {
		if (erTom())
			throw new EmptyCollectionException("stabel");
		
		T resultat = this.topp.getElement();
		this.topp = this.topp.getNeste();
		this.antall--;
		return resultat;
	}
	
	@Override
	public T peek() {
		if (erTom())
			throw new EmptyCollectionException("stabel");
		return this.topp.getElement();
	}
	
	public boolean erTom() {
		return (this.antall==0);
	}
	
	public int antall() {
		return this.antall;
	}
}

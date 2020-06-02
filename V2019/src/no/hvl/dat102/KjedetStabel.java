package no.hvl.dat102;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.exception.EmptyCollectionException;

public class KjedetStabel<T> implements StabelADT<T> {
	private LinearNode<T> topp;
	private int antall;
	
	public KjedetStabel() {
		topp = null;
		antall = 0;
	}

	@Override
	public void push(T el) {
		  LinearNode<T> ny = new LinearNode<T>(el);
		  ny.setNeste(this.topp);
		  this.topp = ny;
		  this.antall++;
		}

	@Override
	public T pop() {
		if (erTom()) {
		    throw new EmptyCollectionException("stabelen");
		  }
		  T resultat = this.topp.getElement();
		  this.topp = this.topp.getNeste();
		  this.antall--;
		  return resultat;
	}

	@Override
	public T peek() {
		if (erTom()) {
		    throw new EmptyCollectionException("stabelen");
		  }
		  return (this.topp.getElement());
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public String toString() {
		LinearNode<T> p = topp;
		String res = "[ ";
		while (p != null) {
			res += (p.getElement() + " ");
			p = p.getNeste();
		}
		res += "]";
		return res;
	}
	
	
	
}

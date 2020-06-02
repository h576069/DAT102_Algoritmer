package no.hvl.dat102.kjedet;

import java.util.Iterator;

import no.hvl.dat102.adt.MengdeADT;
import no.hvl.dat102.noder.LinearNode;

public class KjedetMengde<T> implements MengdeADT<T> {
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;
	
	
	public KjedetMengde() {
		//…Fyll ut
	}
	
	public boolean inneholder(T element){
		return false;
		//…Fyll ut
		
	}
	public boolean underMengde(MengdeADT<T> m2) {
		return false;
		//…Fyll ut
	}
	public boolean erTom() {
		return antall == 0;
	}
	
	public int antall() {
		return antall;
	}
	
	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}
}

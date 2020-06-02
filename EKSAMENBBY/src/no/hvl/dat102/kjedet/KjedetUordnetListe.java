package no.hvl.dat102.kjedet;

import no.hvl.dat102.noder.LinearNode;

public class KjedetUordnetListe<T extends Comparable<T>> {
	private int antall;
	private LinearNode<T> foerste;

	// Konstruktør
	public KjedetUordnetListe() {
		antall = 0;
		foerste = null;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	public LinearNode<T> getFoerste() {
		return foerste;
	}

	public void setFoerste(LinearNode<T> foerste) {
		this.foerste = foerste;
	}

	public String toString() {
		return toString(foerste);
	}

	private String toString(LinearNode<T> p) {
		if (p == null) {
			return "\n";
		} else {
			return (p.getElement() + "\n" + toString(p.getNeste()));
		}
	}

	public void settInn(T el) {
		LinearNode<T> ny = new LinearNode<T>(el);
		if (antall != 0) {
			ny.setNeste(this.foerste);
		}
		this.foerste = ny;
		antall++;
	}

	public void flyttFoersteTilSiste() {
		if (antall > 1) { // ikke vits om vi kun har en node
			LinearNode<T> nySiste = this.foerste;
			this.foerste = this.foerste.getNeste();
			nySiste.setNeste(null);
			LinearNode<T> p = this.foerste;
			while (p.getNeste() != null) {
				p = p.getNeste();
			}
			p.setNeste(nySiste);
		}
	}

	public T finnNestMinste() {
		  if (antall < 2) {
		    return null;
		  } else {
		    T minste = this.foerste.getElement();
		    T nestMinste = minste;
		    LinearNode<T> p = this.foerste;
		    while (p != null) {
		      if (p.getElement().compareTo(minste) < 0) {
		        nestMinste = minste;
		        minste = p.getElement();
		      } else if (p.getElement().compareTo(nestMinste) < 0) {
		        nestMinste = p.getElement();
		      }
		      p = p.getNeste();
		    }
		    return nestMinste;
		  }
		}
}

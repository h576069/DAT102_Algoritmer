package no.hvl.dat102;

public class BinaerTreNode<T> {
	private T element;
	private BinaerTreNode<T> venstre, hoyre;
	
	public BinaerTreNode(T el) {
		venstre = null;
		hoyre = null;
		element = el;
	}

	public BinaerTreNode(T element, BinaerTreNode<T> venstre, BinaerTreNode<T> hoyre) {
		super();
		this.element = element;
		this.venstre = venstre;
		this.hoyre = hoyre;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public BinaerTreNode<T> getVenstre() {
		return venstre;
	}

	public void setVenstre(BinaerTreNode<T> venstre) {
		this.venstre = venstre;
	}

	public BinaerTreNode<T> getHoyre() {
		return hoyre;
	}

	public void setHoyre(BinaerTreNode<T> hoyre) {
		this.hoyre = hoyre;
	}
	
	
}

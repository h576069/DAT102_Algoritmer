package no.hvl.dat102;

public class BinaerTreNode<T> {
	private T element;
	private BinaerTreNode<T> venstre;
	private BinaerTreNode<T> hoyre;
	
	/**
	 * Oppretter et nytt tre med spesifiserte data
	 * 
	 * @param el, spesifiserte data
	 */
	BinaerTreNode(T el) {
		this.element = el;
		this.venstre = null;
		this.hoyre = null;
	}
	
	/**
	 * Oppretter et nytt tre med mye spesifiserte data
	 * 
	 * @param element, rot elementet
	 * @param venstre, venstre barn
	 * @param hoyre, høyre barn
	 */
	BinaerTreNode(T element, BinaerTreNode<T> venstre, BinaerTreNode<T> hoyre) {
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

package no.hvl.dat102;

/*
 * Hjelpeklasse for kjedet struktur
 */

public class LinearNode<T> {
	
	private LinearNode<T> neste;
	private T element;
	
	/**
	 * Oppretter en tom node
	 */
	public LinearNode() {
		this.neste = null;
		this.element = null;
	}
	
	/**
	 * Oppretter en node med et element
	 * @param elem elementet som skal inn i noden
	 */
	public LinearNode(T elem) {
		this.neste = null;
		this.element = elem;
	}
	
	/**
	 * Returnerer etterfølger
	 * @return neste node
	 */
	public LinearNode<T> getNeste() {
		return this.neste;
	}
	
	/**
	 * Setter neste til node
	 * @param node neste node
	 */
	public void setNeste(LinearNode<T> node) {
		this.neste = node;
	}
	
	/**
	 * Returnerer elementet til denne noden
	 * @return elementet
	 */
	public T getElement() {
		return this.element;
	}
	
	/**
	 * Setter nytt element i denne noden
	 * @param elem nytt element
	 */
	public void setElement(T elem) {
		this.element = elem;
	}
}

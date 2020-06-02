package no.hvl.dat102;

public class Liste<T> {
	private LinearNode<T> start;
	private int antall;
	
	public boolean inneholder(T element) {
		LinearNode<T> denne = this.start;
		while (denne!= null && !element.equals(denne.getElement())) {
			denne = denne.getNeste();
		}
		return (denne != null);
	}
	
	/*
	 * Sette node inn foran:
	 * Tilsvarende til push for stabel.
	 */
	public void leggTilForan(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(this.start);
		this.start = nyNode;
		this.antall++;
	}
	
	/*
	 * Sette node inn bak denne
	 */
	public void leggTilBak(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(this.start.getNeste());
		this.start.setNeste(nyNode);
		this.antall++;
	}
	
	/*
	 * Slette/fjerne fra listen
	 * fjern(element)
	 * if tom liste --> ikke gjør noe
	 * if element er første --> oppdater start
	 * if element er midt i eller bak --> slett
	 * 
	 * forrige.setNeste(denne.getNeste())
	 */
	public boolean fjern(T element) {
		// INITIERING
		boolean slettet = false; // Setter slettet til usann
		LinearNode<T> forrige = null; // Setter forrige til null
		LinearNode<T> p = this.start; // Setter p til start
		
		// TEST PÅ IKKE-TOM LISTE
		if (this.antall != 0 && inneholder(element)) {
			// TEST PÅ FØRSTE NODE
			if (element.equals(this.start.getElement())) {
				// FØRSTE NODE:
				// Oppdaterer start-referansen
				this.start = this.start.getNeste();
				slettet = true;
			} else {
				while (!element.equals(p.getElement())) {
					forrige = p;
					p = p.getNeste();
				}
				// denne = skal slettes
				forrige.setNeste(p.getNeste());
				slettet = true;
			}
			this.antall--;

		}
		// Else: nothing happens
		return slettet;
		
		
	}
	
}

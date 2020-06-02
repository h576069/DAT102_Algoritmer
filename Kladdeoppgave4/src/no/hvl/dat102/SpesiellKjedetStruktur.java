package no.hvl.dat102;

public class SpesiellKjedetStruktur<T> {
	private int antall;
	private LinearNode<T> start;

	// Oppretter en tom mengde:
	public SpesiellKjedetStruktur() {
		this.antall = 0;
		this.start = null;
	}

	// Legger til elementet foran i denne mengden:
	public void leggTil(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(this.start);
		this.start = nyNode;
		this.antall++;
	}

	// Snu listen --> TODO:
	public void snuKjedetStruktur() {
		// s peker på første noden i strukturen som skal snues:
		LinearNode<T> r, n, s;

		// initier r (= den reverserte strukturen)
		s = this.start;
		r = null;

		while (s != null) { // går gjennom strukturen som den er nå
			n = s; // setter dummy variabel til nåværende node
			s = s.getNeste(); // Går videre i originale strukturen
			n.setNeste(r); // setter nåværende node inn foran r, vil da få denne bakerst
			r = n; // Oppdaterer r-pekeren
		}
		this.start = r; // Oppdaterer strukturen

	}
	public void snuKjedetStruktur2() {
		LinearNode<T> p = this.start;
		LinearNode<T> snudd = null;
		LinearNode<T> s = null;
		
		while (p != null) {
			s = p;
			p = p.getNeste();
			s.setNeste(snudd);
			snudd = s;
		}
		this.start = snudd;
	}

	// Returnerer sann hvis mengden er tom og usann ellers
	public boolean erTom() {
		return (this.antall == 0);
	}

	// Returnerer antall elementer i den kjedete strukturen
	public int antall() {
		return this.antall;
	}

	// Returnerer en strengrepresentasjon av elementene
	public String toString() {
		String resultat = "";
		LinearNode<T> aktuell = this.start;
		while (aktuell != null) {
			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}
		return resultat;
	}

	// i) Finner og returnerer antall elementer i strukturen som er lik elementet
	// gitt i parameteren
	public int finnAntallLik(T e1) {
		LinearNode<T> denne = this.start;
		int count = 0;
		while (denne != null) {
			if (denne.getElement().equals(e1)) {
				count++;
			}
			denne = denne.getNeste();
		}
		return count;
	}

	// ii) Legger til en ny node med elementet nyttElement rett bak noden med
	// elementet el
	// Dersom el ikke fins i strukturen, skal den nye noden plasseres inn helt
	// framme
	public void leggTilBak(T e1, T nyttElement) {
		LinearNode<T> denne = this.start;
		LinearNode<T> nytt = new LinearNode<T>(nyttElement);
		boolean funnet = false;

		// Sjekker om listen er tom:
		if (denne == null) {
			this.start = nytt;
		} else {
			while (denne != null && !funnet) {
				if (denne.getElement().equals(e1)) {
					nytt.setNeste(denne.getNeste());
					denne.setNeste(nytt);
					funnet = true;
				} else {
					denne = denne.getNeste();
				}
			}

			if (!funnet) { // Innsetting foran
				nytt.setNeste(this.start);
				this.start = nytt;
				this.antall++;
			}
			this.antall++;
		}

	}

}

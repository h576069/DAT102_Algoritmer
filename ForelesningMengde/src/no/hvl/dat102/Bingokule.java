package no.hvl.dat102;

public class Bingokule {
	// Til å representere 'bingo-verdier' B10, N43, ... osv
	private char bokstav;
	private int tall;
	
	public Bingokule(int verdi) {
		// Konstruktør med parameter mellom 1 og 75
		
		this.tall = verdi;
		if (verdi <= 15)
			this.bokstav = 'B';
		else if (verdi <= 30)
			this.bokstav = 'I';
		else if (verdi <= 45)
			this.bokstav = 'N';
		else if (verdi <= 60)
			this.bokstav = 'G';
		else
			this.bokstav = 'O';
	}
	
	/* Til å teste om to bingokuler er like */
	public boolean equals(Object k2) {
		Bingokule b2 = (Bingokule) k2; // Nødvendig type konvertering
		return (this.tall == b2.tall && this.bokstav == b2.bokstav);
	}
	
	/* String representasjon av bingokule (til utskrift) */
	public String toString() {
		return this.bokstav + " " + this.tall;
	}

}

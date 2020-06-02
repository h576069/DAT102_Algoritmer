package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class Datakontakt {
	// Objektvariabler:
	private Medlem[] medlemstabell;
	private int antall;
	private final static int STDK = 100;

	// Konstruktører:
	public Datakontakt(int startkapasitet) {
		this.medlemstabell = new Medlem[startkapasitet];
		this.antall = 0;
	}

	public Datakontakt() {
		this(STDK);
	}

	public Medlem[] getMedlemstabell() {
		return this.medlemstabell;
	}

	public void setMedlemstabell(Medlem[] medlemstabell) {
		this.medlemstabell = medlemstabell;
	}

	public int getAntall() {
		return this.antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	private void utvid() {
		Medlem[] hjelpetabell = new Medlem[2 * this.medlemstabell.length];
		for (int i = 0; i < this.antall; i++) {
			hjelpetabell[i] = this.medlemstabell[i];
		}
		this.medlemstabell = hjelpetabell;
	}

	// Legger til et nytt medlem i medlemstabellen
	public void leggTilMedlem(Medlem person) {
		if (this.antall == this.medlemstabell.length) {
			utvid();
		}
		this.medlemstabell[this.antall] = person;
		this.antall++;
	}

	// Finner indeksen til medlemmet i medlemstabellen dersom medlemmet er
	// registrert
	// Ellers returneres indeks lik -1
	public int finnMedlemsIndeks(String medlemsnavn) {
		int indeks = -1;
		boolean funnet = false;
		int i = 0;
		while (i < this.antall && !funnet) {
			if (this.medlemstabell[i].getNavn().equals(medlemsnavn)) {
				indeks = i;
				funnet = true;
			}
			i++;
		}

		return indeks;
	}

	// Finner ut om et medlem passer med et annet medlem (hvis det finnes).
	public int finnPartnerFor(String medlemsnavn) {
		// Må sjekke at medlemmet finnes i tabellen:
		int indeks1 = finnMedlemsIndeks(medlemsnavn);
		// Gjør klar variabel for partneren:
		int indeks2 = -1;

		if (indeks1 == -1) { // Medlemmet finnes ikke i tabellen
			System.out.println("Medlemmet du leter etter finnes ikke.");
		} else { // Medlemmet finnes i tabellen
			// Må sjekke at statusindeksen er -1:
			if (this.medlemstabell[indeks1].getStatusIndeks() != -1) {
				// Da har denne allerede en partner:
				System.out.println("Medlemmet er allerede i et par.");
			} else {
				// Kan nå finne en partner til medlemmet

				// Henter ut hobbyene til medlemmet:
				MengdeADT<Hobby> hobby1 = this.medlemstabell[indeks1].getHobbyer();

				// Leiter etter en partner:
				int i = 0;
				boolean funnet = false;
				while (i < this.antall && !funnet) {
					if (hobby1.equals(this.medlemstabell[i].getHobbyer()) && i != indeks1) {
						funnet = true;
						indeks2 = i;
						this.medlemstabell[indeks1].setStatusIndeks(indeks2);
						this.medlemstabell[indeks2].setStatusIndeks(indeks1);

					}
					i++;
				}
			}
		}
		return indeks2;
	}

	// Oppdaterer medlemstabellen slik at medlemmet og dets partner ikke lenger er
	// koblet
	public void tilbakestillStatusIndeks(String medlemsnavn) {
		int indeks1 = finnMedlemsIndeks(medlemsnavn);
		if (indeks1 == -1) {
			System.out.println("Medlemmet du leter etter finnes ikke.");
		} else {
			int indeks2 = this.medlemstabell[indeks1].getStatusIndeks();
			if (indeks2 == -1) {
				System.out.println("Dette medlemmet er ikke koblet til noen.");
			} else {
				this.medlemstabell[indeks1].setStatusIndeks(-1);
				this.medlemstabell[indeks2].setStatusIndeks(-1);
			}
		}
	}

	/*
	 * Hjelpemetode som sjekker om en verdi (val) eksisterer i en spesifikk tabell
	 * (arr).
	 * 
	 * Returnerer true hvis verdien er i tabellen, false ellers.
	 */
	private boolean inArr(int[] arr, int val) {
		int i = 0;
		boolean funnet = false;
		while (i < arr.length && !funnet) {
			if (arr[i] == val) {
				funnet = true;
			}
			i++;
		}
		return funnet;
	}

	/*
	 * Hjelpemetode som trimmer en tabell slik at man unngår mange null-verdier i
	 * tabellen.
	 * 
	 * Tar inn den gamle tabellen (gammel) og antallet elementer vi har i tabellen
	 * som ikke er null (count).
	 * 
	 * Returnerer en ny tabell som da er full.
	 */
	private int[] trimmet(int[] gammel, int count) {
		int[] ny = new int[count];
		for (int i = 0; i < count; i++) {
			ny[i] = gammel[i];
		}
		return ny;
	}

	/*
	 * Metode for å finne alle parene i tabellen.
	 * 
	 * Returnerer en int[] tabell som inneholder indeksene til parene i
	 * medlemstabellen.
	 * 
	 * Retur tabellen er på formatet: {x, y, z, q} hvor da x og y er partnere og z
	 * og q er partnere
	 * 
	 */
	public int[] finnAllePar() {
		int[] tatt = new int[this.antall];
		int tattAntall = 0;

		for (int i = 0; i < this.antall; i++) {
			int currStIndeks = this.medlemstabell[i].getStatusIndeks();
			if (currStIndeks != -1 && !inArr(tatt, i)) {
				tatt[tattAntall] = i;
				tattAntall++;
				tatt[tattAntall] = currStIndeks;
				tattAntall++;
			}
		}
		return trimmet(tatt, tattAntall);
	}

	/*
	 * Metode som ser på alle parene i tabellen og kobler sammen de som kan være
	 * partnere.
	 * 
	 * Altså vil denne metoden oppdatere statusindeksen til de medlemmene som har
	 * partnere i tabellen.
	 * 
	 */
	public void kobleAllePar() {
		for (int i = 0; i < this.antall; i++) {
			if (this.medlemstabell[i].getStatusIndeks() == -1) {
				int indeks = finnPartnerFor(this.medlemstabell[i].getNavn());
				if (indeks != -1) {
					this.medlemstabell[i].setStatusIndeks(indeks);
					this.medlemstabell[indeks].setStatusIndeks(i);
				}
			}
		}
	}

}

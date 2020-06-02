package no.hvl.dat102;

import no.hvl.dat102.adt.FilmArkivADT;

public class FilmArkiv2 implements FilmArkivADT {
	private LinearNode<Film> start;
	private int antall;

	public FilmArkiv2() {
		this.start = null;
		this.antall = 0;
	}

	// Metode for å hente ut objektvariabler:
	@Override
	public int getAntall() {
		return this.antall;
	}

	// Metode for å hente ut filmtabellen:
	@Override
	public Film[] hentFilmTabell() {
		Film[] filmer = new Film[this.antall];
		LinearNode<Film> denne = this.start;
		filmer[0] = denne.getElement();
		for (int i = 1; i < this.antall; i++) {
			denne = denne.getNeste();
			filmer[i] = denne.getElement();
		}
		return filmer;
	}

	// Metoden for å legge til ny film:
	@Override
	public void leggTilFilm(Film nyFilm) {
		// Oppretter node for den nye filmen:
		LinearNode<Film> ny = new LinearNode<Film>(nyFilm);
		// Setter inn foran den første noden:
		ny.setNeste(this.start);
		// Oppdaterer start:
		this.start = ny;
		// Øker antall med en
		this.antall++;
	}

	// Metoden for å slette en film:
	@Override
	public boolean slettFilm(int filmNr) {
		// Må loope over alle filmene for å finne en match på filmNr:
		LinearNode<Film> denne = this.start;
		boolean found = false;
		// Sjekker om det gjelder den første filmen:
		if (denne.getElement().getNr() == filmNr) {
			this.start = this.start.getNeste();
			found = true;
			this.antall--;
		} else {
			// Looper gjennom hele kjeden:
			while (denne.getNeste() != null) {
				if (denne.getNeste().getElement().getNr() == filmNr) {
					// Hvis den neste noden har matchende filmNr:
					found = true;
					break;
				}
				// Fortsetter å loope
				denne = denne.getNeste();
			}
			// Sjekker at den faktisk ble funnet:
			if (found) {
				// Sletter neste noden:
				if (denne.getNeste().getNeste() == null) {
					denne.setNeste(null);
				} else {
					denne.setNeste(denne.getNeste().getNeste());
				}
				this.antall--;
			}
		}
		return found;
	}

	private Film[] trimmer(Film[] gammel, int count) {
		// Den nye tabellen som er trimmet:
		Film[] ny = new Film[count];

		// Looper over:
		for (int i = 0; i < count; i++) {
			ny[i] = gammel[i];
		}

		return ny;

	}

	// Metoden for å finne filmer med en delstreng i tittelen
	@Override
	public Film[] sokTittel(String delstreng) {
		// Opprette en tabell med antall elementer
		Film[] filmer = new Film[this.antall];
		// Må loope over alle
		LinearNode<Film> denne = this.start;
		int count = 0;
		while (denne != null) {
			if (denne.getElement().getTittel().contains(delstreng)) {
				filmer[count] = denne.getElement();
				count++;
			}
			denne = denne.getNeste();
		}
		if (count > 0 && count < this.antall) {
			return trimmer(filmer, count);
		}
		// Hvis vi ikke hadde noen matcher:
		System.out.println("Fant ingen filmer med " + delstreng + " i tittelen sin.");
		return null;
	}

	// Metode for å finne produsenter med delstreng i produsent navnet
	@Override
	public Film[] sokProdusent(String delstreng) {
		// Opprette en tabell med antall elementer
		Film[] filmer = new Film[this.antall];
		// Må loope over alle
		LinearNode<Film> denne = this.start;
		int count = 0;
		while (denne != null) {
			if (denne.getElement().getProdusent().contains(delstreng)) {
				filmer[count] = denne.getElement();
				count++;
			}
			denne = denne.getNeste();
		}
		if (count > 0 && count < this.antall) {
			return trimmer(filmer, count);
		}
		// Hvis vi ikke hadde noen matcher:
		System.out.println("Fant ingen produsenter med " + delstreng + " i navnet sitt.");
		return null;
	}

	// Metode for å finne antallet filmer med en bestemt sjanger:
	@Override
	public int antallSjanger(Sjanger sjanger) {
		// Teller antallet:
		int count = 0;
		// Lager en løkke:
		LinearNode<Film> denne = this.start;
		while (denne != null) {
			if (denne.getElement().getSjanger() == sjanger) {
				count++;
			}
			denne = denne.getNeste();
		}
		return count;
	}

	// Metode for å finne en film ut fra filmnummeret:
	public Film finnFilmMedNummer(int filmNr) {
		LinearNode<Film> denne = this.start;
		boolean found = false;
		while (denne != null) {
			if (denne.getElement().getNr() == filmNr) {
				found = true;
				break;
			}
			denne = denne.getNeste();
		}
		if (found) {
			return denne.getElement();
		}
		System.out.println("Filmen finnes ikke i arkivet.");
		return null;
	}
}

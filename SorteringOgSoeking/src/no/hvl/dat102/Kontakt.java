package no.hvl.dat102;

public class Kontakt implements Comparable<Kontakt>{
	private String fornavn;
	private String etternavn;
	private String telefonnr;
	
	public Kontakt(String fnavn, String enavn, String telefon) {
		this.fornavn = fnavn;
		this.etternavn = enavn;
		this.telefonnr = telefon;
	}
	
	// Returnerer en kontakt som en strengrepresentasjon
	public String toString() {
		return this.etternavn + ", " + this.fornavn + "\t" + this.telefonnr;
	}
	
	// Bruker etternavn og fornavnt for å bestemme en leksikografisk ordning
	@Override
	public int compareTo(Kontakt kontakt) {
		int resultat = 0;
		if (this.etternavn.equals(kontakt.etternavn)) {
			resultat = this.fornavn.compareTo(kontakt.fornavn);
		} else {
			resultat = this.etternavn.compareTo(kontakt.etternavn);
		}
		return resultat;
	}
}

package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.tabell.*;

public class Medlem {
	// Objektvariabler
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	// Konstruktør:
	public Medlem(String navn) {
		this.navn = navn;
		this.statusIndeks = -1;
		this.hobbyer = new TabellMengde<Hobby>();
	}

	// Get-set funksjoner
	public String getNavn() {
		return this.navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return this.hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return this.statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	// Avgjør om to medlemmer passer til hverandre og kan da danne par.
	public boolean passerTil(Medlem medlem2) {
		return this.getHobbyer().equals(medlem2.getHobbyer());
	}

	// Metode for å legge til en hobby:
	public void leggTilHobby(String hobbyNavn) {
		this.hobbyer.leggTil(new Hobby(hobbyNavn));
	}
	
	public MengdeADT<Hobby> unionHobby(Medlem medlem2) {
		return this.hobbyer.union(medlem2.getHobbyer());
	}
	
	public MengdeADT<Hobby> snittHobby(Medlem medlem2) {
		return this.hobbyer.snitt(medlem2.getHobbyer());
	}
	
	public MengdeADT<Hobby> differensHobby(Medlem medlem2) {
		return this.hobbyer.differens(medlem2.getHobbyer());
	}
	
	public String toString() {
		return this.getNavn() + ", " + this.getStatusIndeks() + ", " + this.hobbyer.toString();
	}
	
	public void printMedlem() {
		System.out.println(this.toString());
	}
}

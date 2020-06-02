package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class TabellHaug<T extends Comparable<T>> implements HaugADT<T> {
	// Lager en minimumshaug
	
	private T[] data;
	private int antall;
	
	private static final int STDK = 100;
	
	public TabellHaug() {
		this.data = (T[]) new Comparable[STDK];
		this.antall = 0;
	}

	@Override
	public void leggTilElement(T el) {
		if (this.antall == this.data.length)
			utvidTabell();
		
		this.data[this.antall] = el; // Plasserer den nye helt sist
		this.antall++;
		if (this.antall > 1)
			reparerOpp(); // Bytt om oppover hvis nødvendig
	}
	
	private void utvidTabell() {
		// Dobler tabellen ved behov for utviding
		int lengde = this.data.length;
		T[] ny = (T[]) new Comparable[2*lengde];
		for (int i = 0; i < this.antall; i++)
			ny[i] = this.data[i];
		this.data = ny;
	}
	
	private void reparerOpp() {
		T hjelp; // Hjelpe-variabel
		int siste = this.antall-1;
		int forelder = (siste - 1) / 2;
		boolean ferdig = false;
		
		while (!ferdig && forelder >= 0) {
			if (this.data[siste].compareTo(this.data[forelder]) < 0) {
				hjelp = this.data[forelder];
				this.data[forelder] = this.data[siste];
				this.data[siste] = hjelp;
				
				// Oppdaterer indekser:
				siste = forelder;
				forelder = (siste - 1) / 2;
			} else {
				ferdig = true;
			}	
		}
	}

	@Override
	public T fjernMinste() {
		T svar = null;
		if (this.antall > 0) {
			svar = this.data[0];
			this.data[0] = this.data[this.antall-1];
			reparerNed(); // Bytter om nedover hvis nødvendig
			this.antall--;
		}
		return svar;
	}
	
	private void reparerNed() {
		T hjelp;
		boolean ferdig = false;
		int forelder = 0; // Start i roten og sammenlign med neste nivå
		int minbarn;
		int vbarn = forelder * 2 + 1; // 2i + 1
		int hbarn = vbarn + 1; // 2i + 2
		
		while ((vbarn < this.antall) && !ferdig) { // Har flere noder lenger nede
			minbarn = vbarn;
			
			if ((hbarn < this.antall) && (this.data[hbarn]).compareTo(this.data[vbarn]) < 0) 
				minbarn = hbarn; // Har funnet det minste av barna. Sammenlign med forelder
			
			if (this.data[forelder].compareTo(this.data[minbarn]) <= 0)
				ferdig = true;
			else { // Bytt om og gå videre nedover hvis forelder er for stor
				hjelp = this.data[minbarn];
				this.data[minbarn] = this.data[forelder];
				this.data[forelder] = hjelp;
				
				forelder = minbarn;
				vbarn = forelder * 2 + 1;
				hbarn = vbarn + 1;
				
			}
		}
	}
	
	@Override
	public T finnMinste() {
		return data[0];
	}

	@Override
	public boolean erTom() {
		return (this.antall == 0);
	}
	
	public void skrivTab() {
		// Hjelpemetode til test
		for (int i = 0; i < this.antall; i++)
			System.out.print(this.data[i] + " ");
		System.out.println();
	}

}

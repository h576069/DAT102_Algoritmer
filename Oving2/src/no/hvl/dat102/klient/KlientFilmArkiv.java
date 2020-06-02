package no.hvl.dat102.klient;

import no.hvl.dat102.*;

public class KlientFilmArkiv {

	public static void main(String[] args) {
		FilmArkiv2 filma = new FilmArkiv2();
		Meny2 meny = new Meny2(filma);
		
		meny.start();
		meny.slutt();
	}
}

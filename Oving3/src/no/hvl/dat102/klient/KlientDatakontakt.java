package no.hvl.dat102.klient;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.tabell.*;

public class KlientDatakontakt {

	public static void main(String[] args) {
		// Her må vi forsøke alle metodene
		// Kan også lage andre metoder i tillegg
		
		Tekstgrensesnitt tekstgr = new Tekstgrensesnitt();
		Datakontakt dk = new Datakontakt();
		
		// Lager hobbylistene:
		MengdeADT<Hobby> hobby1 = new TabellMengde<Hobby>();
		hobby1.leggTil(new Hobby("ski"));
		hobby1.leggTil(new Hobby("musikk"));
		hobby1.leggTil(new Hobby("politikk"));
		
		MengdeADT<Hobby> hobby2 = new TabellMengde<Hobby>();
		hobby2.leggTil(new Hobby("epleplukking"));
		hobby2.leggTil(new Hobby("paradishopping"));
		
		// Medlemmer:
		Medlem m1 = new Medlem("Erna");
		m1.setHobbyer(hobby1);
		Medlem m2 = new Medlem("Jonas");
		m2.setHobbyer(hobby1);
		Medlem m3 = new Medlem("Eva");
		m3.setHobbyer(hobby2);
		Medlem m4 = new Medlem("Adam");
		m4.setHobbyer(hobby2);
		
		// Legger til medlemmene
		dk.leggTilMedlem(m1);
		dk.leggTilMedlem(m2);
		dk.leggTilMedlem(m3);
		dk.leggTilMedlem(m4);
		
		// Leser inn to ekstra medlemmer:
		dk.leggTilMedlem(tekstgr.lesMedlem());
		dk.leggTilMedlem(tekstgr.lesMedlem());
		
		// Skriver ut alle parene
		tekstgr.skrivParListe(dk);
		tekstgr.close();
		
	}
	

}

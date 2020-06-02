package no.hvl.dat102.klient;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.MengdeADT;
import no.hvl.dat102.tabell.*;

public class KlientMedlem {

	public static void main(String[] args) {
		// Oppretter noen medlemmer:
		Medlem m1 = new Medlem("Erna");
		Medlem m2 = new Medlem("Jonas");
		m1.leggTilHobby("ski");
		m1.leggTilHobby("musikk");
		m1.leggTilHobby("politikk");
		m2.leggTilHobby("ski");
		m2.leggTilHobby("musikk");
		m2.leggTilHobby("politikk");
		
		
		Medlem m3 = new Medlem("Eva");
		Medlem m4 = new Medlem("Adam");
		m3.leggTilHobby("epleplukking");
		m3.leggTilHobby("paradishopping");
		m4.leggTilHobby("epleplukking");
		m4.leggTilHobby("paradishopping");
		
		Medlem m5 = new Medlem("Anne");
		m5.leggTilHobby("TV");
		m5.leggTilHobby("Fest");
		Medlem m6 = new Medlem("Thea");
		m6.leggTilHobby("Fotball");
		m6.leggTilHobby("Fest");
		
		System.out.println("NAVN m1: " + m1.getNavn());
		m1.setNavn("Ernito");
		System.out.println("NAVN m1 etter oppdatering: " + m1.getNavn());
		System.out.println();
		
		System.out.println("HOBBYER m1: " + m1.getHobbyer().toString());
		MengdeADT<Hobby> h1 = new TabellMengde<Hobby>();
		h1.leggTil(new Hobby("TV"));
		m1.setHobbyer(h1);
		System.out.println("HOBBYER m1 etter oppdatering: " + m1.getHobbyer());
		System.out.println();
		
		
		System.out.println("STATUSINDEKS m1: " + m1.getStatusIndeks());
		m1.setStatusIndeks(2);
		System.out.println("STATUSINDEKS m1 etter oppdatering: " + m1.getStatusIndeks());
		System.out.println();
		
		System.out.println("m1 og m2 passer? " + m1.passerTil(m2));
		System.out.println("m3 og m4 passer? " + m3.passerTil(m4));
		System.out.println();
		System.out.println("HOBBY m5: " + m5.getHobbyer().toString());
		System.out.println("HOBBY m6: " + m6.getHobbyer().toString());
		System.out.println("UNION m5 + m6: " + m5.unionHobby(m6).toString());
		System.out.println("SNITT m5 + m6: " + m5.snittHobby(m6).toString());
		System.out.println("DIFF m5 + m6: " + m5.differensHobby(m6).toString());
		
		System.out.println("----");
		m4.printMedlem();
	}

}

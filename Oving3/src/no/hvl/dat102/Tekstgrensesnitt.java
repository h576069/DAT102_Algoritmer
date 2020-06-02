package no.hvl.dat102;

import java.util.Scanner;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.tabell.*;

public class Tekstgrensesnitt {
	// Klasse for inn/ut terminal
	// Oppretter scanner:
	private static Scanner sc = new Scanner(System.in);

	// Leser opplysningene om et medlem fra tastatur:
	public static Medlem lesMedlem() {
		System.out.println("Oppgi informasjon om medlem");
		System.out.println("Navn: ");
		String navn = sc.nextLine();

		System.out.println("Oppgi hobbyer til medlemmet, zzz for å avslutte:");
		MengdeADT<Hobby> hobbyer = new TabellMengde<Hobby>();
		String hobby = sc.nextLine();
		while (!hobby.equals("zzz")) {
			System.out.println("Oppgi hobbyer til medlemmet, zzz for å avslutte:");
			hobbyer.leggTil(new Hobby(hobby));
			hobby = sc.nextLine();
		}

		Medlem m = new Medlem(navn);
		m.setHobbyer(hobbyer);
		return m;
	}

	// Skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {
		// Oppdaterer alle par:
		arkiv.kobleAllePar();
		// Henter ut indeksene til alle parene:
		int[] indekser = arkiv.finnAllePar();
		Medlem[] medlemmer = arkiv.getMedlemstabell();

		System.out.println("PARNAVN\t\t\tHOBBYER");
		for (int i = 0; i < indekser.length; i += 2) {
			System.out.println(medlemmer[i].getNavn() + " og " + medlemmer[i + 1].getNavn() + "\t\t"
					+ medlemmer[i].getHobbyer().toString());
		}
		System.out.println();
		System.out.println("Antall par funnet: " + (indekser.length/2));
	}
	
	public void close() {
		sc.close();
	}
}

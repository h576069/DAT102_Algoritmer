package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import java.util.Scanner;
import java.lang.Integer;

public class Meny2 {
	// Objektvariabler:
	private Tekstgrensesnitt tekstgr;
	private FilmArkivADT filma;
	private Scanner sc = new Scanner(System.in);

	// Konstruktør
	public Meny2(FilmArkivADT filma) {
		this.tekstgr = new Tekstgrensesnitt();
		this.filma = filma;
	}

	// Start metoden:
	public void start() {
		// Spør brukeren om de vil opprette nytt arkiv eller bruke et eksisterende:
		System.out.println("Vil du bruke et eksisterende arkiv?");
		String svar = sc.nextLine(); // readLine();// sc.nextLine();

		if (svar.toUpperCase().equals("JA")) {
			System.out.println("Hva er filnavnet?");
			this.filma = Fil.lesFraFil(sc.nextLine());
		} else {
			this.filma = new FilmArkiv2();
		}
		action();

	}

	// Slutt metoden:
	public void slutt() {
		// Lagrer arkivet til en fil:
		System.out.println("Hvilken fil skal det lagres til?");
		Fil.skrivTilFil(this.filma, sc.nextLine());
		sc.close();

	}

	private void printmenu() {
		System.out.println("Hva vil du gjøre? (Skriv inn tallet)");
		System.out.println("1: Legge til en film");
		System.out.println("2: Slette en film");
		System.out.println("3: Se oversikt over alle filmene");
		System.out.println("4: Se informasjon om en film");
		System.out.println("5: Finn filmer ut fra tittel");
		System.out.println("6: Finn filmer ut fra produsent");
		System.out.println("7: Se statistikk");
		System.out.println("8: Avslutt");
	}

	// Handling:
	public void action() {
		boolean run = true;
		while (run) {
			// printer ut alternativene:
			printmenu();
			int val = Integer.parseInt(sc.nextLine());

			// Utfører de ulike alternativene:
			switch (val) {
			case 1:
				// Legge til en film:
				this.filma.leggTilFilm(this.tekstgr.lesFilm());
				break;
			case 2:
				// Slette en film:
				System.out.println("Skriv inn filmnummeret på filmen du vil slette:");
				this.filma.slettFilm(Integer.parseInt(sc.nextLine()));
				break;
			case 3:
				// Oversikt over alle filmene:
				this.tekstgr.visAlleFilmer(this.filma);
				break;
			case 4:
				// Se informasjon om en film:
				System.out.println("Skriv inn filmnummeret på filmen du er interessert i:");
				this.tekstgr.visFilm(this.filma.finnFilmMedNummer(Integer.parseInt(sc.nextLine())));
				
				break;
			case 5:
				// Filmer ut fra tittel:
				System.out.println("Skriv inn tittelen/deler av tittelen");
				this.tekstgr.skrivUtFilmDelstrengITittel(this.filma, sc.nextLine());
				break;
			case 6:
				// Filmer ut fra produsent:
				System.out.println("Skriv inn produsent/deler av navnet");
				this.tekstgr.skrivUtFilmProdusent(this.filma, sc.nextLine());
				break;
			case 7:
				// Statistikk:
				this.tekstgr.skrivUtStatistikk(this.filma);
				break;
			case 8:
				// Avslutt:
				run = false;
				break;
			default:
				System.out.println("Ikke et mulig valg");
				run = false;
			}
		}
	}
	

}

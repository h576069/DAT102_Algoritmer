package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.*;
import java.lang.Integer;

public class Tekstgrensesnitt {
	private Scanner sc = new Scanner(System.in);

	// Leser opplysninger om en film fra tastaturet
	public Film lesFilm() {
		// Opplysningene vi trenger er:

		// Skriv inn filmnummeret:
		System.out.println("Hva er filmnummeret?");
		int filmnummer = sc.nextInt();
		sc.nextLine();

		// Skriv inn produsenten:
		System.out.println("Hvem er produsent?");
		String produsent = sc.nextLine();

		// Skriv inn tittel:
		System.out.println("Hva er tittelen?");
		String tittel = sc.nextLine();

		// Skriv inn året:
		System.out.println("Hvilket år er filmen fra?");
		int aar = sc.nextInt();
		sc.nextLine();

		// Skriv inn sjanger:
		System.out.println("Hva er sjangeren?");
		Sjanger sjanger = Sjanger.finnSjanger(sc.nextLine());

		// Skriv inn selskapet:
		System.out.println("Hvilket selskap?");
		String selskap = sc.nextLine();

		// Opprett film objektet:
		return new Film(filmnummer, produsent, tittel, aar, sjanger, selskap);
	}

	// Vise en film sine opplysninger på skjermen
	public void visFilm(Film film) {
		if (film != null) {
			System.out.printf("%-12s", "Filmnummer:");
			System.out.printf("%20s%n", film.getNr());
			System.out.printf("%-12s", "Produsent:");
			System.out.printf("%20s%n", film.getProdusent());
			System.out.printf("%-12s", "Tittel:");
			System.out.printf("%20s%n", film.getTittel());
			System.out.printf("%-12s", "År:");
			System.out.printf("%20s%n", film.getAar());
			System.out.printf("%-12s", "Sjanger:");
			System.out.printf("%20s%n", film.getSjanger());
			System.out.printf("%-12s", "Selskap:");
			System.out.printf("%20s%n", film.getSelskap());
			System.out.println();
		}
	}

	// Skrive ut alle filmene med en delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmArkivADT filma, String delstreng) {
		// Finner filmene med delstrengen i tittelen
		Film[] filmer = filma.sokTittel(delstreng);
		if (filmer != null) {
			// Looper over filmene for å skrive de ut
			for (Film f : filmer) {
				visFilm(f);
				System.out.println();
			}
		}
	}

	// Skriv alle filmer av en produsent
	public void skrivUtFilmProdusent(FilmArkivADT filma, String delstreng) {
		// Henter ut filmene:
		Film[] filmer = filma.sokProdusent(delstreng);

		if (filmer != null) {
			// Skriver ut filmene:
			for (Film f : filmer) {
				visFilm(f);
				System.out.println();
			}
		}
	}

	// Skriv ut enkel statistikk
	public void skrivUtStatistikk(FilmArkivADT filma) {
		// Antall filmer:
		System.out.println(String.format("Antall: %5s", filma.getAntall()));
		System.out.println("------------");

		// Looper over sjangrene:
		for (Sjanger sj : Sjanger.values()) {
			System.out.printf("%-10s", sj);
			System.out.printf("%3s%n", filma.antallSjanger(sj));
		}

	}

	// Skriv ut alle filmene:
	public void visAlleFilmer(FilmArkivADT filma) {
		Film[] tab = filma.hentFilmTabell();
		String[] formats = { "%5s", "%40s", "%20s", "%6s", "%9s", "%25s" };
		String skille = " | ";
		String[] kolonnen = { "Nr.", "Tittel", "Produsent", "År", "Sjanger", "Selskap" };

		// Kolonne overskriften:
		for (int i = 0; i < formats.length; i++) {
			System.out.printf(formats[i], kolonnen[i]);
			System.out.print(skille);
		}
		System.out.println();
		String linje = "-";
		for (int x = 0; x < 120; x++) {
			linje += "-";
		}
		System.out.println(linje);

		// Innholdet:
		for (int j = 0; j < filma.getAntall(); j++) {
			for (int k = 0; k < formats.length; k++) {
				if (k == 0) {
					System.out.printf(formats[k], tab[j].getNr());
				} else if (k == 1) {
					System.out.printf(formats[k], tab[j].getTittel());
				} else if (k == 2) {
					System.out.printf(formats[k], tab[j].getProdusent());
				} else if (k == 3) {
					System.out.printf(formats[k], tab[j].getAar());
				} else if (k == 4) {
					System.out.printf(formats[k], tab[j].getSjanger());
				} else if (k == 5) {
					System.out.printf(formats[k], tab[j].getSelskap());
				}
				System.out.print(skille);
			}
			System.out.println();
		}
		System.out.println(linje);
	}
}

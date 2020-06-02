package no.hvl.dat102;

public class Butikk {
	// f) Objektvariabler:
	private Vare[] varer;
	private int antallTyper;
	private String navn;

	// g) Konstruktør
	public Butikk(String navn, int maksAntall) {
		this.varer = new Vare[maksAntall];
		this.navn = navn;
		this.antallTyper = 0;
	}

	// h) Metoden finnVare
	public int finnVare(int varenr) {
		int indeks = -1;

		for (int i = 0; i < this.antallTyper; i++) {
			if (this.varer[i].getVarenummer() == varenr) {
				return i;
			}
		}

		return indeks;
	}

	// i) Metoden erLedigPlass
	public boolean erLedigPlass() {
		return (this.antallTyper < this.varer.length);
	}

	// j) Metoden leggInnNyVare
	public void leggInnNyVare(int varenr, String navn, double pris, int antall) {
		// Antar at tabellen er sortert ellers
		// Oppretter variabel for den ønskede plasseringen:
		int indeks = this.antallTyper;

		// Sjekker at lageret ikke er fullt, og at varen ikke eksisterer fra før:
		if (erLedigPlass() && (finnVare(varenr) < 0)) {
			// Sjekker først om tabellen er tom:
			if (this.varer[0] == null) {
				indeks = 0;
			} else {
				// Finner indeksen hvor varen skal settes inn:
				for (int i = 0; i < this.antallTyper; i++) {
					if (varenr < this.varer[i].getVarenummer()) {
						indeks = i;
						break;
					}
				}
				// Flytter alle de andre varene ett hakk bort:
				for (int j = this.antallTyper + 1; j > indeks; j--) {
					this.varer[j] = this.varer[j - 1];
				}
			}

			// Setter inn det nye elementet:
			this.varer[indeks] = new Vare(varenr, navn, pris, antall);
			this.antallTyper++;

		} else {
			if (!erLedigPlass()) {
				System.out.println("Lageret er fullt!");
			} else {
				System.out.println("Varen eksisterer allerede!");
			}
		}
	}

	// k) Metoden slettVare
	public void slettVare(int varenr) {
		// Finn plasseringen til varen:
		int indeks = finnVare(varenr);
		if (indeks < 0) {
			System.out.println("Varen finnes ikke!");
		} else {
			for (int i = indeks; i < this.antallTyper; i++) {
				this.varer[i] = this.varer[i + 1];
			}
			this.antallTyper--;
		}
	}

	// l) Metoden detaljSalg
	public void detaljSalg(int varenr) {
		// Ser om vi finner varen:
		int indeks = finnVare(varenr);
		if (indeks < 0) {
			System.out.println("Varen finnes ikke!");
		} else {
			if (this.varer[indeks].getAntall() == 0) {
				System.out.println("0 varer igjen");
			} else {
				this.varer[indeks].setAntall(this.varer[indeks].getAntall() - 1);
			}
		}
	}

	// m) Metoden grossInnkjop
	public void grossInnkjop(int varenr, int ant) {
		// Finner varen:
		int indeks = finnVare(varenr);
		if (indeks < 0) {
			System.out.println("Varen finnes ikke!");
		} else if (ant <= 0) {
			System.out.println("Kan ikke bruke negativt antall");
		} else {
			// this.antallTyper[indeks] = this.antallTyper[indeks] + ant;
			this.varer[indeks].setAntall(this.varer[indeks].getAntall() + ant);
		}
	}

	// n) Metoden salgsVerdi()
	public double salgsVerdi() {
		double verdi = 0;
		for (int i = 0; i < this.antallTyper; i++) {
			verdi += (this.varer[i].getPris() * this.varer[i].getAntall());
		}
		return verdi;
	}

	// o) Metoden skrivUtVarer()
	public void skrivUtVarer() {
		System.out.println(this.navn);
		for (int i = 0; i < this.antallTyper; i++) {
			System.out.println(this.varer[i].toString());
		}
	}

}

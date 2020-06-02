package no.hvl.dat102;

public class Main {
	public static void main(String[] args) {
		// 1a)
//		stjerne(5);

		// 1b)
//		System.out.println(palindrom("abba"));
//		System.out.println(palindrom("abab"));
//		System.out.println(palindrom("abcdcba"));

		// 2a)
//		int[] t = {7, 2, 4, 3, 5};//{ 5, 6, 8, 2, 4, 1, 99 };
//		System.out.println(finnMinste(t));

		// 2b)
//		System.out.println(finnMinste2(t));

		// 3a)
//		double an = 3 * 3 * 3 * 3.0;
//		System.out.println(an);
//		System.out.println(potens(3.0, 4));

		// 3b)
//		int an2 = 3 * 3 * 3 * 3 * 3; // a = 3, n = 5 --> a^5 = a^(5/2) * a^(5/2)
//		System.out.println(an2);
//		System.out.println(potens2(3, 5));

		// 4a)
		System.out.println(433494437); // Dette er egentlig tall nr 43 i fibbo
		System.out.println(fibbonacci(42)); // bruker 0 indeksing i min kode

		// 4c)
		System.out.println(fibbonacci2(42));
	}

	/*
	 * 4c)
	 * 
	 * Skriv en iterativ metode public static int fibbonacci2 (int n){...} som
	 * finner Fn.
	 */
	public static int fibbonacci2(int n) {
//		int nestSiste = 1;
//		int siste = 1;
//		for (int i = 3; i <= n; i++) {
//			int neste = siste + nestSiste;
//			nestSiste = siste;
//			siste = neste;
//		}
//		return siste;
		if (n < 2) { // < 3 for å starte på indeks 1
			return 1;
		} else {
			int fn_2 = 1;
			int fn_1 = 1;
			int fn = fn_2 + fn_1;
			for (int i = 2; i < n; i++) {
				fn_2 = fn_1;
				fn_1 = fn;
				fn = fn_2 + fn_1;
			}
			return fn;
		}
	}

	/*
	 * 4a)
	 * 
	 * Rekursiv metode for å finne fibbonacci tall nr n, hvor vi starter på 0.
	 */
	public static int fibbonacci(int n) {
		if (n < 2) { // endre til < 3 for å starte indeksen på 1
			return 1;
		}
		return (fibbonacci(n - 1) + fibbonacci(n - 2));

	}

	/*
	 * 3b) Rekursiv metode som finner verdien a_n basert på formelen a_n = a_n/2 *
	 * a^(n / 2) når n er partall > 0 og a_n = a * a^(n / 2) * a^(n / 2) når n er
	 * oddetall > 0 og a_0 = 1.0.
	 */
	public static double potens2(double a, int n) {
		if (n == 0) {
			return 1.0;
		}
		double tall = potens2(a, n / 2);

		if (n % 2 == 0) { // Partall
			return tall * tall;
		} else {
			return a * tall * tall;
		}
	}

	/*
	 * 3a) Rekursiv metode som finner verdien a_n basert på a_n = a * a_(n - 1) når
	 * n > 0 og a_0 = 1.0
	 */
	public static double potens(double a, int n) {
		if (n == 0) {
			return 1.0;
		} else {
			return a * (potens(a, n - 1));
		}
	}

	/*
	 * 2b) Metode som bruker en rekursiv hjelpemetode for å finne og returnere det
	 * minste elementet i tab.
	 * 
	 */
	public static int finnMinste2(int[] tab) {
		return finnMinsteRek2(tab, 0, tab.length - 1);
	}

	public static int finnMinsteRek2(int[] tab, int forste, int siste) {
		if (forste < siste) { // minst to elementer
			// midtpunktet
			int midt = (forste + siste) / 2;

			int minstV = finnMinsteRek2(tab, forste, midt);
			int minstH = finnMinsteRek2(tab, midt + 1, siste);

			// Bestemmer hvilken av de som skal returneres
			if (minstV < minstH) {
				return minstV;
			} else {
				return minstH;
			}
		}
		return tab[forste];
	}

	/*
	 * 2a)
	 * 
	 * Metode som ved hjelp av en rekursiv hjelpemetode finner og returnerer det
	 * minste elementet i tab.
	 * 
	 */
	public static int finnMinste(int[] tab) {
		return finnMinsteRek(tab, 0, tab.length - 1);
	}

	public static int finnMinsteRek(int[] tab, int forste, int siste) {
		if (forste < siste) { // minst 2 elementer
			// Basere seg på å sammenligne første elementet i tabellen
			// med minste elementet i resten av tabellen
			int minsteResten = finnMinsteRek(tab, forste + 1, siste);
			if (tab[forste] < minsteResten) {
				return tab[forste];
			} else {
				return minsteResten;
			}
		}

		return tab[forste];

	}

	/*
	 * 1b) Rekursiv metode som bestemmer om et ord er et palindrom (altså staves
	 * likt begge veier)
	 */
	public static boolean palindrom(String ord) {
		int lengde = ord.length();
		if (lengde > 1) {
			if (ord.charAt(0) == ord.charAt(lengde - 1)) {
				return palindrom(ord.substring(1, lengde - 1));
			} else {
				return false;
			}
		}
		return true; // Da har vi kun et tegn igjen og er da true
	}

	/*
	 * 1 a) Test for stjerne(3) og stjerne(5)
	 */
	public static void stjerne(int n) {
		if (n > 1) {
			stjerne(n / 2);
			stjerne(n / 2);
		}
		for (int i = 1; i <= n; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}

package no.hvl.dat102;

public class Main {
	
	/*
	 * 1)
	 * Rekursiv metode som skriver ut positivt heltall baklengs
	 * For å finne siste siffer i et tall kan du bruke %.
	 * For å kutte siste siffer i et tall kan du bruke heltallsdivisjon
	 */
	public static void snuTall(int tall) {
		if (tall < 10) { // basistilfelle:
			System.out.println(tall);;
		} else {
			System.out.print(tall%10);
			snuTall(tall/10);
		}
	}
	

	/*
	 * 2)
	 * Ved hjelp av en rekursiv metode snur en fylt tabell slik at
	 * det første elementet kommer sist, det andre nest sist osv.
	 */
	public static void snuTabell(int[] tab) {
		int forste = 0;
		int siste  = tab.length-1;
		snuTabellRek(tab, forste, siste);
	}
	public static void snuTabellRek(int[] tab, int f, int s) {
		if (f < s) { // minst to elementer
			int temp = tab[f];
			tab[f] = tab[s];
			tab[s] = temp;
			snuTabellRek(tab, f+1, s-1);
		} // Else er basis
	}
	
	/*
	 * 3a)
	 * Rekursiv metode som beregner kvadratsummen av heltallene
	 * mellom m og n inkludert ved å summere forlengs
	 */
	public static int sumKvadOpp(int m, int n) {
		// Hvis m = 3 og n = 5 så skal vi returnere 3^2 + 4^2 + 5^2
		// Antar at m <= n
		
		// basistilfellet er m = n
		if (m == n) {
			return (m*m);
		} else {
			return ((m*m) + sumKvadOpp(m+1, n));
		}
	}

	/*
	 * 3b)
	 * Rekursiv metode som beregner kvadratsummen av heltallene
	 * mellom m og n inkludert ved å summere baklengs
	 */
	public static int sumKvadNed(int m, int n) {
		if (m == n) {
			return n * n;
		} else {
			return ((n*n) + sumKvadNed(m, n-1));
		}
	}
	
	

	public static void main(String[] args) {
		//1)
//		snuTall(1993);
//		snuTall(2001);
		
		//2)
//		int[] tab = {1, 9, 9, 3};
//		System.out.print("[ ");
//		for (int t : tab) {
//			System.out.print(t + " ");
//		}
//		System.out.println("]");
//		snuTabell(tab);
//		System.out.print("[ ");
//		for (int t : tab) {
//			System.out.print(t + " ");
//		}
//		System.out.println("]");
		
		//3a)
//		int i = (3*3) + (4*4) + (5*5);
//		System.out.println(i);
//		System.out.println(sumKvadOpp(3, 5));
		
		//3b)
//		int i = (5*5) + (4*4) + (3*3);
//		System.out.println(i);
//		System.out.println(sumKvadNed(3, 5));
		
		//4a)
		KjedetListe<Integer> kl = new KjedetListe<Integer>();
		kl.leggTil(1);
		kl.leggTil(9);
		kl.leggTil(9);
		kl.leggTil(3);
//		System.out.println(kl.lengde(kl.getFoerste()));
		
		// 4b)
//		kl.skrivBaklengs();
		
		//4c)
//		System.out.println(kl.toString2());
	}

}

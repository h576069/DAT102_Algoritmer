package no.hvl.dat102.klient;

import no.hvl.dat102.TabellHaug;

public class KlientHaug {

	public static void main(String[] args) {
		// Tester haugen ved å sortere verdier i en tabell
		// ikke-avtagende --> øking
		int tab[] = { 300, 10, 30, 2, 100, 33, 1, 200, 18, 54 };
		TabellHaug<Integer> h1 = new TabellHaug<Integer>();
		
		for (int i = 0; i < tab.length; i++) {
			h1.leggTilElement((tab[i]));
		}
		
		System.out.println("Verdiene i tabellen er nå:");
		h1.skrivTab();
		// Tar ut av haugen og skriver i sortert ikke-avtagende
		System.out.println("\nHaugen i sortert rekkefølge:");
		while (!h1.erTom()) {
			Integer h = (Integer) h1.fjernMinste();
			System.out.print(h + " ");
		}
		System.out.println();
		
	}

}

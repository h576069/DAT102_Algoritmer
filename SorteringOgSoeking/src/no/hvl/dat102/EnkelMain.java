package no.hvl.dat102;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class EnkelMain {

	public static void main(String[] args) {
//		Random tilf = new Random(42);
		SorteringOgSoeking sos = new SorteringOgSoeking();
		Integer[] tab = {4, 1, 7, 3, 2};
		System.out.print("{ " + tab[0]);
		for (int i = 1; i < tab.length; i++) {
			System.out.print(", " + tab[i]);
		}
		System.out.println("}");
		sos.kvikkSort(tab, 0, tab.length-1);
		System.out.print("{ " + tab[0]);
		for (int i = 1; i < tab.length; i++) {
			System.out.print(", " + tab[i]);
		}
		System.out.println("}");
		
//
//		// Antall elementer i tabellen:
//		int n = 128000; // 32000, 64000, 128000
//
//		// For å finne gjennomsnittet:
//		long sum = 0;
//		// Antall målinger:
//		int m = 10;
//		
//		// Oppretter tabellen:
//		Integer[][] tab1 = lagTilfeldigTabell(n, m);
//		
////		Integer[] tab1 = lagTilfeldigTabell(n);
////		printTab(tab1);
//		for (int i = 0; i < m; i++) {
//			// Lager tabellen:
//			
//			// Starter tiden:
//			Instant start = Instant.now();
//			// Sorterer:
////			sos.sorteringVedInnsetting(tab1[i]);
//			sos.sorteringVedInnsettingBin(tab1[i]);
////			sos.utvalgsSortering(tab1[i]);
////			sos.bobleSort(tab1[i]);
////			sos.kvikkSort(tab1[i], 0, tab1[i].length-1);
////			sos.fletteSort(tab1[i], 0, tab1[i].length-1);
////			sos.radixSort(tab1[i], 9, String.valueOf(n*2).length());
//
//			/* d) */
////			sos.kvikkSortNy(tab1[i], 0, tab1[i].length-1);
//
//			// Slutter tiden:
//			Instant finish = Instant.now();
//			// Beregner tiden:
//			long timeElapsed = Duration.between(start, finish).toMillis();
//			sum += timeElapsed;
//		}
//		System.out.println(n + " elementer: ");
//		System.out.println("For " + m + " målinger ble tiden i gjennomsnitt " + (sum / m) + " ms");
//		
////		Integer[] tab1 = lagTilfeldigTabell(10);
////		printTab(tab1);
////		sos.radixSort(tab1, 9, 2);
////		printTab(tab1);
////		Integer[] tab1 = {7, 1, 3, 6, 5, 4, 2};
////		printTab(tab1);
////		sos.sorteringVedInnsettingBin(tab1);
////		printTab(tab1);

	}

	private static Integer[][] lagTilfeldigTabell(int n, int m) {
		Random tilf = new Random(42);
		// Oppretter tom tabell:
		Integer[][] tab = new Integer[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				tab[i][j] = tilf.nextInt(2 * n);
			}
		}

		return tab;
	}

	private static void printTab(Integer[] tab) {
		System.out.print("{ " + tab[0]);
		for (int i = 1; i < tab.length; i++) {
			System.out.print(", " + tab[i]);
		}
		System.out.print(" }\n");
	}

}

package no.hvl.dat102;

public class Sortering {

	// Public metoden først:
	/*
	 * Sjekk bok/notater for hvordan den ser ut ved generisk type
	 */
	public static void kvikkSort(int[] tab) {
		/*
		 * De som bruker metoden trenger kun forholde seg til denne metoden og slipper
		 * da å tenke på indeksene
		 */
		// Denne skal kalle på en privat hjelpemetode med samme navn, men ulik
		// parameterliste
		kvikkSort(tab, 0, tab.length - 1);
	}

	private static void kvikkSort(int[] tab, int min, int maks) {
		// Sjekker først basistilfellet --> Har vi ingen/ett element er det ingenting å
		// gjøre

		// Alt 1: if (min >= maks) --> Dette blir da basistilfellet, da har vi 0 eller 1
		// element og vi gjør ingenting
		// må da utføre alt i else blokken

		// Alt 2:
		if (min < maks) { // Representerer enda basistilfellet, men vi slipper å bruke else. Har da minst
							// to element
			int delePunkt = finnPartisjon(tab, min, maks);

			// Venstre del:
			kvikkSort(tab, min, delePunkt - 1);

			// Høyre del:
			kvikkSort(tab, delePunkt + 1, maks);

		} // Else basistilfellet --> Gjør ingenting
	}

	private static int finnPartisjon(int[] tab, int min, int maks) {
		// Bruker midterste som pivot
		int midten = (min + maks) / 2;

		// Enklere å bruke, isteden for tab[..] hele veien
		// Elementet vi vil sammenligne med
		int pivot = tab[midten];

		// Bytter det som står i midten med det som står først:
		swap(tab, min, midten);

		// Nå skal vi bestemme om elementene er større eller mindre enn pivot
		// Også bytte plass på de.
		int venstre = min;
		int hoyre = maks;

		// Leite helt til disse to krysser hverandre
		while (venstre < hoyre) { // Ytre løkken
			while (venstre < hoyre && tab[venstre] <= pivot) { // ved generisk type bruker vi compareTo
				venstre++;
			}

			// Starter å lete fra andre kanten:
			while (tab[hoyre] > pivot) {
				hoyre--;
			}

			// Bytter de to:
			// Har da funnet en stor på venstre side og en liten på høyre side
			if (venstre < hoyre) {
				swap(tab, venstre, hoyre);
			}
		}

		// Vil bytte om pivot med den siste minste, siden vi bruker hoyre til å lete etter
		// de små vil da høyre representere denne plassen
		swap(tab, min, hoyre);
		
		// Vil også returnere dette:
		return hoyre;
	}

	private static void swap(int[] tab, int i, int j) {
		// Bytter om plassen på to elementer
		int temp = tab[i];
		tab[i] = tab[j];
		tab[j] = temp;
	}

	public static void main(String[] args) {
		int[] data = {7, 1, 9, 3, 2, 10, 11, 17, 0};
		kvikkSort(data);
		
		for (int d : data) {
			System.out.print(d + " ");
		}
		System.out.println();
		
	}

}

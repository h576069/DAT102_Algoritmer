package no.hvl.dat102;

import java.util.Arrays;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.tabell.TabellKoe;

public class SorteringOgSoeking {
	// Klasse med ulike søke- og sorteringsmetoder

	private static final int MIN = 200;
	/*
	 * Søkealgoritmer
	 */

	/**
	 * Metoden gjør et lineært søk i en tabell av usorterte data
	 * 
	 * @param data er data som skal søkes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   er verdien vi søker etter
	 * @return sann om elementet ble funnet, ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSoekU(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks <= maks && !funnet) {
			if (data[indeks].compareTo(el) == 0)
				funnet = true;

			indeks++;
		}
		return funnet;
	}

	/**
	 * Metoden gjør et lineært søk i en sortert tabell av data
	 * 
	 * @param data er data som skal søkes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   verdien vi søker etter
	 * @return sann hvis funnet, ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSoekS(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks < maks && data[indeks].compareTo(el) < 0) {
			indeks++;
		}

		if (data[indeks].compareTo(el) == 0) {
			funnet = true;
		}

		return funnet;
	}

	/**
	 * Metoden gjør et binært søk i en sortert tabell av data
	 * 
	 * @param data er data som skal søkes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   er elementet vi søker etter
	 * @return sann om elementet ble funnet, ellers usann
	 */
	// Alt 1
	public static <T extends Comparable<T>> boolean binaerSoek(T[] data, int min, int maks, T el) {
		if (min > maks) { // basistilfelle, ingen element
			return false;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		if (resultat == 0) {
			return true;
		}

		if (resultat < 0) {
			return binaerSoek(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}
	}

	// Alt 2
	public static <T extends Comparable<T>> boolean binaerSoek2(T[] data, int min, int maks, T el) {
		boolean funnet;
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		if (min > maks) { // Basistilfelle, ingen element
			funnet = false;
		} else if (resultat == 0) { // Basistilfelle, funnet
			funnet = true;
		} else if (resultat < 0) {
			funnet = binaerSoek2(data, min, midtpunkt - 1, el);
		} else {
			funnet = binaerSoek2(data, midtpunkt + 1, maks, el);
		}

		return funnet;
	}

	// Alt 3 - Rekursiv binærsøk som returnerer indeks
	public static <T extends Comparable<T>> int binaerSoek3(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til målelementet hvis det fins, ellers -1
		if (min > maks) { // Basistilfelle, ingen element
			return -1;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) {
			return midtpunkt;
		} else if (resultat < 0) {
			return binaerSoek3(data, min, midtpunkt - 1, el);
		} else {
			return binaerSoek3(data, midtpunkt + 1, maks, el);
		}
	}

	// Alt 4 - Ikke rekursiv binærsøk som returnerer indeks
	public static <T extends Comparable<T>> int binaerSoek4(T[] data, int min, int maks, T el) {
		int midten = (min + maks) / 2;
		if (el.compareTo(data[midten]) == 0) {
			return midten;
		} else {
			int start = min;
			int slutt = maks;
			int ctRes = el.compareTo(data[midten]);

			while (ctRes != 0 && start < slutt) {
				if (ctRes < 0) { // venstre del:
					slutt = midten - 1;
				} else {
					start = midten + 1;
				}
				midten = (start + slutt) / 2;
				ctRes = el.compareTo(data[midten]);
			}

		}
		if (el.compareTo(data[midten]) == 0) {
			return midten;
		}
		return -1;
	}

	// Alt 5 - Rekursiv binærsøk som returnerer indeks eller insertion_point
	public static <T extends Comparable<T>> int binaerSoek5(T[] data, int min, int maks, T el) {
		if (maks <= min) {
			if (el.compareTo(data[min]) > 0) {
				return min + 1;
			} else {
				return min;
			}
		}

		int midtpunkt = (min + maks) / 2;

		int resultat = el.compareTo(data[midtpunkt]);

		if (resultat == 0) {
			return midtpunkt + 1;
		} else if (resultat < 0) {
			return binaerSoek5(data, min, midtpunkt - 1, el);
		} else {
			return binaerSoek5(data, midtpunkt + 1, maks, el);
		}
	}

	/*
	 * Sorteringsalgoritmer
	 */

	/**
	 * Utvalgssortering
	 * 
	 * @param data er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgsSortering(T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
				}
			}

			/* Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		}
	}

	/**
	 * Sortering ved innsetting
	 * 
	 * @param data er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void sorteringVedInnsetting(T[] data) {
		for (int indeks = 1; indeks < data.length; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;

			// Forskyv større verdier mot høyre
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = nokkel;
		}
	}

	public static <T extends Comparable<T>> void sorteringVedInnsettingBin(T[] data) {
		for (int i = 1; i < data.length; i++) {
			// Det neste elementet som skal sorteres
			T nokkel = data[i];

			// Må bruke en spesiell binærsøk som ikke bare returnerer -1 hvis elementet ikke
			// fins, men faktisk posisjonen hvor det bør settes inn i forhold til resten av
			// tabellen
			
			// Leter etter posisjonen i den sorterte delen av tabellen (opp til i)
			int p = binaerSoek5(data, 0, i, nokkel);
			
			// Flytter de andre:
			for (int j = i; j > p; j--) {
				data[j] = data[j-1];
			}

			data[p] = nokkel;
		}


		/* skal endre hvordan man finner p, bruke binærsøk her */

		/*
		 * Setter inn første elementet i den usorterte delen inn i den sorterte delen
		 * Sett det først inn bakerst Når vi setter inn neste flytter vi den minste av
		 * de først ved å bytte med naboelementer
		 */

		// Forskyv større verdier mot høyre
//			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
//				data[p] = data[p - 1];
//				p--;
//			}
//			data[p] = nokkel;
//		}
//		data = sortert;
	}

	/**
	 * Boblesortering
	 * 
	 * @param data er tabellen som skal sorteres
	 */
	public static <T extends Comparable<T>> void bobleSort(T[] data) {
		int p, sok;
		T temp;
		for (p = data.length - 1; p >= 0; p--) {
			for (sok = 0; sok <= p - 1; sok++) {
				if (data[sok].compareTo(data[sok + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
				}
			}
		}
	}

	public static <T extends Comparable<T>> void bobleSortFlagg(T[] data) {
		/*
		 * Sjekker om det har vært ombyttinger i nåværende gjennomløp. Dersom ingen
		 * ombyttinger så avbrytes prosessen.
		 */
		T temp = null;
		int fase = 1;
		boolean byttet = false;
		do {
			byttet = false;
			for (int i = 0; i < data.length - fase; i++) {
				if (data[i].compareTo(data[i + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					byttet = true;
				}
			}
			fase++;
		} while (byttet);
	}

	/**
	 * Kvikksort sortering
	 * 
	 * @param data er dataene vi skal sortere
	 * @param min  er startindeksen
	 * @param maks er sluttindeksen
	 */
	public static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {
		
		int posPartisjon;
		if (min < maks) { // minst to elementer
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);

			/** Sorterer venstre side */
			kvikkSort(data, min, posPartisjon - 1);
			/** Sorterer høyre side */
			kvikkSort(data, posPartisjon + 1, maks);
		}
	}

	private static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
		int venstre, hoyre;
		T temp, pivot;

		// Pivot som første element:
		pivot = data[min];
		venstre = min;
		hoyre = maks;

		while (venstre < hoyre) {
			/** Søker et element som er større enn privot */
			/** Sikrer at partisjonsprosessen vil fortsette så lenge venstre < hoyre */
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}

			/** Søker et element som er <= enn privot */
			while (data[hoyre].compareTo(pivot) > 0) {
				hoyre--;
			}

			/** Bytter elementene */
			if (venstre < hoyre) {
				temp = data[venstre];
				data[venstre] = data[hoyre];
				data[hoyre] = temp;
			}
		}

		/** Flytter pivot til riktig og sin endelige plass */
		temp = data[min];
		data[min] = data[hoyre];
		data[hoyre] = temp;
		
		return hoyre;
	}

	/**
	 * Flette sortering / Merge sort
	 * 
	 * @param tabell tabellen som skal sorteres
	 * @param forste startindeks
	 * @param siste  sluttindeks
	 */
	public static <T extends Comparable<T>> void fletteSort(T[] tabell, int forste, int siste) {
		if (forste < siste) { // Minst to elementer
			int midten = (forste + siste) / 2;

			// Sorter venstre halvdel:
			fletteSort(tabell, forste, midten);

			// Sorter høyre halvdel
			fletteSort(tabell, midten + 1, siste);

			// Fletter de to halvdelene
			flette(tabell, forste, midten, siste);
		}
	}

	private static <T extends Comparable<T>> void flette(T[] tabell, int forste, int midten, int siste) {
		/*
		 * Fletter to sorterte deltabeller til en sortert tabell
		 * 
		 * Forkrav: forste <= midten <= siste
		 */
		int stor = siste - forste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[stor]);

		// Initierer lokale indekser

		// start og slutt på venstre deltabell:
		int forste1 = forste;
		int siste1 = midten;

		// start og slutt på høyre deltabell:
		int forste2 = midten + 1;
		int siste2 = siste;

		/*
		 * Så lenge begge deltabellene ikke er tomme, kopier det minste elementet til
		 * hjelpetabellen
		 */
		int indeks = 0;

		while ((forste1 <= siste1) && (forste2 <= siste2)) {
			if (tabell[forste1].compareTo(tabell[forste2]) <= 0) {
				hjelpeTabell[indeks] = tabell[forste1];
				forste1++;
			} else {
				hjelpeTabell[indeks] = tabell[forste2];
				forste2++;
			}
			indeks++;
		}

		// Kopiere resten av venstre del (kan være tom)
		while (forste1 <= siste1) {
			hjelpeTabell[indeks] = tabell[forste1];
			forste1++;
			indeks++;
		}

		// Kopiere resten av høyre del (kan være tom)
		while (forste2 <= siste2) {
			hjelpeTabell[indeks] = tabell[forste2];
			forste2++;
			indeks++;
		}

		// Koper resultatet tilbake til den originale tabellen
		int h = 0;
		for (indeks = forste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h];
			h++;
		}

	}

	public static <T extends Comparable<T>> void radixSort(Integer[] tabell, int antallKoer, int antallSiffer) {
		String temp;
		Integer tallObj;
		int siffer, tall;
		KoeADT<Integer>[] elKoer = new TabellKoe[tabell.length];

		// Oppretter alle køene:
		for (int i = 0; i <= antallKoer; i++) {
			elKoer[i] = new TabellKoe<Integer>();
		}

		/** Sorterer liste */

		for (int posisjon = 0; posisjon < antallSiffer; posisjon++) {
			for (int i = 0; i < tabell.length; i++) {
				temp = String.valueOf(tabell[i]);
				while (temp.length() < antallSiffer) {
					temp = "0" + temp;
				}
				siffer = Character.digit(temp.charAt(antallSiffer - 1 - posisjon), antallKoer + 1);
				elKoer[siffer].innKoe(tabell[i]);
			}

			/* Legger sorterte tall ut i liste */
			tall = 0;
			for (int sifferVerdi = 0; sifferVerdi <= antallKoer; sifferVerdi++) {
				while (!(elKoer[sifferVerdi].erTom())) {
					tallObj = elKoer[sifferVerdi].utKoe();
					tabell[tall] = tallObj.intValue();
					tall++;
				}
			}
		}
	}

	public static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks) {
		kvikkSort2(data, min, maks);
		sorteringVedInnsetting2(data, min, maks);
	}

	public static <T extends Comparable<T>> void kvikkSort2(T[] data, int min, int maks) {
		int posPartisjon;
		if (maks - min + 1 > MIN) { // Antall elementer > MIN?
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);

			/** Sorterer venstre side */
			kvikkSort(data, min, posPartisjon - 1);

			/** Sorterer høyre side */
			kvikkSort(data, posPartisjon + 1, maks);
		}
	}

	public static <T extends Comparable<T>> void sorteringVedInnsetting2(T[] data, int forste, int siste) {
		for (int indeks = forste + 1; indeks <= siste; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;

			// Forskyv større verdier mot høyre
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = nokkel;
		}
	}

}

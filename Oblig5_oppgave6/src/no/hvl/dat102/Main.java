package no.hvl.dat102;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
//		oppgave6c();
//		oppgave6d();
		oppgave6e();
	}
	

	private static void oppgave6c() {
		String s1 = "ab";
		String s2 = "123";

		System.out.println("HashCode for " + s1 + " : " + s1.hashCode());
		System.out.println("HashCode for " + s2 + ": " + s2.hashCode());
	}

	private static void oppgave6d() {
		Student a = new Student(10, "Ole");
		Student b = new Student(10, "Ole");

		System.out.println("LIKE? " + a.equals(b));
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());

	}

	private static void oppgave6e() {
		int n = 100000;

		// Oppretter tabellene:
		Integer[] tab = new Integer[n];
		Set<Integer> hash = new HashSet<>();

		// Setter inn tilfeldige verdier:
		int tall = 376;
		for (int i = 0; i < n; i++) {
			tab[i] = tall;
			hash.add(tall);

			// Oppdaterer tall:
			tall = (tall + 45713) % 1000000;
		}

		// Må sortere tabellen:
		Arrays.sort(tab);

		/*
		 * Skal søke etter 10.000 tilfeldige tall i området 0 ... 999999 og telle hvor
		 * mange ganger vi finner tallet vi leter etter.
		 * 
		 * Søker først etter alle tallene i HashSet og måler tiden, forså å gjøre det
		 * samme i tabellen ved binærsøk.
		 * 
		 */
		
		// Oppretter tabellen med de ti tusen tilfeldige tallene
		Random tilf = new Random();
		int[] tilfeldige = new int[10000];
		for (int i = 0; i < tilfeldige.length; i++) {
			tilfeldige[i] = tilf.nextInt(1000000);
		}
		
		// Søker i hashSet:
		int hcount = 0;
		long hstart = System.currentTimeMillis();
		for (int t : tilfeldige) {
			if (hash.contains(t)) {
				hcount++;
			}
		}
		long hfinish = System.currentTimeMillis();
		long htime = hfinish - hstart;
		
		// Søker i tabellen:
		int tcount = 0;
		long tstart = System.currentTimeMillis();
		for (int t : tilfeldige) {
			if (Arrays.binarySearch(tab, t) >= 0) {
				tcount++;
			}
		}
		long tfinish = System.currentTimeMillis();
		long ttime = tfinish - tstart;
		
		// Printer ut resultatene:
		System.out.println("HASH -- antall: " + hcount + ", tid: " + htime + " ms");
		System.out.println("TAB  -- antall: " + tcount + ", tid: " + ttime + " ms");
		
	}
}

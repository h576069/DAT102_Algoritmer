package no.hvl.dat102.klient;

import no.hvl.dat102.KjedetBSTre;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.Random;

public class KlientBSTre {
	private static final int ANTALL_TILFELDIGE_TRE = 100;
	private static final int ANTALL_NODER = 8192;//1024;
	private static Random tilf = new Random();
	
	public static void main(String[] args) {
		
		
//		oppgave2b();
//		oppgave2e();
		
//		KjedetBSTre<Integer> bstre = new KjedetBSTre<Integer>();

//		bstre.leggTil(7);
//		bstre.leggTil(5);
//		bstre.leggTil(6);
//		bstre.leggTil(4);
//		bstre.leggTil(9);
//		bstre.leggTil(10);
//		bstre.leggTil(8);
//		bstre.leggTil(3);
//		bstre.leggTil(11);
//		bstre.leggTil(12);
//		bstre.leggTil(4);
//		bstre.leggTil(3);
//		bstre.leggTil(5);
//		bstre.leggTil(2);
//		bstre.leggTil(6);
//		bstre.leggTil(1);
//		bstre.leggTil(7);
//		bstre.visInorden();
//		Iterator<Integer> it = bstre.iterator();
//		while (it.hasNext()) {
//			System.out.print(it.next() + " ");
//		}
		
		
		
//		
////		 Høyden:
//		System.out.println("HØYDE: " + bstre.finnHoyden());

//		// Tester på sortert utskrift
//		System.out.println("Skriver ut elementene sortert i bs-treet");
//		bstre.visInorden();
//
//		// Tester på om et bestemt element fins
//		int element = 8;
//		System.out.println("\nTester paa om elementet " + element + " fins");
//
//		if (bstre.finn(element) != null) {
//			System.out.println("Elementet " + element + " fins i bs-treet");
//		} else {
//			System.out.println("Elementet " + element + " fins ikke i bs-treet");
//		}
//
//		element = 1;
//		System.out.println("\nTester paa om elementet " + element + " fins");
//
//		if (bstre.finn(element) != null) {
//			System.out.println("Elementet " + element + " fins i bs-treet");
//		} else {
//			System.out.println("Elementet " + element + " fins ikke i bs-treet");
//		}

	}
	
	public static void oppgave2b() {
		tilf.setSeed(42);
		ArrayList<KjedetBSTre<Integer>> bstrer = new ArrayList<KjedetBSTre<Integer>>(ANTALL_TILFELDIGE_TRE);
		int[] hoyder = new int[ANTALL_TILFELDIGE_TRE];
		int minHoyde = ANTALL_NODER * 2;
		int maksHoyde = 0;
		int sumHoyde = 0;
		
		for (int i = 0; i < ANTALL_TILFELDIGE_TRE; i++) {
			KjedetBSTre<Integer> curr = new KjedetBSTre<Integer>();
			for (int j = 0; j < ANTALL_NODER; j++) {
				curr.leggTil(tilf.nextInt());
			}
			bstrer.add(curr);
			hoyder[i] = bstrer.get(i).finnHoyden();
			// Finner minste høyden:
			if (hoyder[i] < minHoyde)
				minHoyde = hoyder[i];
			
			// Finner største høyden:
			if (hoyder[i] > maksHoyde)
				maksHoyde = hoyder[i];
			
			// Finner summen av alle høydene:
			sumHoyde += hoyder[i];
		}
		
		System.out.println("i)   Antall noder:                             " + ANTALL_NODER);
		System.out.println("ii)  Minimal teoretisk høyde:                  " + Math.floor(Math.log(ANTALL_NODER)/Math.log(2)));
		System.out.println("iii) Maksimal teoretisk høyde:                 " + ANTALL_NODER);
		System.out.println("iv)  Minste høyde i løpet av kjøringene:       " + minHoyde);
		System.out.println("v)   Største høyde i løpet av kjøringene:      " + maksHoyde);
		System.out.println("vi)  Gjennomsnittlig høyde av alle kjøringene: " + (sumHoyde / ANTALL_TILFELDIGE_TRE));
		
	}

	public static void oppgave2e() {
		KjedetBSTre<Integer> bstre = new KjedetBSTre<Integer>();
		bstre.leggTil(7);
		bstre.leggTil(5);
		bstre.leggTil(6);
		bstre.leggTil(4);
		bstre.leggTil(9);
		bstre.leggTil(10);
		bstre.leggTil(8);
		bstre.leggTil(3);
		bstre.leggTil(11);
		bstre.leggTil(12);
		bstre.skrivVerdier(3, 12);
	}
}

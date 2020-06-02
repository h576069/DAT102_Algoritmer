package no.hvl.dat102.klient;

import no.hvl.dat102.kjedet.KjedetBSTre;
import no.hvl.dat102.kjedet.KjedetUordnetListe;
import no.hvl.dat102.noder.BinaerTreNode;
import no.hvl.dat102.tabell.TabellKoe;
import no.hvl.dat102.tabell.TabellStabel;

public class Oppgave1 {
	public static void main(String[] args) {
		oppgave5();
	}
	public static void oppgave5() {
		KjedetBSTre<Integer> bs = new KjedetBSTre<Integer>();
		bs.leggTil(8);
		bs.leggTil(6);
		bs.leggTil(10);
		bs.leggTil(4);
		bs.leggTil(7);
		bs.leggTil(9);
		bs.leggTil(11);
		
		//a: toString
		System.out.println(bs.toString());
		
		//b: verifiser
		System.out.println(bs.verifiserBSTre(bs));
	}
	
	
	public static void oppgave4() {
		KjedetUordnetListe<Character> kl1 = new KjedetUordnetListe<Character>();
		KjedetUordnetListe<Integer> kl2 = new KjedetUordnetListe<Integer>();
		
		// Setter inn i kl1:
		kl1.settInn('B');
		kl1.settInn('A');
		kl1.settInn('C');
		System.out.println("KL1: ");
		System.out.println(kl1.toString());
		kl1.flyttFoersteTilSiste();
		System.out.println("KL1 etter flytting:");
		System.out.println(kl1.toString());
		
		// Setter inn i kl2:
		kl2.settInn(8);
		kl2.settInn(5);
		kl2.settInn(4);
		kl2.settInn(6);
		kl2.settInn(2);
		kl2.settInn(9);
		System.out.println("KL2: ");
		System.out.println(kl2.toString());
		System.out.println("KL2 nest minste: " + kl2.finnNestMinste());
		kl2.flyttFoersteTilSiste();
		System.out.println("KL2 etter flytting:");
		System.out.println(kl2.toString());
		
		// a) toString
		// b) settInn
		// c) flyttFoersteTilSiste
		// d) finnNestMinste
	}

	public static void oppgave1e() {
		int[] d = {-1, -2, 7, 10, 14, 17, 20, 25, 30};
		binaerSoek(d, 0, d.length-1, 4);
	}

	public static int binaerSoek(int[] data, int min, int maks, int el) {
		if (min > maks) {
			return -1;
		}
		int midtpunkt = (min + maks) / 2;
		System.out.println("MIDTPUNKT: " + midtpunkt);
		//int resultat = el.compareTo(data[midtpunkt]);
		if (el == data[midtpunkt]) {//resultat == 0) {
			return midtpunkt;
		}
		if (el < data[midtpunkt]) {//resultat < 0) {
			return binaerSoek(data, min, midtpunkt - 1, el);
		} else {
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}

	}

	public static void oppgave1c() {
		Character tegn = ' ';
		TabellKoe<Character> koe = new TabellKoe<Character>();
		koe.innKoe('a');
		tegn = koe.foerste();
		koe.innKoe(tegn);
		koe.innKoe('c');
		koe.innKoe('b');
		tegn = koe.utKoe();
		tegn = koe.utKoe();

		System.out.println("TEGN = " + tegn);
	}

	public static void oppgave1b() {
		Character tegn = ' ';
		TabellStabel<Character> stabel = new TabellStabel<Character>();
		stabel.push('a');
		tegn = stabel.peek();
		stabel.push(tegn);
		stabel.push('c');
		stabel.push('b');
		tegn = stabel.pop();
		tegn = stabel.pop();

		System.out.println("TEGN = " + tegn);
	}

}

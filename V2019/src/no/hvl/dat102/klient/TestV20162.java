package no.hvl.dat102.klient;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.*;

public class TestV20162 {

	public static void main(String[] args) {
		KjedetOrdnetListe<Integer> l1 = new KjedetOrdnetListe<Integer>();
		KjedetOrdnetListe<Integer> l2 = new KjedetOrdnetListe<Integer>();
		
		l1.leggTil(20);
		l1.leggTil(60);
		l1.leggTil(100);
		
//		l2.leggTil(10);
		l2.leggTil(40);
		l2.leggTil(120);
		l2.leggTil(150);
		l2.leggTil(250);
		
		System.out.println("l1: " + l1.toString());
		System.out.println("l2: " + l2.toString());
		
		l1.flette(l2);
		
		System.out.println("l1: " + l1.toString());
		System.out.println("l2: " + l2.toString());

	}
	

}

package no.hvl.dat102;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.tabell.*;

public class RadixSort {

	public static void main(String[] args) {
		int[] liste = {7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241, 6589, 6622, 1211};
		System.out.print("Original: {" + liste[0]);
		for (int j = 1; j < liste.length; j++) {
			System.out.print(", " + liste[j]);
		}
		System.out.println("}");
		
		String temp;
		Integer tallObj;
		int siffer, tall;
		KoeADT<Integer>[] sifferKoer = new TabellKoe[10];
		
		for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
			sifferKoer[sifferVerdi] = new TabellKoe<Integer>();
		}
		
		/** Sorterer liste */
		for (int posisjon = 0; posisjon < 4; posisjon++) {
			// <4 siden vi har 4 siffer i det største tallet
			for (int i = 0; i < liste.length; i++) {
				temp = String.valueOf(liste[i]);
				siffer = Character.digit(temp.charAt(3-posisjon), 10);
				sifferKoer[siffer].innKoe(liste[i]);
			}
			
			/* Legger sorterte tall ut i liste */
			tall = 0;
			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
				while (!(sifferKoer[sifferVerdi].erTom())) {
					tallObj = sifferKoer[sifferVerdi].utKoe();
					liste[tall] = tallObj.intValue();
					tall++;
				}
			}
		}
		
		/** Skriver ut sortert liste */
		System.out.print("Sortert:  {" + liste[0]);
		for (int i = 1; i < liste.length; i++) {
			System.out.print(", " + liste[i]);
		}
		System.out.println("}");
		
		

	}

}

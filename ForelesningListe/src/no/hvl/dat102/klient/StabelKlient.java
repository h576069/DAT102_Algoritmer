package no.hvl.dat102.klient;

import no.hvl.dat102.KjedetStabel;

public class StabelKlient {
	public static void main(String[] args) {
		String str = "netsket re etteD";
		int lengde = str.length();
		
		KjedetStabel<Character> tegnStabel = new KjedetStabel<Character>();
		
		for (int i = 0; i < lengde; i++) {
			tegnStabel.push((str.charAt(i)));
		}
		System.out.println(str);
		while (!tegnStabel.erTom()) {
			Character tegn = tegnStabel.pop();
			System.out.print(tegn);
		}
		System.out.println();
	}
}

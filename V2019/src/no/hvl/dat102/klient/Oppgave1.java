package no.hvl.dat102.klient;
import no.hvl.dat102.*;

public class Oppgave1 {

	public static void main(String[] args) {
		// KjedetStabel
		KjedetStabel<String> ks = new KjedetStabel();
		
		ks.push("C");
		ks.push("B");
		ks.push("A");
		System.out.println(ks.toString());
		
		System.out.println(ks.peek());
		System.out.println(ks.pop());
		System.out.println(ks.pop());
		System.out.println(ks.pop());
		System.out.println(ks.peek());
		
	}

}

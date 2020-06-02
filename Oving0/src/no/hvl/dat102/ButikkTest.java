package no.hvl.dat102;

public class ButikkTest {

	public static void main(String[] args) {
//		p) Lag et enkelt main- program der du:
//		- oppretter en butikk med plass til 100 varer og prøver ut alle metodene i klassen Butikk
		
		// Oppretter butikken med 100 varer:
		Butikk but = new Butikk("Annes Butikk", 100);
		
		but.leggInnNyVare(2020, "Cola", 23.5, 15);
		but.leggInnNyVare(2021, "Fanta", 22.5, 10);
		//but.leggInnNyVare(2020, "Cola", 24.8, 10);
		but.leggInnNyVare(2007, "Zalo", 39.2, 20);
		
//		but.skrivUtVarer();
		
		//System.out.println(but.finnVare(2020));
		//System.out.println(but.finnVare(1919));
		
		//System.out.println(but.erLedigPlass());

		but.slettVare(2020);
		but.skrivUtVarer();

		//but.detaljSalg(2020);
		//but.skrivUtVarer();
		
		//but.grossInnkjop(2020, 30);
		//but.skrivUtVarer();
		
		//System.out.println(but.salgsVerdi());
		
//		Vare v = new Vare();
//		v.lesVare();
//		System.out.println(v.toString());
		

	}

}

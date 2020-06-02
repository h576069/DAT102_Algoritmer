package no.hvl.dat102;

public class KlientSpesiellKjedetStruktur {

	public static void main(String[] args) {
		SpesiellKjedetStruktur<Character> spesiell = new SpesiellKjedetStruktur<Character>();
		String streng = "Denne strengen er veldig spesiell!";
		int lengde = streng.length();
		
		for (int i = 0; i < lengde; i++) {
			spesiell.leggTil(streng.charAt(i));
		}
		
		System.out.println("FØR:   " + spesiell);
		
		spesiell.snuKjedetStruktur2();
		
		System.out.println("ETTER: "  + spesiell);
		
		spesiell.leggTilBak('q', '&');
		System.out.println(spesiell);
		
		System.out.println(spesiell.finnAntallLik('n'));

	}

}

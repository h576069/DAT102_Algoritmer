package no.hvl.dat102;

public class Oppgave1 {

	public static void main(String[] args) {
		// 1a)
//		System.out.println("S_100 = " + snRek(100));
		
		// 1b)
		System.out.print("Følgen er: " + an(0));
		for (int i = 1; i < 10; i++) {
			System.out.print(", " + an(i));
		}
		System.out.println();
		
	}
	
	/*
	 * 1 b)
	 * Leddene i følgen finnes ved a_n = 5a_(n-1) - 6a_(n-2) + 2
	 */
	public static int an(int n) {
		if (n == 0) {
			return 2;
		} else if (n == 1) {
			return 5;
		} else {
			return 5 * (an(n-1)) - 6*(an(n-2)) + 2;
		}
	}
	
	
	/*
	 * 1 a)
	 * Beregner S_n = 1 + 2 + 3 + ... + n.
	 */
	public static int snRek(int n) {
		if (n == 1) {
			return 1;
		} else {
			return snRek(n-1) + n;
		}
	}

}

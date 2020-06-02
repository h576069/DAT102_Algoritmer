package no.hvl.dat102;
import java.util.Random;
public class Oppgave4 {

	public static void main(String[] args) {
		final int n = 10;
		int[] tab = new int[n];
		int[] sum = new int[n];
		Random tilf = new Random(42);
		Random tilf2 = new Random(42);
		
		for (int i = 0; i < n; i++) {
			tab[i] = tilf.nextInt(100);
		}
		for (int j = 0; j < n; j++) {
			sum[j] = 0;
			for (int i = 0; i <= j; i++) {
				sum[j] = sum[j] + tab[i];
			}
		}
		System.out.print("tab:  ");
		printTab(tab);
		System.out.print("sum:  ");
		printTab(sum);
		
		int[] tab2 = new int[n];
		int[] sum2 = new int[n];
		for (int k = 0; k < n; k++) {
			tab2[k] = tilf2.nextInt(100);
			if (k == 0) {
				sum2[k] = tab2[k];
			} else {
				sum2[k] = sum2[k-1] + tab2[k];
			}
		}
		
		System.out.print("tab2: ");
		printTab(tab2);
		System.out.print("sum2: ");
		printTab(sum2);
		
		
	}
	
	private static void printTab(int[] tabell) {
		System.out.print("[ ");
		for (int t : tabell) {
			System.out.print(t + " ");
		}
		System.out.println("]");
	}

}

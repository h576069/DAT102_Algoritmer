package no.hvl.dat102;
import java.util.Random;
public class Kladdeoppgave4b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int n = 5;
		int[] tab = new int[n];
		int[] sum = new int[n];
		Random tilf = new Random();
		
		for (int i = 0; i < n; i++) {
			tab[i] = tilf.nextInt(10);
			if (i == 0) {
				sum[i] = tab[i];
			} else {
				sum[i] = sum[i-1] + tab[i];
			}
			System.out.printf("%4d", tab[i]);
		}
		System.out.println();
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%4d", sum[i]);
		}

	}

}

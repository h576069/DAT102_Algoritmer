package no.hvl.dat102.hanoi;

public class SolveTowers {
	/**
	 * Creates a TowersOfHanoi puzzle and solves it.
	 */
	public static void main(String[] args) {
		int[] ringer = {16, 28, 32};
		for (int i = 0; i < ringer.length; i++) {
			int antall = ringer[i];
			long start = System.currentTimeMillis();
			TowersOfHanoi towers = new TowersOfHanoi(antall);
			towers.solve();
			long slutt = System.currentTimeMillis();
			System.out.println("For " + antall + " ringer bruker vi " + (slutt - start) + " ms og " + towers.getMoves()
					+ " trekk");

		}
	}

}

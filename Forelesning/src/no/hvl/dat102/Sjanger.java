package no.hvl.dat102;
// ENUM

// Anbefalt å ha store bokstaver i enum

public enum Sjanger {
	ACTION, DRAMA, HISTORY, SCIFI;

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;

		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) { // Gjør om til store bokstaver
				sjang = sj;
				break; // Bryter løkken hvis vi finner en match
			}
		}

		return sjang;
	}
}
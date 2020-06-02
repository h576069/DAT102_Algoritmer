package no.hvl.dat102.tabell;

public class TabellHaug<T extends Comparable<T>> {
	private T[] data;
	private int antall;
	private static final int STDK = 100;

	public TabellHaug() {
		data = (T[]) new Comparable[STDK];
		antall = 0;
	}
	
	public TabellHaug(int stdk) {
		data = (T[]) new Comparable[stdk];
		antall = 0;
	}
	
	public int antall() {
		return antall;
	}
	
	public boolean erTom() {
		return (this.antall == 0);
	}

	public T fjernMinste() {
		T svar = null;
		if (antall > 0) {
			svar = data[0];
			data[0] = data[antall - 1];
			reparerNed();
			antall--;
		}
		return svar;
	}
	
	public void leggTilElement(T el) {
		// Fyll ut
	}
	
	public T finnMinste() {
		// Fyll ut
		return null;
	}

	private void reparerNed() {
		T hjelp;
		boolean ferdig = false;
		int forelder = 0;
		int minbarn;
		int vbarn = forelder * 2 + 1;
		int hbarn = vbarn + 1;
		while ((vbarn < antall) && !ferdig) {
			minbarn = vbarn;
			if ((hbarn < antall) && ((data[hbarn]).compareTo(data[vbarn]) < 0)) {
				minbarn = hbarn;
			}
			if ((data[forelder]).compareTo(data[minbarn]) <= 0) {
				ferdig = true;
			} else {
				hjelp = data[minbarn];
				data[minbarn] = data[forelder];
				data[forelder] = hjelp;
				forelder = minbarn;
				vbarn = forelder * 2 + 1;
				hbarn = vbarn + 1;
			}
		}
	}

}

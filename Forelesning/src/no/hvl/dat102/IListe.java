package no.hvl.dat102;
//Dokumentere i interfacen så vi slipper å gjøre det i klassen

public interface IListe {
	/** Beskrivelse av metoden
	 * 
	 * @param element er elementet som skal settes inn
	 */
	public void leggTil(int element);
	
	
	/**
	 * 
	 * @param element er elementet vi skal se om fins
	 * @return true hvis den finner elementet, false hvis ikke
	 */
	public boolean fins(int element);

}

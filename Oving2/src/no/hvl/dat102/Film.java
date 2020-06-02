package no.hvl.dat102;

public class Film {
	// Objektvariabler:
	private int filmnr;
	private String produsent;
	private String tittel;
	private int aar;
	private Sjanger sjang;
	private String selskap;
	
	// Constructors:
	public Film() {
		this(0, "", "", 0, null, "");
	}
	public Film(int filmnummer, String produsent, String tittel, int aar, Sjanger sjanger, String selskap) {
		this.filmnr = filmnummer;
		this.produsent = produsent;
		this.tittel  = tittel;
		this.aar = aar;
		this.sjang = sjanger;
		this.selskap = selskap;
	}
	
	// Get-set metoder:
	public int getNr() {
		return this.filmnr;
	}
	public String getProdusent() {
		return this.produsent;
	}
	public String getTittel() {
		return this.tittel;
	}
	public int getAar() {
		return this.aar;
	}
	public Sjanger getSjanger() {
		return this.sjang;
	}
	public String getSelskap() {
		return this.selskap;
	}
}

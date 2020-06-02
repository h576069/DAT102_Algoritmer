package no.hvl.dat102;
import java.util.Scanner;
import java.lang.Double;

public class Vare {
	// a) Objektvariabler:
	private int    varenummer;
	private String navn;
	private double pris;
	private int    antall;
	
	// b) Tre konstruktører:
	// 1. Uten parametre
	public Vare() {
		this(0, "", 0.0, 0); // Kaller på konstruktøren med alle parametrene
//		this.varenummer = 0;
//		this.navn       = "";
//		this.pris       = 0.0;
//		this.antall     = 0;
	}
	// 2. Med et parameter
	public Vare(int varenummer) {
		this(varenummer, "", 0.0, 0);
//		this.varenummer = varenummer;
//		this.navn 		= "";
//		this.pris 		= 0.0;
//		this.antall 	= 0;
	}
	// 3. Med fire parametre
	public Vare(int varenummer, String navn, double pris, int antall) {
		this.varenummer = varenummer;
		this.navn 		= navn;
		this.pris 		= pris;
		this.antall 	= antall;
	}
	
	// c) Get-set metoder
	// varenummer:
	public int getVarenummer() {
		return this.varenummer;
	}
	public void setVarenummer(int varenummer) {
		this.varenummer = varenummer;
	}
	// navn:
	public String getNavn() {
		return this.navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	// pris:
	public double getPris() {
		return this.pris;
	}
	public void setPris(double pris) {
		this.pris = pris;
	}
	// antall:
	public int getAntall() {
		return this.antall;
	}
	public void setAntall(int antall) {
		this.antall = antall;
	}
	
	// d) Metoden lesVare
	public void lesVare() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hva er navnet på varen?");
		String navn = scan.nextLine();
		System.out.println("Hva er prisen på varen?");
		double pris = Double.parseDouble(scan.nextLine());
		
		while (pris < 0) {
			System.out.println("Ugyldig pris\nHva er prisen på varen?");
			pris = Double.parseDouble(scan.nextLine());
		}
		scan.close();
		this.pris = pris;
		this.navn = navn;
		
		
	}
	
	// e) Metoden toString
	public String toString() {
		// varenummer, navn, pris, antall
		return "Varenummer: " + this.varenummer + "\nNavn:       " + this.navn + "\nPris:       " + this.pris + "\nAntall:     " + this.antall + "\n";
	}

}

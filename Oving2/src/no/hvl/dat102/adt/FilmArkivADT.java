package no.hvl.dat102.adt;
import no.hvl.dat102.*;

public interface FilmArkivADT {
	
	/** 
	 * Hente ut tabellen som beskriver ditt filmarkiv.
	 * 
	 * @return tabellen med filmene i
	 */
	public Film[] hentFilmTabell();
	
	/** 
	 * Legger til en ny film i filmarkivet, kun hvis filmen ikke eksisterer i arkivet
	 * 
	 * @param nyFilm er den nye filmen du vil legge til
	 */
	public void leggTilFilm(Film nyFilm);
	
	/** 
	 * Få ut antallet filmer som er i filmarkivet
	 * 
	 * @return antallet filmer i arkivet.
	 */
	public int getAntall();
	
	/** 
	 * Sletter en film fra filmarkivet. Sjekker først at filmen eksisterer i arkivet før den slettes.
	 * Hvis den ikke eksisterer i arkivet vil ingenting slettes.
	 * 
	 * @param filmNr er nummeret på filmen du vil slette
	 * @return true hvis filmen er blitt slettet, false ellers.
	 */
	public boolean slettFilm(int filmNr);
	
	/** 
	 * Søker etter filmer hvor delstrengen er en del av tittelen.
	 * Gir ut en array med disse filmene.
	 * 
	 * @param delstreng er en delstreng av titlene vi vil finne
	 * @return Filmene med tittel som inneholder delstrengen
	 */
	public Film[] sokTittel(String delstreng);
	
	/** 
	 * Søker etter filmer hvor delstrengen er en del av produsenten sitt navn.
	 * Gir ut en array med disse filmene.
	 * 
	 * @param delstreng av produsenten sitt navn
	 * @return filmene laget av produsenten
	 */
	public Film[] sokProdusent(String delstreng);
	
	
	/** 
	 * Henter ut antall filmer vi har i en gitt sjanger.
	 * 
	 * @param sjanger, sjangeren vi vil finne antallet for
	 * @return antallet filmer av denne sjangeren.
	 */
	public int antallSjanger(Sjanger sjanger);
	
	/**
	 * Returnerer filmen med det oppgitte filmnummeret
	 * @param filmNr
	 * @return
	 */
	public Film finnFilmMedNummer(int filmNr);
	
}

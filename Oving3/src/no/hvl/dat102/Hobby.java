package no.hvl.dat102;

public class Hobby {
	/*
	 * Gjelder kun en og en hobby
	 */
	private String hobbyNavn;
	
	// Konstruktør:
	public Hobby(String hobby) {
		this.hobbyNavn = hobby;
	}
	
	// Get og set funksjoner:
	public String getHobbyNavn() {
		return this.hobbyNavn;
	}
	public void setHobbyNavn(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}

	public String toString() {
		return this.hobbyNavn;
	}

	public boolean equals(Object hobby2) { //
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (this.hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}

}

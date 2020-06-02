package no.hvl.dat102;

import no.hvl.dat102.exception.*;
import no.hvl.dat102.adt.*;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = this.foerste.getElement();
		this.foerste = this.foerste.getNeste();
		this.antall--;

		if (erTom()) {
			this.siste = null;
		}

		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();
		this.antall--;
		if (this.antall == 0) {
			this.foerste = null;
			this.siste = null;
		} else {
			this.siste = this.foerste;
			for (int i = 1; i < this.antall; i++) {
				this.siste = this.siste.getNeste();
			}
			this.siste.setNeste(null);
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return this.foerste.getElement();
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return siste.getElement();
	}

	@Override
	public boolean erTom() {
		return (this.antall == 0);
	}

	@Override
	public int antall() {
		return this.antall;
	}

	@Override
	public void leggTil(T element) {
		// Oppretter ny node for det nye elementet
		LinearNode<T> ny = new LinearNode<T>(element);

		// Gjør klar til å gå gjennom alle nodene:
		LinearNode<T> forrige = null, aktuell = this.foerste;

		boolean funnet = false;

		// Sjekker om vi har en tom struktur:
		if (erTom()) {
			// Setter da det nye elementet som første og siste
			this.foerste = ny;
			this.siste = ny;
			// Og øker antallet med 1
			this.antall++;
		} else { // Har minst en node i strukturen
			// Sjekker det første elementet om vi skal sette inn foran:
			if (this.foerste.getElement().compareTo(element) > 0) {
				ny.setNeste(this.foerste);
				this.foerste = ny;
				this.antall++;
			} else {
				// Går gjennom nodene for å finne en match
				while (aktuell != null && !funnet) {
					if (aktuell.getElement().compareTo(element) >= 0) {
						funnet = true;
					} else {
						forrige = aktuell;
						aktuell = aktuell.getNeste();
					}
				}
				if (funnet) { // Har funnet en match
					ny.setNeste(aktuell);
					forrige.setNeste(ny);
					this.antall++;
				} else if (!funnet && aktuell == null) { // Ikke funnet og aktuell er blitt null (på slutten)
					// Setter inn bakerst
					forrige.setNeste(ny);
					this.antall++;
					this.siste = ny;
				}
			}

		}
	}

	@Override
	public T fjern(T element) {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = null;
		LinearNode<T> forrige = null, denne = this.foerste;

		// Uordnet er kommentert vekk
		while (denne != null && element.compareTo(denne.getElement()) > 0) { // !element.equals(denne.getElement())) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // Uordnet, fjerner && og ut
			this.antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				this.foerste = this.foerste.getNeste();
				if (this.foerste == null) { // Tom liste
					this.siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == this.siste) { // bak
					this.siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = this.foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		}
		return resultat;
	}

	public void flette(OrdnetListeADT<T> l2) {
		// Sjekker først om listene er tom:
		if (this.foerste == null || l2.getFoerste() == null) {
			if (this.foerste == null) {
				this.foerste = l2.getFoerste();
				this.antall = l2.antall();
			}
		} else { // begge metodene inneholder minste et element.
			// lager nødvendige variabler:
			LinearNode<T> t = this.foerste;
			LinearNode<T> l = l2.getFoerste();
			LinearNode<T> forrige = null;

			// Passer på å få en node i resultatet:
			if (l.getElement().compareTo(t.getElement()) < 0) { // Har satt noe inn
				// hvis l < t
				this.foerste = l;
				forrige = l;
				l = l.getNeste();
			} else { // Har ikke satt noe inn.
				forrige = t;
				t = t.getNeste();
			}

			// så lengde det er elementer igjen i begge listene
			while (l != null && t != null) {
				if (t.getElement().compareTo(l.getElement()) <= 0) {
					// t < l
					// Setter inn t-elementet og går videre i this-mengden
					forrige.setNeste(t);
					forrige = t;
					t = t.getNeste();
				} else { // Går videre i l2 mengden og setter inn fra l2-mengden.
					forrige.setNeste(l);
					forrige = l;
					l = l.getNeste();
				}
			}
			// Setter inn rester:
			if (t == null) {
				forrige.setNeste(l);
			} else {
				forrige.setNeste(t);
			}
			// oppdaterer antallet
			this.antall = this.antall + l2.antall();
			l2.setAntall(0);
			l2.setFoerste(new LinearNode<T>(null));
		}
	}

	public LinearNode<T> getFoerste() {
		return foerste;
	}

	public void setFoerste(LinearNode<T> foerste) {
		this.foerste = foerste;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	@Override
	public String toString() {
		LinearNode<T> p = this.foerste;
		String str = "[ ";
		while (p != null) {
			str += p.getElement() + " ";
			p = p.getNeste();
		}
		str += "]";
		return str;
	}

}// class

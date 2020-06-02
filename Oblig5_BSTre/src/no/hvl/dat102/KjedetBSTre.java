package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import java.util.*;

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {
	private int antall;
	private BinaerTreNode<T> rot;

	/**
	 * Oppretter et binært søketre
	 */
	public KjedetBSTre() {
		this.antall = 0;
		this.rot = null;
	}

	/**
	 * Oppretter et binært søketre med en node
	 * 
	 * @param element, elementet til noden
	 */
	public KjedetBSTre(T element) {
		this.rot = new BinaerTreNode<T>(element);
		this.antall = 1;
	}

	/*
	 * Metoder fra ADT:
	 */
	@Override
	public int antall() {
		return this.antall;
	}

	@Override
	public boolean erTom() {
		return (this.antall == 0);
	}

	@Override
	public void leggTil(T element) {
		this.rot = leggTilRek(this.rot, element);
		this.antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		if (p == null) { // basis
			return new BinaerTreNode<T>(element);
		} else {
			if (element.compareTo(p.getElement()) < 0) {
				// venstre side:
				p.setVenstre(leggTilRek(p.getVenstre(), element));
			} else {
				// høyre side:
				p.setHoyre(leggTilRek(p.getHoyre(), element));
			}
			return p;
		}
	}

	@Override
	public T finnMin() {
		BinaerTreNode<T> p = this.rot;

		if (p.getVenstre() == null) {
			return p.getElement();
		} else {
			while (p.getVenstre().getVenstre() != null) {
				p = p.getVenstre();
			}
		}
		return p.getVenstre().getElement();
	}

	@Override
	public T finnMaks() {
		BinaerTreNode<T> p = this.rot;

		if (p.getHoyre() == null) {
			return p.getElement();
		} else {
			while (p.getHoyre().getHoyre() != null) {
				p = p.getHoyre();
			}
			return p.getHoyre().getElement();
		}
	}

	@Override
	public T fjernMin() {
		BinaerTreNode<T> p = this.rot;
		T resultat = null;

		if (this.antall == 0)
			return null;

		if (p.getVenstre() == null) { // Roten er minste
			resultat = this.rot.getElement();
			this.rot = this.rot.getHoyre();
		} else { // Gå helt til venstre

			while (p.getVenstre().getVenstre() != null) {
				p = p.getVenstre();
			}
			// lagrer det minste elementet:
			resultat = p.getVenstre().getElement();

			// Vil fjerne elementet:
			BinaerTreNode<T> aktuell = p.getVenstre(); // Det er denne vi vil fjerne
			if (aktuell.getHoyre() == null) { // INGEN BARN
				p.setVenstre(null); // Bare setter bladnoden til null
			} else {
				p.setVenstre(aktuell.getHoyre());
			}
		}
		this.antall--;
		return resultat;
	}

	@Override
	public T fjernMaks() {
		BinaerTreNode<T> p = this.rot;
		T resultat = null;

		if (p.getHoyre() == null) {
			resultat = p.getElement();
			this.rot = p.getVenstre();
		} else {
			while (p.getHoyre().getHoyre() != null) {
				p = p.getHoyre();
			}
			resultat = p.getHoyre().getElement();
		}
		return resultat;
	}

	@Override
	public T finn(T element) {
		// Søk med rekursiv hjelpemetode
		return finnRek(element, this.rot);
	}

	private T finnRek(T element, BinaerTreNode<T> p) {
		T svar = null;
		if (p != null) {
			int sml = element.compareTo(p.getElement());

			if (sml == 0) { // I rot
				svar = p.getElement();
			} else if (sml < 0) {
				svar = finnRek(element, p.getVenstre());
			} else {
				svar = finnRek(element, p.getHoyre());
			}
		}
		return svar;
	}

	/*
	 * Andre metoder igjen:
	 */

	/**
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon
	 * 
	 * @param element, elementet vi søker etter
	 * @return elementet hvis det fins, null ellers.
	 */
	public T finn2(T element) {
		BinaerTreNode<T> p = this.rot;
		T resultat = null;
		int x = element.compareTo(p.getElement());
		while (p != null && x != 0) {
			if (x < 0) {
				p = p.getVenstre();
			} else if (x > 0) {
				p = p.getHoyre();
			}
			x = element.compareTo(p.getElement());
		}
		if (x == 0) {
			resultat = p.getElement();
		}
		return resultat;
	}

	public void visInorden() {
		visInordenRek(this.rot);
		System.out.println();
	}

	private void visInordenRek(BinaerTreNode<T> p) {
		if (p != null) {
			visInordenRek(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInordenRek(p.getHoyre());
		} // else = basis
	}

	public Iterator<T> iterator() {
		return new InordenIterator<T>(this.rot);
	}

	/**
	 * Metode for å finne høyden til et binærtre. Bruker en rekursiv hjelpemetode
	 * 
	 * @return høyden til et tre, -1 hvis tomt.
	 */
	public int finnHoyden() {
		return finnHoydenRek(this.rot);
	}

	private int finnHoydenRek(BinaerTreNode<T> p) {
		if (p == null) {
			return -1;
		} else {
			int hoydeHoyre = finnHoydenRek(p.getHoyre());
			int hoydeVenstre = finnHoydenRek(p.getVenstre());
			if (hoydeHoyre < hoydeVenstre) {
				return (1 + hoydeVenstre);
			} else {
				return (1 + hoydeHoyre);
			}
		}
	}

	public void skrivVerdier(T nedre, T ovre) {
		skrivVerdierRek(this.rot, nedre, ovre);
	}

	private void skrivVerdierRek(BinaerTreNode<T> t, T min, T maks) {
		if (t != null) {
			skrivVerdierRek(t.getVenstre(), min, maks);
			if ((t.getElement().compareTo(min) >= 0) && t.getElement().compareTo(maks) <= 0) {
				System.out.println(t.getElement() + " ");
			}
			skrivVerdierRek(t.getHoyre(), min, maks);
		}
	}

}

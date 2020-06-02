package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.BSTreADT;
import no.hvl.dat102.noder.BinaerTreNode;

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
	private int antall;
	private BinaerTreNode<T> rot;

	public KjedetBSTre() {
		this.antall = 0;
		this.rot = null;
	}

	public void visPostorden() {
		visRekPostorden(rot);
		System.out.println();
	}

	private void visRekPostorden(BinaerTreNode<T> p) {
		// Fyll ut
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return antall;
	}

	@Override
	public boolean erTom() {
		// TODO Auto-generated method stub
		return (antall == 0);
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

	public boolean erIdentisk(KjedetBSTre<T> t) {
		return erIdentiskRek(rot, t.rot);
	}

	private boolean erIdentiskRek(BinaerTreNode<T> t1, BinaerTreNode<T> t2) {
		// Fyll ut
		return false;
	}

	public void f(T a, T b) {
		fRek(rot, a, b);
	}

	private void fRek(BinaerTreNode<T> p, T a, T b) {
		if (p != null) {
			if (p.getElement().compareTo(a) >= 0) {
				fRek(p.getVenstre(), a, b);
				if (p.getElement().compareTo(b) <= 0) {
					System.out.println(p.getElement());
					fRek(p.getHoyre(), a, b);
				}
			}
		}
	}
	
	

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	public BinaerTreNode<T> getRot() {
		return rot;
	}

	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	public String toString() {
		return toString(rot);
	}

	private String toString(BinaerTreNode<T> p) {
		if (p == null) {
			return "";
		} else { // Blir å gå gjennom i inorden:
			return (toString(p.getVenstre()) + "\n" + p.getElement() + "\n" + toString(p.getHoyre()));
		}
	}

	public static <T extends Comparable<T>> boolean verifiserBSTre(KjedetBSTre<T> detAndre) {
		return verifiserBSTre(detAndre.getRot());
	}

	private static <T extends Comparable<T>> boolean verifiserBSTre(BinaerTreNode<T> p) {
		if (p.getVenstre() == null || p.getHoyre() == null) {
			return (true);
		} else {
			if (p.getVenstre().getElement().compareTo(p.getElement()) < 0
					&& p.getHoyre().getElement().compareTo(p.getElement()) >= 0) {
				return (verifiserBSTre(p.getVenstre()) && verifiserBSTre(p.getHoyre()));
			} else {
				return false;
			}
		}

	}
}

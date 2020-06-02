package no.hvl.dat102;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KjedetBSTreADTTest {

	private KjedetBSTre<Integer> bs;
	// Testdata som legges inn i treet
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;

	// Data som ikke legges inn i treet
	private Integer e7 = 8;

	/**
	 * Opprett et tomt tre for hver test.
	 * 
	 * @throws Exception exception
	 */
	@BeforeEach
	public final void setup() throws Exception {
		bs = new KjedetBSTre<Integer>();
	}

	/**
	 * Tester finn
	 * 
	 * Her legger du inn e0...e6 i treet i en vilkårlig rekkefølge. Etterpå sjekker
	 * du om elementene fins og til slutt sjekker du at e7 ikke fins
	 */
	@Test
	public final void erElementIBSTre() {
		bs.leggTil(e3);
		bs.leggTil(e4);
		bs.leggTil(e1);
		bs.leggTil(e6);
		bs.leggTil(e2);
		bs.leggTil(e5);
		bs.leggTil(e0);
		
		// Sjekker at elementene e0...e6 finnes i treet
		Integer el[] = { e0, e1, e2, e3, e4, e5, e6 };
		for (Integer e : el) {
			assertEquals(e, bs.finn(e));
		}
		
		// Sjekker at elementet e7 ikke finnes i treet
		assertFalse(e7.equals(bs.finn(e7)));
	}

	/**
	 * 1. Tester ordning ved å legge til elementer og fjerne minste
	 * 
	 * Her legger du først inn e0...e6 i en vilkårlig rekkefølge og så fjerner du
	 * minste hele tiden
	 */
	@Test
	public final void erBSTreOrdnet() {
		// Legger inn data
		bs.leggTil(e5);
		bs.leggTil(e2);
		bs.leggTil(e3);
		bs.leggTil(e0);
		bs.leggTil(e4);
		bs.leggTil(e1);
		bs.leggTil(e6);
		
		Integer el[] = { e0, e1, e2, e3, e4, e5, e6 };
		for (Integer e : el) {
			assertEquals(e, bs.fjernMin());
		}
		assertTrue(bs.erTom());
	}

	/**
	 * 2. Tester ordning ved å bruke en inordeniterator. Her studerer du alt om bruk
	 * av inordeniterator
	 */
	@Test
	public final void erBSTreOrdnet2() {
		bs.leggTil(e3);
		bs.leggTil(e2);
		bs.leggTil(e4);
		bs.leggTil(e1);
		bs.leggTil(e5);
		bs.leggTil(e0);
		bs.leggTil(e6);
		
		Integer el[] = { e0, e1, e2, e3, e4, e5, e6 };
		int i = 0;
		for (Integer e : bs) {
			assertEquals(el[i], e);
			i++;
		}
	}
}

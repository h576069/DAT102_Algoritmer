package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.exception.EmptyCollectionException;

public abstract class KoeADTTest {

	// Oppretter en Koe
	private KoeADT<Integer> koe;

	// Oppretter elementer vi kan sette inn:
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny kø for hver test
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/**
	 * Test på at en ny kø er tom
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * Test på innKoe og utKoe
	 */
	@Test
	public void innOgUt() {
		// Setter inn:
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);

		// Skal fjerne de igjen:
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());

		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test at en kø med noen elementer ikke er tom
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Tester at en kø med null elementer er tom.
	 */
	@Test
	public void innUtErTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("innKoe eller utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på størrelsen
	 */
	@Test
	public void stor() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		assertEquals(3, koe.antall());
	}

	/**
	 * Sjekke at utKoe på en tom kø gir unntak
	 * 
	 * @throws EmptyCollectionException forventet unntak
	 */
	@Test
	public void utKoeFraTomKoe() {
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}

	/**
	 * Tester innKoe og utKoe med duplikate verdier
	 */
	@Test
	public void innUtMedDuplikater() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Tester på første
	 */
	@Test
	public void foersteTest() {
		try {
			koe.innKoe(e2);
			koe.utKoe();
			koe.innKoe(e3);
			koe.innKoe(e4);
			koe.utKoe();
			assertEquals(e4, koe.foerste());
		} catch (EmptyCollectionException e) {
			fail("utKoe eller foerste feilet uventet " + e.getMessage());
		}
	}

}

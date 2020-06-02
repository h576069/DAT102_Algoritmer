package no.hvl.dat102;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.PriKoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.tabell.PriKoe;

public class PriKoeADTTest {
	// Referanse til kø (prioritetskø)
	private PriKoeADT<Integer> koe;
	// Standardkapasitet
	private static final int STDK = 5;
	// Testdata
	private final Integer e0 = 1;
	private final Integer e1 = 2;
	private final Integer e2 = 3;
	private final Integer e3 = 4;
	private final Integer e4 = 5;

	/**
	 * Hent en ny kø for hver test.
	 */
	@BeforeEach
	public final void setup() {
		koe = new PriKoe<Integer>(STDK);
	}

	@Test
	public final void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	@Test
	public final void settInnFjerneErTom() {
		try {
			koe.settInn(e0);
			koe.fjern();
			assertTrue(koe.erTom());
		} catch (final EmptyCollectionException e) {
			fail("innKoe eller utkoe feilet uventet " + e.getMessage());
		}
	}

	// Test på settInn and fjern.
	@Test
	public final void setteInnOgFjerne() {
		// … Fyll ut
	}
}

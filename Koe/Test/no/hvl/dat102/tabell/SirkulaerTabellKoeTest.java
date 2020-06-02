package no.hvl.dat102.tabell;
import no.hvl.dat102.adt.*;

public class SirkulaerTabellKoeTest extends KoeADTTest {
	@Override
	public KoeADT<Integer> reset() {
		return new SirkulaerTabellKoe<Integer>();
	}

}

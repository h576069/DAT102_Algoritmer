package no.hvl.dat102.tabell;
import no.hvl.dat102.adt.*;

public class TabellKoeTest extends KoeADTTest {
	@Override
	public KoeADT<Integer> reset() {
		return new TabellKoe<Integer>();
	}
}

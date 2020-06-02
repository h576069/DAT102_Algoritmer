package no.hvl.dat102.kjedet;
import no.hvl.dat102.adt.*;

public class KjedetKoeTest extends KoeADTTest {
	@Override
	public KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
		
	}

}

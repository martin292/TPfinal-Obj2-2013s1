package preferencias;


import org.junit.Test;

import junit.framework.TestCase;

public class TotalEstadiaTest extends TestCase {

	//Variables
	private TotalEstadia te = new TotalEstadia(100);
	
	//Getters y Setters
	private TotalEstadia getTe() {
		return te;
	}
	private void setTe(TotalEstadia te) {
		this.te = te;
	}

	
	@Test
	public void testCompararPrecioCon() {
		assertTrue(this.getTe().compararPrecioCon(100));
	}

}

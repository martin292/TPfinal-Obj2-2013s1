package preferencias;


import org.junit.Test;

import junit.framework.TestCase;

public class EntreValoresTest extends TestCase {

	private EntreValores ev = new EntreValores(10, 15);
	
	//Getters y Setters
	private EntreValores getEv() {
		return ev;
	}
	private void setEv(EntreValores ev) {
		this.ev = ev;
	}

	@Test
	public void testCompararPrecioCon() {
		
		assertTrue(this.getEv().compararPrecioCon(10));
		assertTrue(this.getEv().compararPrecioCon(11));
		assertTrue(this.getEv().compararPrecioCon(12));
		assertTrue(this.getEv().compararPrecioCon(13));
		assertTrue(this.getEv().compararPrecioCon(14));
		assertTrue(this.getEv().compararPrecioCon(15));
		
	}

}

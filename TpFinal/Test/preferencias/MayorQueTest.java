package preferencias;


import org.junit.Test;

import junit.framework.TestCase;

public class MayorQueTest extends TestCase {

	//Variables
	private MayorQue mq = new MayorQue(10);
		
	//Getters y Setters
	private MayorQue getMq() {
		return mq;
	}
	private void setMq(MayorQue mq) {
		this.mq = mq;
	}


	@Test
	public void testCompararPrecioCon() {
		assertTrue(this.getMq().compararPrecioCon(9));
	}

}

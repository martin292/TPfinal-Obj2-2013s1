package preferencias;


import org.junit.Test;

import junit.framework.TestCase;

public class MenorQueTest extends TestCase {

	//Variables
	private MenorQue mq = new MenorQue(10);
	
	//Getters y Setters
	private MenorQue getMq() {
		return mq;
	}
	private void setMq(MenorQue mq) {
		this.mq = mq;
	}

	
	@Test
	public void testCompararPrecioCon() {
		assertTrue(this.getMq().compararPrecioCon(11));
	}

}

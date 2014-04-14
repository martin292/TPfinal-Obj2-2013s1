package preferencias;


import org.junit.Test;

import alojamiento.Hotel;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;

public class NoDetalladoTest extends TestCase {

	//Variables
	NoDetallado nd = new NoDetallado("arg");
	
	//Getters y Setters
	private NoDetallado getNd() {
		return nd;
	}
	private void setNd(NoDetallado nd) {
		this.nd = nd;
	}

	@Test
	public void testCompararLugarCon() {
		
		Hotel h = mock(Hotel.class);
		
		when(h.retPais()).thenReturn("arg");
		
		assertTrue(this.getNd().compararLugarCon(h));
	}

}

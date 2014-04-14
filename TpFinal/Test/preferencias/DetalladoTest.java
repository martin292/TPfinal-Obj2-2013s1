package preferencias;


import org.junit.Test;

import alojamiento.Hotel;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;

public class DetalladoTest extends TestCase {

	//Variables
	private Detallado d = new Detallado("arg", "ba");
	
	//Getters y Setters
	private Detallado getD() {
		return d;
	}

	private void setD(Detallado d) {
		this.d = d;
	}

	@Test
	public void testCompararLugarCon() {
		
		Hotel h = mock(Hotel.class);
		
		when(h.retPais()).thenReturn("arg");
		when(h.retCiudad()).thenReturn("ba");
		
		assertTrue(this.getD().compararLugarCon(h));
		
	}

}

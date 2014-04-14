package subastas;


import org.junit.Test;
import org.junit.rules.ExpectedException;

import usuarios.Pasajero;

import static org.mockito.Mockito.*;
import junit.framework.TestCase;


public class EnPromocionTest extends TestCase {

	EnPromocion enPromocion;
	Subasta mockSubasta;
	Pasajero mockPasajero;
	public ExpectedException exception = ExpectedException.none();
	
	public void setUp(){
		
		enPromocion = new EnPromocion();
		mockSubasta = mock(Subasta.class);
		mockPasajero = mock(Pasajero.class);
	}
	
	/**
	 * Se testea que cuando la clase EnPromocion recibe una oferta se lanza la excepcion SubastaEnPromocionException.
	 */
	public void testRecibirOferta(){
		try {
			enPromocion.recibirOferta(mockSubasta, mockPasajero, 10);
			fail();
		} catch (SubastaEnPromocionException e) {
		}		
	}

}

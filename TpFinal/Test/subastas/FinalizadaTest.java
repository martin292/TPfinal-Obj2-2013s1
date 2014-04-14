package subastas;


import org.junit.Test;
import static org.mockito.Mockito.*;
import usuarios.Pasajero;
import junit.framework.TestCase;

public class FinalizadaTest extends TestCase {

	Finalizada finalizada;
	Subasta mockSubasta;
	Pasajero mockPasajero;
	
	public void setUp(){
		
		finalizada = new Finalizada();
		mockSubasta = mock(Subasta.class);
		mockPasajero = mock(Pasajero.class);

	}
	
	/**
	 * Se testea que cuando una instancia de Finalizada recibe una oferta se lanza la excepcion SubastaFinalizadaException.
	 */
	public void testRecibirOferta(){
		try {
			finalizada.recibirOferta(mockSubasta, mockPasajero, 10);
			fail();
		} catch (SubastaFinalizadaException e) {
		}
	}
}

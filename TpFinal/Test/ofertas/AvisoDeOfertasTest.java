package ofertas;

import java.util.ArrayList;
import static org.mockito.Mockito.*;
import org.junit.Test;

import usuarios.Pasajero;

import junit.framework.TestCase;

public class AvisoDeOfertasTest extends TestCase {

	//Variables
	AvisoDeOferta a = new AvisoDeOferta();


	//Tests
	@Test
	public void testSuscribirPasajero() {
		Pasajero p = mock(Pasajero.class);
		a.suscribirPasajero(p);
		assertTrue(a.retSuscriptores().size() > 0);
	}
	
	public void testActualizarOfertas(){
		Oferta o = mock(Oferta.class);
		a.actualizarOfertas(o);
		assertTrue(a.retOfertas().contains(o));
	}
	
	public void testNotificar(){
		Pasajero p = mock(Pasajero.class);
		Oferta o = mock(Oferta.class);
		a.suscribirPasajero(p);
		
		when(p.compararPreferenciaCon(o)).thenReturn(true);
		
		a.notificar(o);
		
		verify(p).compararPreferenciaCon(o);
		verify(p).notificar(a, o);
	}
	
	public void testCantidadDeSuscriptores(){
		Pasajero p = mock(Pasajero.class);
		a.suscribirPasajero(p);
		assertTrue(a.cantidadDeSuscriptores() == 1);
	}
	
	public void testEliminarSuscriptor(){
		Pasajero p = mock(Pasajero.class);
		a.suscribirPasajero(p);
		a.eliminarSuscriptor(p);
		assertTrue(a.cantidadDeSuscriptores() == 0);
	}
	
}

//Martin Ramos
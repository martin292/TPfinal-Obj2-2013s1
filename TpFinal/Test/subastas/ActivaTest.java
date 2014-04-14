package subastas;


import org.junit.Test;

import Fechas.Rango;
import static org.mockito.Mockito.*;
import usuarios.Pasajero;
import junit.framework.TestCase;

public class ActivaTest extends TestCase {

	Activa activa;
	Subasta mockSubasta1;
	Subasta mockSubasta2;
	Pasajero mockPasajero;
	Rango mockRango;
	
	public void setUp(){
		
		activa = new Activa();
		mockSubasta1 = mock(Subasta.class);
		mockSubasta2 = mock(Subasta.class);
		mockPasajero = mock(Pasajero.class);
		mockRango = mock(Rango.class);
		
		when(mockSubasta1.getOfertaActual()).thenReturn(200);
		
		when(mockSubasta2.getOfertaActual()).thenReturn(0);

	}
	
	
	
	public void testRecibirOferta1(){
		
		try {
			activa.recibirOferta(mockSubasta1, mockPasajero, 100);
			fail();
		} catch (OfertaMinimaException e) {
		}
	}
	
	public void testRecibirOferta2(){
		
		try {
			activa.recibirOferta(mockSubasta2, mockPasajero, 10);
			
		} catch (OfertaMinimaException e) {}
		
		verify(mockSubasta2).setOfertaActual(10);
		verify(mockSubasta2).setGanador(mockPasajero);
	}
	
	
	public void testSuperarOfertaActual(){
		
		activa.superarOfertaActual(mockSubasta1, mockPasajero);
		verify(mockSubasta1).setGanador(mockPasajero);
		verify(mockSubasta1).setOfertaActual(mockSubasta1.getOfertaActual() + 1);
		
		activa.superarOfertaActual(mockSubasta2, mockPasajero);
		verify(mockSubasta2).setGanador(mockPasajero);
		verify(mockSubasta2).setOfertaActual(mockSubasta2.getOfertaActual() + 1);
	}

}

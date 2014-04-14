package subastas;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;

import org.junit.Test;

import usuarios.Pasajero;

import Fechas.Rango;

public class SubastaTest extends TestCase{

	Subasta subasta1;
	Subasta subasta2;
	Subasta subasta3;
	Rango mockRango;
	Pasajero mockPasajero;
	Activa mockActiva;
	EnPromocion mockEnPromocion;
	Finalizada mockFinalizada;
	
	public void setUp(){
		
		mockPasajero = mock(Pasajero.class);
		mockRango = mock(Rango.class);
		mockActiva = mock(Activa.class);
		mockEnPromocion = mock(EnPromocion.class);
		mockFinalizada = mock(Finalizada.class);
		
		subasta1 = new Subasta(mockRango, mockActiva, 100);
		subasta2 = new Subasta(mockRango, mockEnPromocion, 1);
		subasta3 = new Subasta(mockRango, mockFinalizada, 0);
	}
	
	
	public void testRecibirOfertaDe() throws OfertaMinimaException, SubastaFinalizadaException, SubastaEnPromocionException{
		
		subasta1.recibirOfertaDe(mockPasajero, 150);
		verify(subasta1.getEstado()).recibirOferta(subasta1, mockPasajero, 150);
		
		subasta2.recibirOfertaDe(mockPasajero, 20);
		verify(subasta2.getEstado()).recibirOferta(subasta2, mockPasajero, 20);
		
		subasta3.recibirOfertaDe(mockPasajero, 1);
		verify(subasta3.getEstado()).recibirOferta(subasta3, mockPasajero, 1);
		
	}
	
	public void testSuperarOfertaActual() throws SubastaFinalizadaException, SubastaEnPromocionException{
		
		subasta1.superarOfertaActual(mockPasajero);
		verify(subasta1.getEstado()).superarOfertaActual(subasta1, mockPasajero);
		
		subasta2.superarOfertaActual(mockPasajero);
		verify(subasta2.getEstado()).superarOfertaActual(subasta2, mockPasajero);
		
		subasta3.superarOfertaActual(mockPasajero);
		verify(subasta3.getEstado()).superarOfertaActual(subasta3, mockPasajero);
	}
	
	
	
	public void testActualizarEstado(){
		
		subasta1.actualizarEstado();
		verify(subasta1.getEstado()).actualizarEstado(subasta1);
		
		subasta2.actualizarEstado();
		verify(subasta2.getEstado()).actualizarEstado(subasta2);
		
		subasta3.actualizarEstado();
		verify(subasta3.getEstado()).actualizarEstado(subasta3);
	}

}

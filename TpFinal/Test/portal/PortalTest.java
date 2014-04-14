package portal;

import java.util.ArrayList;
import java.util.Calendar;

import descuentos.Descuento;

import Fechas.PrecioRango;
import Fechas.Rango;
import FormasDePago.Credito;
import FormasDePago.Efectivo;
import alojamiento.Calificacion;
import alojamiento.Habitacion;
import alojamiento.Hotel;

import ofertas.AvisoDeOferta;
import reservas.Reserva;

import usuarios.Hotelero;
import usuarios.Pasajero;
import usuarios.Usuario;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;


public class PortalTest extends TestCase {

	
	//Variables
	public Portal p1 = new Portal();
	Portal portal = new Portal();
	Hotel mockHotel;
	Descuento mockDescuento;
	Habitacion mockHabitacion;
	Rango mockRango;
	PrecioRango mockPrecioRango;
	Reserva mockReserva;
	Pasajero mockPasajero;
	
	
	public void setUp(){
		mockHotel = mock(Hotel.class);
		mockDescuento = mock(Descuento.class);
		mockHabitacion = mock(Habitacion.class);
		mockRango = mock(Rango.class);
		mockPrecioRango = mock(PrecioRango.class);
		mockReserva = mock(Reserva.class);
		mockPasajero = mock(Pasajero.class);
	}
	
	//Tests-------------------------------------------
		
	public void testSuscribirseAlAviso(){
		
		AvisoDeOferta a = mock(AvisoDeOferta.class);
		Pasajero p = mock(Pasajero.class);
		
		p1.agregarUsuario(p);
		
		p1.setAviso(a);
		
		p1.suscribirseAlAviso(p);
		
		verify(a).suscribirPasajero(p);
	}
	
	public void testHotelesEn(){
		Hotel h = mock(Hotel.class);
		
		when(h.getPais()).thenReturn("arg");
		when(h.getCiudad()).thenReturn("bsas");
		
		p1.agregarHotel(h);
		
		assertTrue(p1.hotelesEn("arg", "bsas").contains(h));
		
		verify(h).getPais();
		verify(h).getCiudad();		
	}
	

	public void testRetHotelesConNombre(){
		Hotel h = mock(Hotel.class);
		
		when(h.getNombre()).thenReturn("A");
		
		p1.agregarHotel(h);
		
		assertTrue(p1.retHotelesConNombre("A").contains(h));
		
		verify(h).getNombre();
	}
	
	public void testReservar(){
		Pasajero p = mock(Pasajero.class);
		Habitacion hab = mock(Habitacion.class);
		Hotel h = mock(Hotel.class);
		Rango r = mock(Rango.class);
		Credito c = mock(Credito.class);
		
		p1.agregarUsuario(p);
		
		when(hab.getHotel()).thenReturn(h);
		when(hab.libreEn(r)).thenReturn(true);
		
		p1.reservar(hab, r, 1, c, p);
		
		verify(hab).agregarDisponibilidad(r);
				
	}
	
	public void testUsuarioRegistrado(){
		Pasajero p = mock(Pasajero.class);
		
		p1.agregarUsuario(p);
		
		assertTrue(p1.usuarioRegistrado(p));
	}
	

}


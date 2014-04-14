package reservas;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import org.junit.Test;

import usuarios.Pasajero;
import reservas.Reserva;
import alojamiento.Habitacion;
import alojamiento.Hotel;

import Fechas.Rango;
import FormasDePago.Credito;
import FormasDePago.Efectivo;
import FormasDePago.FormaDePago;


public class ReservaTest extends TestCase {

	public Reserva x;
	
	public void setUp(){
		
		Rango r = new Rango();
		Hotel h = new Hotel();
		Habitacion ha = new Habitacion();
		Pasajero p = new Pasajero();
		Credito f = new Credito("x", "y", 1);
		
		Reserva r1 = new Reserva(1, r, h, ha, p, f);
		this.x = r1;
		
	}
	
	//Tests
	public void testCancelarReserva(){
		
		Concretado c = mock(Concretado.class);
		
		x.cambiarEstado(c);
		
		x.cancelarReserva();
		
		verify(x.retEstado()).cancelar(x);
		verify(c).cancelar(x);
	}
	
	public void testRetornarPrecioReal(){
		
		Habitacion hh = mock(Habitacion.class);
		
		x.setHabitacion(hh);
		
		when(hh.precioReal(x.getRangoFecha())).thenReturn(100);
		
		assertEquals(x.retornarPrecioReal(), 100);
		
		verify(hh).precioReal(x.getRangoFecha());
	}

	
	public void testCambiarHabitacion(){
		Habitacion h = mock(Habitacion.class);
		
		x.cambiarHabitacion(h);
				
		verify(h).agregarDisponibilidad(x.getRangoFecha());
	}
	
	public void testCambiarFormaDePago(){
		Efectivo e = mock(Efectivo.class);
		
		x.cambiarFormaDePago(e);
		
		assertTrue(x.getForma() == e);
	}
	
	
}

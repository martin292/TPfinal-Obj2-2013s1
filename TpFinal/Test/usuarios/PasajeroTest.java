package usuarios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Calendar;

import junit.framework.TestCase;
import ofertas.Oferta;
import org.junit.Test;

import alojamiento.Calificacion;
import alojamiento.Habitacion;
import alojamiento.Hotel;
import portal.Portal;
import preferencias.Preferencia;
import reservas.Concretado;
import reservas.Reserva;
import Fechas.Rango;
import FormasDePago.Efectivo;
import FormasDePago.Tarjeta;

public class PasajeroTest extends TestCase {

	//Variables
	public Pasajero p1 = new Pasajero("martin", "ramos", "aaa");
	
	
	
	//Tests
	public void testChequearOferta(){
		
		Oferta o = mock(Oferta.class);
		Preferencia p = mock(Preferencia.class);
		
		when(p.compararCon(o)).thenReturn(true);
		
		p1.setPreferencia(p);
		
		assertTrue(p1.chequearOferta(o));
		
	}

	public void testRetReservasFuturas(){
		
		Reserva r = mock(Reserva.class);
				
		Calendar x = Calendar.getInstance();
		x.set(2015, 1, 1);
		
		when(r.retFechaInicio()).thenReturn(x);
		
		p1.setReserva(r);
		
		assertTrue(p1.retReservasFuturas().contains(r));
		
		verify(r).retFechaInicio();
		
	}
	
	public void testRetReservasEn(){
		
		Reserva r = mock(Reserva.class);
		
		p1.setReserva(r);
		
		when(r.retCiudad()).thenReturn("bsas");
		
		assertTrue(p1.retReservasEn("bsas").contains(r));
		
		verify(r).retCiudad();
	}
	
	
	public void testCancelar(){
		Reserva r = mock(Reserva.class);
						
		p1.setReserva(r);
		
		p1.cancelar(r);
				
		verify(r).cancelarReserva();
				
	}
	
	public void testModificar(){
		Reserva r = mock(Reserva.class);
		Efectivo e = mock(Efectivo.class);
		
		p1.setReserva(r);
		
		p1.modificar(r, e);
		
		verify(r).cambiarFormaDePago(e);
	}
	
	public void testModificar2(){
		Reserva r = mock(Reserva.class);
		Habitacion h = mock(Habitacion.class);
		
		p1.setReserva(r);
		
		p1.modificar(r, h);
		
		verify(r).cambiarHabitacion(h);
	}
	
	public void testCalificar(){
		Hotel h = mock(Hotel.class);
		
		p1.calificar(h, 10, "abc");	
		
	}
	
	public void testSuscribirse(){
		Portal p = mock(Portal.class);
		
		p1.setPortal(p);
		
		p1.suscribirse();
		
		verify(p).suscribirseAlAviso(p1);		
	}
	
	public void testCrearPrecioEntreValores(){		
		assertTrue(p1.crearPrecioEntreValores(10, 20).getPrecioA() == 10);
		assertTrue(p1.crearPrecioEntreValores(10, 20).getPrecioB() == 20);
	}
	public void testCrearPrecioMenorQue(){
		assertTrue(p1.crearPrecioMenorQue(10).getPrecioA() == 10);
	}
	public void testCrearPrecioMayorQue(){
		assertTrue(p1.crearPrecioMayorQue(10).getPrecioA() == 10);
	}
	public void testCrearPrecioTotalEstadia(){
		assertTrue(p1.crearPrecioTotalEstadia(10).getPrecioA() == 10);
	}
	
	public void testCrearLugarDetallado(){
		assertTrue(p1.crearLugarDetallado("arg", "bsas").retPais() == "arg");
		assertTrue(p1.crearLugarDetallado("arg", "bsas").retCiudad() == "bsas");
	}
	public void testCrearLugarNoDetallado(){
		assertTrue(p1.crearLugarNoDetallado("arg").retPais() == "arg");
	}
	
	public void testActualizarDatos(){
		p1.actualizarDatos("A", "B", "C");
		
		assertTrue(p1.retNombre() == "A");
		assertTrue(p1.retApellido() == "B");
		assertTrue(p1.retEmail() == "C");
	}
	
	public void testBuscarAlojamiento(){
		
		Portal p = mock(Portal.class);
		Calendar i = Calendar.getInstance();
		ArrayList ret = mock(ArrayList.class);
		
		p1.setPortal(p);
		
		when(p.buscarAlojamiento("arg", "bsas", i, i, 1)).thenReturn(ret);
		
		assertSame(p1.buscarAlojamiento("arg", "bsas", i, i, 1), ret);
		
		verify(p).buscarAlojamiento("arg", "bsas", i, i, 1);
	}
	
	public void testBuscarHotelesEn(){
		Portal p = mock(Portal.class);
		ArrayList ret = mock(ArrayList.class);
		
		p1.setPortal(p);
		
		when(p.hotelesEn("arg", "bsas")).thenReturn(ret);
		
		assertSame(p1.buscarHotelesEn("arg", "bsas"), ret);
		
		verify(p).hotelesEn("arg", "bsas");
	}
	

	public void testRetCiudadesDondeSeReservo(){
		Reserva r1 = mock(Reserva.class);
		Reserva r2 = mock(Reserva.class);
		
		p1.setReserva(r1);
		p1.setReserva(r2);
		
		when(r1.retCiudad()).thenReturn("A");
		when(r2.retCiudad()).thenReturn("B");
		
		assertTrue(p1.retCiudadesDondeSeReservo().contains("A"));
		assertTrue(p1.retCiudadesDondeSeReservo().contains("B"));
	}
	
	
	public void testCompararPreferenciaCon(){
		Oferta o = mock(Oferta.class);
		Preferencia p = mock(Preferencia.class);
		
		when(p.compararCon(o)).thenReturn(true);
		
		p1.setPreferencia(p);
		
		assertTrue(p1.compararPreferenciaCon(o));
		
		verify(p).compararCon(o);
	}
	
	
}

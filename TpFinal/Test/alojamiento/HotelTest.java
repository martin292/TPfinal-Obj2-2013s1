package alojamiento;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import static org.mockito.Mockito.*;
import descuentos.Descuento;

import reservas.Reserva;
import servicios.DeHotel;

import FormasDePago.Tarjeta;

public class HotelTest extends TestCase {

	Hotel hotel;
	Habitacion mockHabitacion;
	Habitacion mockHabitacion2;
	String mockTarjeta1;
	String mockTarjeta2;
	DeHotel mockServicioDeHotel1;
	DeHotel mockServicioDeHotel2;
	Calificacion mockCalificacion1;
	Calificacion mockCalificacion2;
	Calificacion mockCalificacion3;
	Calificacion mockCalificacion4;
	Calificacion mockCalificacion5;
	Calificacion mockCalificacion6;
	Calificacion mockCalificacion7;
	Calificacion mockCalificacion8;
	Reserva mockReserva1;
	Reserva mockReserva2;
	Reserva mockReserva3;
	Reserva mockReserva4;
	Reserva mockReserva5;
	Descuento mockDescuento1;
	Descuento mockDescuento2;
	
	public void setUp(){
		
		hotel = new Hotel();
		mockHabitacion = mock(Habitacion.class);
		mockHabitacion2 = mock(Habitacion.class);

		mockServicioDeHotel1 = mock(DeHotel.class);
		mockServicioDeHotel2 = mock(DeHotel.class);
		mockCalificacion1 = mock(Calificacion.class);
		mockCalificacion2 = mock(Calificacion.class);
		mockCalificacion3 = mock(Calificacion.class);
		mockCalificacion4 = mock(Calificacion.class);
		mockCalificacion5 = mock(Calificacion.class);
		mockCalificacion6 = mock(Calificacion.class);
		mockCalificacion7 = mock(Calificacion.class);
		mockCalificacion8 = mock(Calificacion.class);
		mockReserva1 = mock(Reserva.class);
		mockReserva2 = mock(Reserva.class);
		mockReserva3 = mock(Reserva.class);
		mockReserva4 = mock(Reserva.class);
		mockReserva5 = mock(Reserva.class);
		mockDescuento1 = mock(Descuento.class);
		mockDescuento1 = mock(Descuento.class);
		
		hotel.getReservas().add(mockReserva1);
		hotel.getReservas().add(mockReserva2);
		hotel.getReservas().add(mockReserva3);
		hotel.getReservas().add(mockReserva4);
		hotel.getReservas().add(mockReserva5);
		
		when(mockCalificacion1.getPuntaje()).thenReturn(7);
		when(mockCalificacion2.getPuntaje()).thenReturn(10);
		when(mockCalificacion3.getPuntaje()).thenReturn(6);
		when(mockCalificacion4.getPuntaje()).thenReturn(7);
		when(mockCalificacion5.getPuntaje()).thenReturn(5);
		when(mockCalificacion6.getPuntaje()).thenReturn(9);
		when(mockCalificacion7.getPuntaje()).thenReturn(9);
		when(mockCalificacion8.getPuntaje()).thenReturn(1);
		
	}
	
	
	public void testAgregarHabitacion(){
		
		hotel.agregarHabitacion(mockHabitacion);
		
		assertTrue("FALLA LA AGREGACION DE UNA HABITACION EN EL HOTEL", hotel.getHabitaciones().contains(mockHabitacion));
		assertFalse("SE ENCONTRO UNA HABITACION QUE NO FUE AGREADA A LA COLECCION", hotel.getHabitaciones().contains(mockHabitacion2));
	}
	
	public void testAgregarTarjeta(){
		
		hotel.agregarTarjeta(mockTarjeta1);
		
		assertTrue("FALLA LA AGREGACION DE UNA TARJETA EN EL HOTEL", hotel.getTarjetas().contains(mockTarjeta1));
		assertTrue("SE ENCONTRO UNA TARJETA QUE NO FUE AGREGADA A LA COLECCION", hotel.getTarjetas().contains(mockTarjeta2));
	}

	public void testAgregarServicioDeHotel(){
		
		hotel.agregarServicioDeHotel(mockServicioDeHotel1);
		
		assertTrue("FALLA LA AGREGACION DE UN SERVICIO DE HOTEL EN EL HOTEL", hotel.getServiciosDeHotel().contains(mockServicioDeHotel1));
		assertFalse("SE ENCONTRO UN SERVICIO QUE NO FUE AGREGADA A LA COLECCION", hotel.getServiciosDeHotel().contains(mockServicioDeHotel2));
	}
	
	public void testAgregarServiciosDeHotel(){
		
		List<DeHotel> servicios = new ArrayList<DeHotel>();
		servicios.add(mockServicioDeHotel1);
		servicios.add(mockServicioDeHotel2);
		
		hotel.agregarServiciosDeHotel(servicios);
		
		assertEquals("FALLA LA AGREGACION DE UNA COLECCION DE SERVICIOS AL HOTEL", hotel.getServiciosDeHotel(), servicios);
	}
	
	public void testAgregarCalificacion(){
		
		hotel.agregarCalificacion(mockCalificacion1);
		
		assertTrue("FALLA LA AGREGACION DE UNA CALIFICACION AL HOTEL", hotel.getCalificaciones().contains(mockCalificacion1));
		assertFalse("SE ENCONTRO UNA CALIFICACION QUE NO FUE AGREGADA A LA COLECCION", hotel.getCalificaciones().contains(mockServicioDeHotel2));
	}
	
	public void testAgregarReserva(){
		
		hotel.agregarReserva(mockReserva1);
		
		assertTrue("FALLA LA AGREGACION DE UNA RESERVA AL HOTEL", hotel.getReservas().contains(mockReserva1));
		assertTrue("SE ENCONTRO UNA RESERVA QUE NO FUE AGREGADA A LA COLECCION", hotel.getReservas().contains(mockReserva2));
	}
	
	public void testAgregarDescuento(){
		
		hotel.agregarDescuento(mockDescuento1);
		
		assertTrue("FALLA LA AGREGACION DE UN DESCUENTO AL HOTEL", hotel.getDescuentos().contains(mockDescuento1));
		assertFalse("SE ENCONTRO UN DESCUENTO QUE NO FUE AGREGADA A LA COLECCION", hotel.getDescuentos().contains(mockDescuento2));
	}
	
	public void testPuntajePromedio1(){
		
		List<Calificacion> calificaciones1 = new ArrayList<Calificacion>();
		
		calificaciones1.add(mockCalificacion1);
		calificaciones1.add(mockCalificacion2);
		calificaciones1.add(mockCalificacion3);
		calificaciones1.add(mockCalificacion4);
		calificaciones1.add(mockCalificacion5);
		calificaciones1.add(mockCalificacion6);
		calificaciones1.add(mockCalificacion7);
		calificaciones1.add(mockCalificacion8);
		
		hotel.setCalificaciones(calificaciones1);
		
		double valorEsperado1 = 6.75;
		
		assertEquals("FALLA EL PUNTAJE PROMEDIO RETORNADO 1", valorEsperado1, hotel.puntajePromedio());
	}
	
	public void testPuntajePromedio2(){
		
		List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		
		calificaciones.add(mockCalificacion1);
		calificaciones.add(mockCalificacion3);
		calificaciones.add(mockCalificacion4);
		calificaciones.add(mockCalificacion5);
		
		double valorEsperado = 6.25;
		
		hotel.setCalificaciones(calificaciones);
		
		assertEquals("FALLA EL PUNTAJE PROMEDIO RETORNADO 2", valorEsperado, hotel.puntajePromedio());
	}
	
	public void testPuntajePromedio3(){
		
		List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		
		calificaciones.add(mockCalificacion4);
		calificaciones.add(mockCalificacion5);
		calificaciones.add(mockCalificacion7);
		
		double valorEsperado = 7;
		
		hotel.setCalificaciones(calificaciones);
		
		assertEquals("FALLA EL PUNTAJE PROMEDIO RETORNADO 3", valorEsperado, hotel.puntajePromedio());
	}
	
	public void testReservasActuales(){
		
		when(mockReserva1.esActual()).thenReturn(true);
		when(mockReserva2.esActual()).thenReturn(false);
		when(mockReserva3.esActual()).thenReturn(true);
		when(mockReserva4.esActual()).thenReturn(true);
		when(mockReserva5.esActual()).thenReturn(false);
		
		List<Reserva> reservasEsperadas = new ArrayList<Reserva>();
		reservasEsperadas.add(mockReserva1);
		reservasEsperadas.add(mockReserva3);
		reservasEsperadas.add(mockReserva4);
		
		assertEquals("FALLA LA DEVOLUCION DE RESERVAS ACTUALES", reservasEsperadas, hotel.reservasActuales());
	}
	
	public void testReservasFuturas(){
		
		when(mockReserva1.esFutura()).thenReturn(false);
		when(mockReserva2.esFutura()).thenReturn(false);
		when(mockReserva3.esFutura()).thenReturn(true);
		when(mockReserva4.esFutura()).thenReturn(true);
		when(mockReserva5.esFutura()).thenReturn(false);
		
		List<Reserva> reservasEsperadas = new ArrayList<Reserva>();
		reservasEsperadas.add(mockReserva3);
		reservasEsperadas.add(mockReserva4);
		
		assertEquals("FALLA LA DEVOLUCION DE RESERVAS FUTURAS", reservasEsperadas, hotel.reservasFuturas());
	}
	
	public void testReservasQueInicianEn(){
		when(mockReserva1.cantDiasParaIniciar()).thenReturn(15);
		when(mockReserva2.cantDiasParaIniciar()).thenReturn(22);
		when(mockReserva3.cantDiasParaIniciar()).thenReturn(2);
		when(mockReserva4.cantDiasParaIniciar()).thenReturn(1);
		when(mockReserva5.cantDiasParaIniciar()).thenReturn(1);
		
		List<Reserva> reservasEsperadas = new ArrayList<Reserva>();
		reservasEsperadas.add(mockReserva4);
		reservasEsperadas.add(mockReserva5);
		
		assertEquals("FALLA LA DEVOLUCION DE RESERVAS QUE INICIAN EN 1 DIAS", reservasEsperadas, hotel.reservasQueInicianEn(1));
	}
	
	
}

package usuarios;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import descuentos.Descuento;

import reservas.Reserva;

import Fechas.PrecioRango;
import Fechas.Rango;
import alojamiento.Habitacion;
import alojamiento.Hotel;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;


public class HoteleroTest extends TestCase {
	
	//Variables
	Hotelero hotelero;
	Hotel mockHotel1;
	Hotel mockHotel2;
	Reserva mockReserva1;
	Reserva mockReserva2;
	Reserva mockReserva3;
	Reserva mockReserva4;
	Reserva mockReserva5;
	Reserva mockReserva6;
	Descuento mockDescuento;
	Habitacion mockHabitacion;
	Rango mockRango;
	PrecioRango mockPrecioRango;
	Pasajero mockPasajero;
	
	
	public void setUp(){
		hotelero = new Hotelero();
		mockHotel1 = mock(Hotel.class);
		mockHotel2 = mock(Hotel.class);
		mockReserva1 = mock(Reserva.class);
		mockReserva2 = mock(Reserva.class);
		mockReserva3 = mock(Reserva.class);
		mockReserva4 = mock(Reserva.class);
		mockReserva5 = mock(Reserva.class);
		mockReserva6 = mock(Reserva.class);
		mockDescuento = mock(Descuento.class);
		mockHabitacion = mock(Habitacion.class);
		mockRango = mock(Rango.class);
		mockPrecioRango = mock(PrecioRango.class);
		mockPasajero = mock(Pasajero.class);		
	}
	
	
	public void testReservasActuales() {
		
		hotelero.getHoteles().add(mockHotel1);
		hotelero.getHoteles().add(mockHotel2);
		List<Reserva> reservasActualesHotel1 = new ArrayList<Reserva>();
		List<Reserva> reservasActualesHotel2 = new ArrayList<Reserva>();
		reservasActualesHotel1.add(mockReserva1);
		reservasActualesHotel1.add(mockReserva2);
		reservasActualesHotel1.add(mockReserva3);
		reservasActualesHotel1.add(mockReserva4);
		reservasActualesHotel2.add(mockReserva5);
		reservasActualesHotel2.add(mockReserva6);
		
		when(mockHotel1.reservasActuales()).thenReturn(reservasActualesHotel1);
		when(mockHotel2.reservasActuales()).thenReturn(reservasActualesHotel2);
		
		hotelero.reservasActuales();
		verify(mockHotel1).reservasActuales();
		verify(mockHotel2).reservasActuales();
		
		assertEquals(6, hotelero.reservasActuales().size());
	}
	
	public void testReservasFuturas() {
		
		hotelero.getHoteles().add(mockHotel1);
		List<Reserva> reservasFuturas = new ArrayList<Reserva>();
		reservasFuturas.add(mockReserva1);
		reservasFuturas.add(mockReserva2);
		reservasFuturas.add(mockReserva3);
		reservasFuturas.add(mockReserva4);
		
		when(mockHotel1.reservasFuturas()).thenReturn(reservasFuturas);
		
		hotelero.reservasFuturas();
		verify(mockHotel1).reservasFuturas();
		
		assertEquals(4, hotelero.reservasFuturas().size());
		assertEquals(reservasFuturas, hotelero.reservasFuturas());
	}
	
	public void testReservasQueInicianEn(){
		hotelero.getHoteles().add(mockHotel1);
		hotelero.getHoteles().add(mockHotel2);
		hotelero.reservasQueInicianEn(7);
		verify(mockHotel1).reservasQueInicianEn(7);
		verify(mockHotel2).reservasQueInicianEn(7);
		
	}

	public void testReservasActuales1(){
		hotelero.reservasActuales(mockHotel1);
		verify(mockHotel1).reservasActuales();
	}
	
	public void testReservasFuturas1(){
		hotelero.reservasFuturas(mockHotel1);
		verify(mockHotel1).reservasFuturas();
	}
	
	public void testReservasQueInicianEn1(){
		hotelero.reservasQueInicianEn(mockHotel1, 2);
		verify(mockHotel1).reservasQueInicianEn(2);
	}
	
	public void testCargarDescuento(){
		hotelero.cargarDescuento(mockHotel1, mockDescuento);
		verify(mockHotel1).agregarDescuento(mockDescuento);
	}
	
	public void testAgregarHabitacion(){
		hotelero.agregarHabitacion(mockHotel1, mockHabitacion);
		verify(mockHotel1).agregarHabitacion(mockHabitacion);
	}
	
	public void testAgregarHabitaciones(){
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones.add(mockHabitacion);
		
		hotelero.agregarHabitacion(mockHotel1, habitaciones);
		verify(mockHotel1).agregarHabitaciones(habitaciones);
	}
	
	public void testModificarDisponibilidad(){
		hotelero.modificarDisponibilidad(mockHabitacion, mockRango);
		verify(mockHabitacion).agregarRangoReservado(mockRango);
	}
	
	public void testModificarPrecio(){
		
		hotelero.modificarPrecio(mockHabitacion, mockPrecioRango);
		verify(mockHabitacion).modificarPrecio(mockPrecioRango);
	}
	
	public void testvisualizarDatosDelUsuario(){
		when(mockReserva1.retPasajero()).thenReturn(mockPasajero);
		
		hotelero.visualizarDatosDelUsuario(mockReserva1);
		verify(mockReserva1).retPasajero();
		verify(mockReserva1.retPasajero()).imprimirPasajero();
	}
	
}

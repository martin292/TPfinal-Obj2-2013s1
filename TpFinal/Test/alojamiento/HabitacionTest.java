package alojamiento;

import reservas.Reserva;
import Fechas.PrecioRango;
import Fechas.Rango;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class HabitacionTest extends TestCase {

	Habitacion habitacion = new Habitacion();
	Rango mockRango1;
	Rango mockRango2;
	PrecioRango mockPrecioRango1;
	PrecioRango mockPrecioRango2;
	
	public void setUp(){
		
		mockRango1 = mock(Rango.class);
		mockRango2 = mock(Rango.class);
		mockPrecioRango1 = mock(PrecioRango.class);
		mockPrecioRango2 = mock(PrecioRango.class);
		
	}
	
	public void testAgregarRangoReservado(){
		habitacion.agregarRangoReservado(mockRango1);
		
		assertTrue("FALLA LA AGREGACION DE UN RANGO RESERVADO A LA HABITACION", habitacion.getDisponibilidad().contains(mockRango1));
	}
	
	public void testEliminarRangoReservado1(){
		
		when(mockRango1.esIgual(mockRango2)).thenReturn(true);
		
		habitacion.agregarRangoReservado(mockRango1);
		assertTrue("FALLA LA AGREGACION DE UN RANGO RESERVADO A LA HABITACION", habitacion.getDisponibilidad().contains(mockRango1));
		
		habitacion.eliminarRangoReservado(mockRango2);
		
		assertEquals(habitacion.getDisponibilidad().size(), 0);
		
		assertFalse("FALLA LA ELIMINACION DE UN RANGO RESERVADO A LA HABITACION", habitacion.getDisponibilidad().contains(mockRango1));

		
	}
	
	public void testEliminarRangoReservado2(){
		
		when(mockRango1.esIgual(mockRango2)).thenReturn(false);
		
		habitacion.agregarRangoReservado(mockRango1);
		assertTrue("FALLA LA AGREGACION DE UN RANGO RESERVADO A LA HABITACION", habitacion.getDisponibilidad().contains(mockRango1));
		
		habitacion.eliminarRangoReservado(mockRango2);
		
		assertEquals(habitacion.getDisponibilidad().size(), 1);
		
		assertTrue("NO SE DEBE ELIMINAR NADA", habitacion.getDisponibilidad().contains(mockRango1));

	}
	
	public void testAgregarReserva(){
		Reserva mockReserva = mock(Reserva.class);
		
		habitacion.agregarReserva(mockReserva);
		
		assertTrue("FALLA LA AGREGACION DE UNA RESERVA", habitacion.getReservas().contains(mockReserva));
		
	}
	
	public void testContieneRango(){
		
		when(mockPrecioRango1.esIgual(mockRango1)).thenReturn(true);
		when(mockPrecioRango1.esIgual(mockRango2)).thenReturn(false);
		
		habitacion.getPrecios().add(mockPrecioRango1);
		
		assertTrue(habitacion.contieneRango(mockRango1));
		assertFalse(habitacion.contieneRango(mockRango2));
	}
	
	public void testModificarCapacidad(){
		int capacidadNueva = 5;
		
		habitacion.modificarCapacidad(capacidadNueva);
		
		assertEquals("FALLA LA MODIFICACION DE LA CAPACIDAD DE LA HABITACION", capacidadNueva, habitacion.getCapacidad());
	}
	
	public void testModificarPrecio(){
		
	}
	
	public void testPrecioReal(){
		/*		
		Suponiendo que mockPrecioRango1 tiene los siguientes datos:
			fecha de inicio1 = 15/02/2013
			fecha de fin = 09/5/2013
			precio = 60
		y que mockPrecioRango2 los siguientes:
			fecha de inicio1 = 22/07/2013
			fecha de fin = 29/12/2013
			precio = 75
		
		entonces:
			Del 20/04/2013 al 09/05/2013 hay 20 días
			Del 10/05/2013 al 12/06/2013 hay 34 días
			por lo tango el precio esperado es  20*60 + 34*75 = 3750
		*/
		
		when(mockPrecioRango1.getPrecio()).thenReturn(60);
		when(mockPrecioRango2.getPrecio()).thenReturn(75);
		when(mockPrecioRango1.cantDiasQueIncluye(mockRango1)).thenReturn(20);		
		when(mockPrecioRango2.cantDiasQueIncluye(mockRango1)).thenReturn(34);
		
		habitacion.getPrecios().add(mockPrecioRango1);
		habitacion.getPrecios().add(mockPrecioRango2);		
		
		int precioEsperado = 3750;
		
		assertEquals("FALLA EL PRECIO RETORNADO", precioEsperado, habitacion.precioReal(mockRango1));
	}
	
}

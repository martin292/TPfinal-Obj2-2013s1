package descuento;

import java.util.Calendar;

import alojamiento.Habitacion;

import Fechas.Rango;
import static org.mockito.Mockito.*;
import descuentos.Descuento;
import junit.framework.TestCase;

public class DescuentoTest extends TestCase {

	Descuento descuento = new Descuento();
	
	
	
	public void testAgregarPorcentaje(){
		int porcentaje = 30;
		
		descuento.agregarPorcentaje(porcentaje);
		assertEquals(porcentaje, descuento.getPorcentaje());
	}
	
	public void testAgregarFechaLimite(){
		Calendar fechaLimite = Calendar.getInstance();
		fechaLimite.set(2013, 6, 7);
		descuento.agregarFechaLimite(fechaLimite);
		assertEquals(fechaLimite, descuento.getFechaLimite());
	}
	
	public void testAgregarRangoFecha(){
		Rango mockRango = mock(Rango.class);
		descuento.agregarRangoFecha(mockRango);
		assertEquals(mockRango, descuento.getRangoFecha());
	}
	
	public void testAgregarHabitacion(){
		Habitacion mockHabitacion = mock(Habitacion.class);
		descuento.agregarHabitacion(mockHabitacion);
		assertTrue(descuento.getHabitaciones().contains(mockHabitacion));
	}

	
	
}

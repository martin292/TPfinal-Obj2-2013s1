package ofertas;

import org.junit.Test;

import Fechas.Rango;
import alojamiento.Habitacion;
import alojamiento.Hotel;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;

public class OfertaTest extends TestCase {

	//Variables
	private Oferta o;
	
	//Getters y Setters
	private Oferta getO() {
		return o;
	}
	private void setO(Oferta o) {
		this.o = o;
	}


	//Tests
	public void testRetHabitacion(){
		
		Hotel h = mock(Hotel.class);
		Habitacion ha = mock(Habitacion.class);
		Rango r = mock(Rango.class);
		
		Oferta x = new Oferta(h, ha, r, 100);
		this.setO(x);
		
		assertEquals(this.getO().retHabitacion(),ha);
		
	}
	
	public void testRetRango(){
		
		Hotel h = mock(Hotel.class);
		Habitacion ha = mock(Habitacion.class);
		Rango r = mock(Rango.class);
		
		Oferta x = new Oferta(h, ha, r, 100);
		this.setO(x);
		
		assertEquals(this.getO().retRango(),r);
		
	}
	
	public void testRetHotel(){
		
		Hotel h = mock(Hotel.class);
		Habitacion ha = mock(Habitacion.class);
		Rango r = mock(Rango.class);
		
		Oferta x = new Oferta(h, ha, r, 100);
		this.setO(x);
		
		assertEquals(this.getO().retHotel(), h);
		
	}

	public void testRetPrecio(){
		
		Hotel h = mock(Hotel.class);
		Habitacion ha = mock(Habitacion.class);
		Rango r = mock(Rango.class);
		
		Oferta x = new Oferta(h, ha, r, 100);
		this.setO(x);
		
		assertEquals(this.getO().retPrecio(), 100);
		
	}
	
}

//Martin Ramos
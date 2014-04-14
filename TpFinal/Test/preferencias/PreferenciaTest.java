package preferencias;


import java.util.Calendar;

import ofertas.Oferta;

import org.junit.Test;

import alojamiento.Habitacion;
import alojamiento.Hotel;

import Fechas.Rango;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class PreferenciaTest extends TestCase {

	//Variables
	public Preferencia p;

	//Getters y Setters
	private Preferencia getP() {
		return p;
	}
	private void setP(Preferencia p) {
		this.p = p;
	}
	
	//SetUp
	public void setUp(){
		
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		a.set(2013,1,1);	
		b.set(2013,2,2);
		
		Rango r = new Rango(a, b);
		NoDetallado l = new NoDetallado("arg");
		EntreValores p = new EntreValores(100, 200);
		
		Preferencia x = new Preferencia(1, r, l, p);
		
		this.setP(x);
		
	}
	
	//Tests
	public void testCompararCapacidadCon(){
		
		Habitacion h = mock(Habitacion.class);
		when(h.retCapacidad()).thenReturn(1);
		
		assertTrue(this.getP().compararCapacidadCon(h));		
	}
	
	public void testCompararRangoCon(){
		
		Rango r = mock(Rango.class);
		
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();		
		a.set(2013,1,1);
		b.set(2013,2,2);
		
		when(r.getFechaInicio()).thenReturn(a);
		when(r.getFechaFin()).thenReturn(b);
		
		//assertTrue(this.getP().compararRangoCon(r));		
	}
	
	public void testCompararLugarCon(){
		Hotel ho = mock(Hotel.class);
		when(ho.retPais()).thenReturn("arg");
		
		assertTrue(this.getP().compararLugarCon(ho));
	}
	
	public void testCompararPrecioCon(){
		assertTrue(this.getP().compararPrecioCon(150));
	}
	
	public void testCompararCon(){
		
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		a.set(2013,1,1);	
		b.set(2013,2,2);
		
		Oferta o = mock(Oferta.class);
		
		Habitacion h = mock(Habitacion.class);
		Hotel ho = mock(Hotel.class);
		Rango r = mock(Rango.class);
		
		when(o.retHabitacion()).thenReturn(h);
		when(o.retHotel()).thenReturn(ho);
		when(o.retRango()).thenReturn(r);
		when(o.retPrecio()).thenReturn(150);
		
		when(h.retCapacidad()).thenReturn(1);
		when(ho.retPais()).thenReturn("arg");
		when(r.getFechaInicio()).thenReturn(a);
		when(r.getFechaFin()).thenReturn(b);
		
		assertTrue(this.getP().compararCon(o));		
	}	

}


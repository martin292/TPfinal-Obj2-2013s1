package alojamiento;

import usuarios.Pasajero;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class CalificacionTest extends TestCase {

Calificacion calificacion = new Calificacion();
	
	
	public void testAgregarComentario(){
		String comentario = "Este es un comentario";
		
		calificacion.agregarComentario(comentario);
		
		assertEquals(comentario, calificacion.getComentario());
	}

	public void testAgregarPuntaje1() throws PuntajeFueraDeRango{
		int puntaje = 7;
		calificacion.agregarPuntaje(puntaje);
		
		assertEquals(puntaje, calificacion.getPuntaje());
	}
	
	public void testAgregarPuntaje2(){
		
		try {
			calificacion.agregarPuntaje(0);
			fail();
		} catch (PuntajeFueraDeRango e) {
		}
		
		try {
			calificacion.agregarPuntaje(11);
			fail();
		} catch (PuntajeFueraDeRango e) {
		}
	}
	
	public void testAgregarPasajero(){
		Pasajero mockPasajero = mock(Pasajero.class);
		calificacion.agregarPasajero(mockPasajero);
		
		assertEquals(mockPasajero, calificacion.getPasajero());
		
	}
	
}

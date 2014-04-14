package reservas;


import org.junit.Test;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;

public class ConcretadoTest extends TestCase {

	public Concretado c = new Concretado();
	
	@Test
	public void testCancelar() {
		
		Reserva r = mock(Reserva.class);
		
		c.cancelar(r);
		
	}

}

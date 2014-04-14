package reservas;

public class Concretado extends EstadoReserva {

	
	@Override//Crea una instancia de cancelado y se lo agrega a la reserva
	void cancelar(Reserva r) {
		Cancelado c = new Cancelado();
		System.out.println("La reserva fue cancelada");
		r.cambiarEstado(c);		
	}

	@Override//Imprime el estado en consola
	public void imprimirEstado() {
		System.out.println("Reserva concretada");		
	}


}

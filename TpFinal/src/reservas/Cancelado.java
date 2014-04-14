package reservas;

public class Cancelado extends EstadoReserva {

	void cancelar(Reserva r){
		//No hace nada
	}

	@Override//Imprime el estado en consola
	public void imprimirEstado() {
		System.out.println("Reserva cancelada");		
	}	
	

}

package subastas;

import usuarios.Pasajero;

public abstract class EstadoSubasta {

	public abstract void recibirOferta(Subasta subasta, Pasajero pasajero, int cantOferta) throws OfertaMinimaException, SubastaFinalizadaException, SubastaEnPromocionException;

	public abstract void superarOfertaActual(Subasta subasta, Pasajero pasajero) throws SubastaFinalizadaException, SubastaEnPromocionException;

	
	
	
	
	public abstract void actualizarEstado(Subasta subasta);

}

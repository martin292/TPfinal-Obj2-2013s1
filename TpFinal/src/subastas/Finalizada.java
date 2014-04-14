package subastas;

import java.util.Calendar;

import usuarios.Pasajero;

public class Finalizada extends EstadoSubasta {

	@Override
	public void recibirOferta(Subasta subasta, Pasajero pasajero, int cantOferta) throws SubastaFinalizadaException {
		
		throw new SubastaFinalizadaException("Esta subasta ya finalizo.");
		
	}

	@Override
	public void superarOfertaActual(Subasta subasta, Pasajero pasajero) throws SubastaFinalizadaException {
		
		throw new SubastaFinalizadaException("Esta subasta ya finalizo.");
	}
	
	@Override
	public void actualizarEstado(Subasta subasta) {
		
		Calendar fechaActual = Calendar.getInstance();
		
		if(subasta.getPeriodoActivo().incluyeA(fechaActual)){
			Activa activa = new Activa();
			subasta.setEstado(activa);
		}
		else{
			if(fechaActual.before(subasta.getPeriodoActivo().getFechaInicio())){
				EnPromocion enPromocion = new EnPromocion();
				subasta.setEstado(enPromocion);
			}
		}
	}
	
	
}

package subastas;

import java.util.Calendar;

import usuarios.Pasajero;

public class Activa extends EstadoSubasta {

	@Override
	public void recibirOferta(Subasta subasta, Pasajero pasajero, int cantOferta) throws OfertaMinimaException {
		
		if(cantOferta >= subasta.getOfertaActual()){
			subasta.setOfertaActual(cantOferta);
			subasta.setGanador(pasajero);
		}
		else{
			throw new OfertaMinimaException("La oferta minima es" + subasta.getOfertaActual());
		}
		
	}
	
	@Override
	public void superarOfertaActual(Subasta subasta, Pasajero pasajero) {
		
			subasta.setGanador(pasajero);
			subasta.setOfertaActual(subasta.getOfertaActual() + 1);
	}

	@Override
	public void actualizarEstado(Subasta subasta) {
		
		Calendar fechaActual = Calendar.getInstance();
		
		if(fechaActual.before(subasta.getPeriodoActivo().getFechaInicio())){
			EnPromocion enPromocion = new EnPromocion();
			subasta.setEstado(enPromocion);
		}
		else{
			if(fechaActual.after(subasta.getPeriodoActivo().getFechaFin())){
				Finalizada finalizada = new Finalizada();
				subasta.setEstado(finalizada);
			}
		}
	}

	
}

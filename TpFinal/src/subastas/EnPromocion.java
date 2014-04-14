package subastas;

import java.util.Calendar;

import usuarios.Pasajero;

public class EnPromocion extends EstadoSubasta {

	@Override
	public void recibirOferta(Subasta subasta, Pasajero pasajero, int cantOferta) throws SubastaEnPromocionException {
		
		throw new SubastaEnPromocionException("Esta subasta todavia no esta activa");
	}

	@Override
	public void superarOfertaActual(Subasta subasta, Pasajero pasajero) throws SubastaEnPromocionException {
		
		throw new SubastaEnPromocionException("Esta subasta todavia no esta activa");
	}
	
	@Override
	public void actualizarEstado(Subasta subasta) {
		
		Calendar fechaActual = Calendar.getInstance();
		if(subasta.getPeriodoActivo().incluyeA(fechaActual)){
			Activa activa = new Activa();
			subasta.setEstado(activa);
		}
		else{
			if(fechaActual.after(subasta.getPeriodoActivo().getFechaFin())){
				Finalizada finalizada = new Finalizada();
				subasta.setEstado(finalizada);
			}
		}
	}

	
	
}

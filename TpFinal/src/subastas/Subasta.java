package subastas;

import java.util.Calendar;

import ofertas.Oferta;

import Fechas.Rango;

import usuarios.Pasajero;

public class Subasta {

	private Rango periodoActivo;   //Período en el que la subasta se encuentra activa.
	//private int precioInicial;     //Precio minimo que puede ofertar un pasajero.
	private int ofertaActual;	   //Oferta ganadora hasta el momento.
	private EstadoSubasta estado;  //Estado actual de la subasta.
	private Pasajero ganador;	   //Pasajero ganador final o momentáneo (depende del estado).
	private Oferta oferta;       //Es el premio de la subasta (lo que ofrece la subasta).
	
	
	/**
	 * Constructores
	 */
	public Subasta(){
		super();
	}
	public Subasta(Rango periodoActivo, EstadoSubasta estado, int precioInicial) {
		super();
		this.setOfertaActual(0);
		this.setPeriodoActivo(periodoActivo);
		this.setEstado(estado);
		//this.setPrecioInicial(precioInicial);
	}
	public Subasta(Rango rango, int precio, Oferta oferta){
		super();
		this.periodoActivo = rango;
		this.ofertaActual = precio;
		this.oferta = oferta;
		this.estado = new EnPromocion();
	}
	public Subasta(Rango periodoActivo, EstadoSubasta estado, Oferta oferta, int precioInicial) {
		super();
		this.periodoActivo = periodoActivo;
		this.estado = estado;
		this.oferta = oferta;
		this.ofertaActual = precioInicial;
	}
	

	/**
	 * Getters and setters
	 */
	public Rango getPeriodoActivo() {
		return periodoActivo;
	}
	public void setPeriodoActivo(Rango periodoActivo) {
		this.periodoActivo = periodoActivo;
	}
	public int getOfertaActual() {
		return ofertaActual;
	}
	public void setOfertaActual(int ofertaActual) {
		this.ofertaActual = ofertaActual;
	}
	public EstadoSubasta getEstado() {
		return estado;
	}
	public void setEstado(EstadoSubasta estado) {
		this.estado = estado;
	}	
	
	/*
	public int getPrecioInicial() {
		return precioInicial;
	}
	public void setPrecioInicial(int precioInicial) {
		this.precioInicial = precioInicial;
	}
	*/
	
	public Pasajero getGanador() {
		return ganador;
	}
	public void setGanador(Pasajero ganador) {
		this.ganador = ganador;
	}
	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	
	
	
	/**
	 * Actualiza el estado verificando la fecha actual con las fechas del rango de la subasta.
	 */
	public void actualizarEstado() {
		
		this.getEstado().actualizarEstado(this);
	}

	/**
	 * Agrega una oferta (en pesos)	del pasajero dado por parametro.
	 * @param pasajero
	 * @param cantOferta
	 */
	public void recibirOfertaDe(Pasajero pasajero, int cantOferta) {
		
		try {
			this.getEstado().recibirOferta(this, pasajero, cantOferta);
			
		} catch (OfertaMinimaException e) {
			System.out.println(e.getMessage());
			
		} catch (SubastaFinalizadaException e) {
			System.out.println(e.getMessage());
			
		} catch (SubastaEnPromocionException e) {
			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * Supera la oferta actual por un peso y el pasajero dado por parametro pasa a ser el ganador momentáneo
	 * @param pasajero
	 * @param i
	 */
	public void superarOfertaActual(Pasajero pasajero) {
		
		try {
			
			this.getEstado().superarOfertaActual(this, pasajero);
			
		} catch (SubastaFinalizadaException e) {
			
			System.out.println(e.getMessage());
			
		} catch (SubastaEnPromocionException e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Imprime informacion sobre la subasta.
	 */
	public void imprimirInfo() {
		System.out.println("Inicia el: " + this.getPeriodoActivo().getFechaInicio());
		System.out.println("Finaliza el: " + this.getPeriodoActivo().getFechaFin());
		System.out.println("Oferta actual: "+ this.getOfertaActual());
		System.out.println("Estado:"+ this.getEstado().getClass().getName());
	}
	
	
	
}

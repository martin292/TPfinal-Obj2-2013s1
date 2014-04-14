package alojamiento;

import java.util.ArrayList;
import java.util.Iterator;

import reservas.Reserva;
import servicios.DeHabitacion;
import subastas.Subasta;

import Fechas.PrecioRango;
import Fechas.Rango;

public class Habitacion {

	private int numero;
	private int capacidad;
	private Hotel hotel;
	private ArrayList<DeHabitacion> servicios = new ArrayList<DeHabitacion>();
	private ArrayList<Rango> disponibilidad = new ArrayList<Rango>();
	private ArrayList<PrecioRango> precios = new ArrayList<PrecioRango>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	
	
	//Constructores
	public Habitacion(int nro, int capacidad2) {
		super();
		this.numero = nro;
		this.capacidad = capacidad;
	}
	public Habitacion(int nro, int capacidad2, Hotel h) {
		super();
		this.numero = nro;
		this.capacidad = capacidad;
		this.hotel = hotel;
	}
	public Habitacion() {
		super();
	}

	//Getters y Setters
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public ArrayList<DeHabitacion> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<DeHabitacion> servicios) {
		this.servicios = servicios;
	}

	public ArrayList<PrecioRango> getPrecios() {
		return precios;
	}

	public void setPrecios(ArrayList<PrecioRango> precios) {
		this.precios = precios;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void setDisponibilidad(ArrayList<Rango> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;		
	}
	public void setNumero(int i) {
		this.numero = i;		
	}
	public ArrayList<Rango> getDisponibilidad() {
		return this.disponibilidad;
	}
	public int getCapacidad() {
		return this.capacidad;
	}


	public int getNumero() {
		return this.numero;
	}
	
	
	//Metodos---------------------------------------------------------------------
	
	/**
	 * retorna la capacidad
	 * @return int
	 */		
	public int retCapacidad() {
		return this.capacidad;
	}
	
	public void agregarDisponibilidad(Rango disponibilidad) {
		this.getDisponibilidad().add(disponibilidad);		
	}

	public void eliminarDisponibilidad(Rango disponibilidad) {
		
		Iterator<Rango> iter = this.getDisponibilidad().iterator();
		while(iter.hasNext()) {
		  Rango r = iter.next();
		  if(r.esIgual(disponibilidad)) {
		    iter.remove();
		  }
		}
		
		/*
		for(Rango r : this.getRangosReservados()){
			if(r.esIgual(disponibilidad)){
				this.getRangosReservados().remove(r);
			}
		}*/
		
	}

	/**
	 * Retorna la disponibilidad
	 * @return ArrayList<Rango>
	 */
	public ArrayList<Rango> retDisponibilidad() {
		return this.getDisponibilidad();
	}

	/**
	 * Imprime la habitacion
	 */
	public void imprimirHabitacion() {
		System.out.println("Numero: " + this.getNumero());
		System.out.println("Capacidad: " + this.getCapacidad());
		System.out.println("...");
	}

	/**
	 * Agrega un rango a la coleccion de rangos reservados de la habitacion.
	 * @param disponibilidad
	 */
	public void agregarRangoReservado(Rango disponibilidad) {
		 
		this.getDisponibilidad().add(disponibilidad);
	}
	
	/**
	 * Elimina un rango reservado de la coleccion siempre que este se encuentre en la misma.
	 * @param disponibilidad
	 */
	public void eliminarRangoReservado(Rango rango) {
		
		Iterator<Rango> iter = this.getDisponibilidad().iterator();
		while(iter.hasNext()) {
		  Rango r = iter.next();
		  if(r.esIgual(rango)) {
		    iter.remove();
		  }
		}
		
		/*
		for(Rango r : this.getRangosReservados()){
			if(r.esIgual(rango)){
				this.getRangosReservados().remove(r);
			}
		}*/
	}
	
	/**
	 * Agrega una reserva a la lista de reservas de la habitacion.
	 * @param reserva
	 */
	public void agregarReserva(Reserva reserva){
		this.getReservas().add(reserva);
	}
	
	/**
	 * Busca en la lista de PrecioRango de la habitacion si el rango pasado por parametro se encuentra.
	 * Compara los rangos solo por fecha de inicio y fin, obviando el precio.
	 * @param rango
	 * @return
	 */
	public boolean contieneRango(Rango rango){
		
		for(PrecioRango p : this.getPrecios()){
			if(p.esIgual(rango)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Modifica la capacidad de la habitacion.
	 * @param capacidad
	 */
	public void modificarCapacidad(int capacidad){
		this.setCapacidad(capacidad);
	}
	
	/**
	 * Agrega un PrecioRango a la coleccion y modifica otros ya existentes si es necesario.
	 * @param precioRango
	 */
	public void modificarPrecio(PrecioRango precioRango) {
		
		if(this.contieneRango(precioRango)){
			for(PrecioRango p : this.getPrecios()){
				if(p.esIgual(precioRango)){
					p.setPrecio(precioRango.getPrecio());
				}
			}
		}
		else{
			for(PrecioRango p : this.getPrecios()){
				
				if(p.incluyeA(precioRango.getFechaInicio())){
					p.modificarRangoA(precioRango.getFechaInicio());
				}
				else{
					if(p.incluyeA(precioRango.getFechaFin())){
						p.modificarRangoB(precioRango.getFechaFin());		
					}
				}
			}
			this.getPrecios().add(precioRango);
		}		
	}
	
	/**
	 * Retorna el precio real en un determinado rango, dado por parametro.
	 * @param rango
	 * @return
	 */
	public int precioReal(Rango rango) {
		int ret = 0;
		for(PrecioRango p : this.getPrecios()){
			ret = ret + (p.cantDiasQueIncluye(rango) * p.getPrecio());
		}
		
		return ret;
	}

	public Hotel retHotel() {
		return this.getHotel();
	}
	public boolean libreEn(Rango rango) {		
		return rango.estaEn(this.getDisponibilidad());
	}
	
	
	

}

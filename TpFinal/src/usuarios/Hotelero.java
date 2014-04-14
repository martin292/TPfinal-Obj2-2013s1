package usuarios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ofertas.Oferta;

import descuentos.Descuento;

import reservas.Reserva;
import subastas.Subasta;

import Fechas.PrecioRango;
import Fechas.Rango;
import alojamiento.Habitacion;
import alojamiento.Hotel;

public class Hotelero extends Usuario {

	//Variables
	private ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
	
	//Constructor
	public Hotelero(String nom, String ap, String e, String us, String c) {
		super(nom, ap, e, us, c);
	}
	public Hotelero(){ super();}

	public Hotelero(String nom, String ap, String e) {
		super(nom, ap, e);
	}
	
	
	//Getters y Setters
	public ArrayList<Hotel> getHoteles() {
		return hoteles;
	}

	private void setHoteles(Hotel h) {
		this.hoteles.add(h);
	}
	
	//Metodos
			
	public boolean buscar(Hotel h){
		return this.getHoteles().contains(h);
	}
	
	public ArrayList<Hotel> retHoteles(){
		return this.getHoteles();
	}
	
	/**
	 * Agrega un hotel a su lista de hoteles y la del portal.
	 * @param hotel
	 */
	public void agregarHotel(Hotel hotel){
		this.getHoteles().add(hotel);
		this.getPortal().agregarHotel(hotel);
	}
	
	/**
	 * Retorna todas las reservas actuales de todos los hoteles.
	 * @return
	 */
	public List<Reserva> reservasActuales(){
		List<Reserva> reservas = new ArrayList<Reserva>();
		for(Hotel h : this.getHoteles()){
			reservas.addAll(h.reservasActuales());
		}
		
		return reservas;
	}
	
	/**
	 * Retorna todas las reservas futuras de todos los hoteles, osea aquellas que tienen fecha de inicio posterior a la fecha actual.
	 * @return
	 */
	public List<Reserva> reservasFuturas(){
		List<Reserva> reservas = new ArrayList<Reserva>();
		for(Hotel h : this.getHoteles()){
			reservas.addAll(h.reservasFuturas());
		}
		
		return reservas;
	}
	
	/**
	 * Retorna todas las reservas de todos los hoteles que inicien en 'n' días.
	 * @param cantDias
	 * @return
	 */
	public List<Reserva> reservasQueInicianEn(int cantDias){
		List<Reserva> reservas = new ArrayList<Reserva>();
		for(Hotel h : this.getHoteles()){
			reservas.addAll(h.reservasQueInicianEn(cantDias));
		}
		
		return reservas;
	}
	
	/**
	 * Retorna las reservas actuales del hotel pasado por parametro.
	 * @param hotel
	 * @return
	 */
	public List<Reserva> reservasActuales(Hotel hotel){
		return hotel.reservasActuales();
	}
	
	/**
	 * Retorna las reservas futuras del hotel pasado por parametro.
	 * @param hotel
	 * @return
	 */
	public List<Reserva> reservasFuturas(Hotel hotel){
		return hotel.reservasFuturas();
	}
	
	/**
	 * Retorna las reservas del hotel pasado por parametro que inician en 'n' días.
	 * @param hotel
	 * @param cantDias
	 * @return
	 */
	public List<Reserva> reservasQueInicianEn(Hotel hotel, int cantDias){
		return hotel.reservasQueInicianEn(cantDias);
	}
	
	/**
	 * Crea un descuento y lo retorna.
	 * @param habitacion
	 * @param porcentaje
	 * @param fechaLimite
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public Descuento crearDescuento(Habitacion habitacion, int porcentaje, Calendar fechaLimite, Calendar fechaInicio, Calendar fechaFin){
		return new Descuento(habitacion, porcentaje, fechaLimite, fechaInicio, fechaFin);
	}
	
	/**
	 * Crea un hotel y lo retorna.
	 * @param nombre
	 * @param pais
	 * @param ciudad
	 * @param direccion
	 * @param email
	 * @param telefono
	 * @param checkIn
	 * @param checkOut
	 * @return
	 */
	public Hotel crearHotel(String nombre, String pais, String ciudad, String direccion, String email, int telefono, Calendar checkIn, Calendar checkOut){
		return new Hotel(nombre, pais, ciudad, direccion, email, telefono, checkIn, checkOut);
	}
	
	/**
	 * Crea una habitacion y la retorna.
	 * @param nro
	 * @param capacidad
	 * @return
	 */
	public Habitacion crearHabitacion(int nro, int capacidad){
		return new Habitacion(nro, capacidad);
	}
	
	/**
	 * Crea una oferta y la retorna.
	 * @param hotel
	 * @return
	 */
	public Oferta crearOferta(Hotel hotel, Habitacion habitacion, Rango rango, int precio){
		return new Oferta(hotel, habitacion, rango, precio);
	}
	
	/**
	 * Crea una subasta y la retorna.
	 * @param rango
	 * @param precio
	 * @param oferta
	 * @return
	 */
	public Subasta crearSubasta(Rango rango, int precio, Oferta oferta){//xxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		return new Subasta(rango, precio, oferta);
	}
	
	/**
	 * Agrega un descuento al hotel pasado por parametro.
	 * @param hotel
	 * @param descuento
	 */
	public void cargarDescuento(Hotel hotel, Descuento descuento){
		hotel.agregarDescuento(descuento);
	}
	
	/**
	 * Agrega una habitación al hotel pasado por parametro.
	 * @param hotel
	 * @param habitacion
	 */
	public void agregarHabitacion(Hotel hotel, Habitacion habitacion){
		hotel.agregarHabitacion(habitacion);
	}
	
	/**
	 * Agrega varias habitaciones al hotel pasado por parametro.
	 * @param hotel
	 * @param habitacion
	 */
	public void agregarHabitacion(Hotel hotel, ArrayList<Habitacion> habitaciones){
		hotel.agregarHabitaciones(habitaciones);
	}
	
	/**
	 * Modifica el precio de una habitacion.
	 * @param habitacion
	 * @param precioRango
	 */
	public void modificarPrecio(Habitacion habitacion, PrecioRango precioRango){
		habitacion.modificarPrecio(precioRango);
	}
	
	/**
	 * Modifica la disponibilidad de la habitacion pasada por parametro.
	 * @param habitacion
	 * @param rango
	 */
	public void modificarDisponibilidad(Habitacion habitacion, Rango rango){
		habitacion.agregarRangoReservado(rango);
	}
	
	/**
	 * Imprime la informacion del pasajero que realizo la reserva pasada por parametro.
	 * @param reserva
	 */
	public void visualizarDatosDelUsuario(Reserva reserva){
		reserva.retPasajero().imprimirPasajero();
	}
	
	/**
	 * Agrega la oferta al aviso
	 * @param o
	 */
	public void agregarOfertaAlAviso(Oferta o){
		this.getPortal().agregarOfertaAlAviso(o);
	}
	
	
}

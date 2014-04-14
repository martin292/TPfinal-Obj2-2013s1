package alojamiento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import descuentos.Descuento;

import reservas.Reserva;
import servicios.DeHotel;
import subastas.Subasta;

import Fechas.Rango;
import FormasDePago.Tarjeta;

public class Hotel {

	//Variables
	private String nombre;
	private String pais;
	private String ciudad;
	private String direccion;
	private int telefono;
	private String email;
	private int categoria;
	private Calendar checkIn;
	private Calendar checkOut;	
	List<Habitacion> habitaciones = new ArrayList<Habitacion>();
	List<String> tarjetas = new ArrayList<String>();
	List<DeHotel> serviciosDeHotel = new ArrayList<DeHotel>();
	List<Calificacion> calificaciones = new ArrayList<Calificacion>();
	List<Reserva> reservas = new ArrayList<Reserva>();
	List<Descuento> descuentos = new ArrayList<Descuento>();
	private ArrayList<Subasta> subastas = new ArrayList<Subasta>();
	
	
	//Constructores
	public Hotel(String nombre2, String pais2, String ciudad2,
			String direccion2, String email2, int telefono2, Calendar checkIn2,
			Calendar checkOut2) {
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.checkIn = checkIn;
		this.checkOut = checkOut;		
	}

	public Hotel() {
		super();
	}

	/**
	 * Getters and setters
	 */	
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public Calendar getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Calendar checkIn) {
		this.checkIn = checkIn;
	}

	public Calendar getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Calendar checkOut) {
		this.checkOut = checkOut;
	}
	
	
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<String> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<String> tarjetas) {
		this.tarjetas = tarjetas;
	}		
	
	public List<DeHotel> getServiciosDeHotel() {
		return serviciosDeHotel;
	}

	public void setServiciosDeHotel(List<DeHotel> serviciosDeHotel) {
		this.serviciosDeHotel = serviciosDeHotel;
	}
	
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}	
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Descuento> getDescuentos() {
		return descuentos;
	}

	public void setDescuento(List<Descuento> descuentos) {
		this.descuentos = descuentos;
	}
	
	public ArrayList<Subasta> getSubastas() {
		return this.subastas;
	}
	
	//Metodos-----------------------------------------------------------------------------------------------------------
	
	/**
	 * Retorna el pais
	 */	
	public String retPais() {
		return this.getPais();
	}
	
	/**
	 * Retorna la ciudad
	 */
	public String retCiudad() {
		return this.getCiudad();
	}
	
	/**
	 * Agrega una habitacion a la coleccion de habitaciones.
	 * @param habitacion
	 */
	public void agregarHabitacion(Habitacion habitacion) {
		this.getHabitaciones().add(habitacion);
	}

	/**
	 * Agrega una tarjeta a la coleccion de tarjetas.
	 * @param tarjeta
	 */
	public void agregarTarjeta(String tarjeta) {
		this.getTarjetas().add(tarjeta);
	}
	
	/**
	 * Agrega un servicio de hotel a la coleccion de ser.
	 * @param tarjeta
	 */
	public void agregarServicioDeHotel(DeHotel servicioDeHotel) {
		this.getServiciosDeHotel().add(servicioDeHotel);
	}
	
	/**
	 * Agrega una coleccion de servicios al hotel.
	 * @param servicios
	 */
	public void agregarServiciosDeHotel(List<DeHotel> serviciosDeHotel) {
		this.setServiciosDeHotel(serviciosDeHotel);
	}
	
	/**
	 * Agrega una calificacion al hotel.
	 * @param calificacion
	 */
	public void agregarCalificacion(Calificacion calificacion) {
		this.getCalificaciones().add(calificacion);
	}

	/**
	 * Agrega una reserva al hotel.
	 * @param reserva
	 */
	public void agregarReserva(Reserva reserva) {
		this.getReservas().add(reserva);
	}
	
	/**
	 * Agrega un descuento al hotel.
	 * @param descuento
	 */
	public void agregarDescuento(Descuento descuento){
		this.getDescuentos().add(descuento);
	}
	
	/**
	 * Retorna el promedio de los puntajes dejados por los pasajeros.
	 * Retorna cero si no hay puntajes.
	 * @return
	 */
	public double puntajePromedio() {
		
		double ret = 0;
		
		if(this.getCalificaciones().size() <= 0){
			return ret;
		}
		else{
			for(Calificacion c : this.getCalificaciones()){
				ret = ret + c.getPuntaje();
			}
			return ret / this.getCalificaciones().size();
		}
	}
	
	/**
	 * Dada una habitacion y una capacidad por parametro, si ésta está en la coleccion del hotel le modifica
	 * la capacidad con la dada.
	 * @param habitacion
	 * @param capacidad
	 */
	public void modificarCapacidad(Habitacion habitacion, int capacidad){
		
		for(Habitacion h : this.getHabitaciones()){
			if(h.equals(habitacion)){
				h.setCapacidad(capacidad);
				break;
			}
		}
	}
	
	/**
	 * Agrega una disponibilidad a la habitacion del hotel, si es que la habitacion
	 * se encuentra en el hotel.
	 * @param habitacion
	 * @param disponibilidad
	 */
	public void agregarDisponibilidad(Habitacion habitacion, Rango disponibilidad){
		
		for(Habitacion h : this.getHabitaciones()){
			if(h.equals(habitacion)){
				h.agregarDisponibilidad(disponibilidad);
				break;
			}
		}
	}
	
	/**
	 * Elimina una disponibilidad a la habitacion del hotel, si es que la habitacion 
	 * se encuentra en el hotel.
	 * @param habitacion
	 * @param disponibilidad
	 */
	public void eliminarDisponibilidad(Habitacion habitacion, Rango disponibilidad){
		
		for(Habitacion h : this.getHabitaciones()){
			if(h.equals(habitacion)){
				h.eliminarDisponibilidad(disponibilidad);
			}
		}
	}

	
	
	/**
	 * retorna las habitaciones libres en un rango (inicio, fin) y con una capacidad (cant)
	 * @param inicio
	 * @param fin
	 * @param cant
	 * 
	 * @return ArrayList<Habitacion>
	 */	
	public ArrayList<Habitacion> habitacionesLibresEn(Calendar inicio, Calendar fin, int cant) {
		
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();		
		Rango r = new Rango(inicio, fin);
		
		for(Habitacion h: this.retHabitacionesConCapacidad(cant)){
			if(r.noExisteEn(h.retDisponibilidad())){
				ret.add(h);
			}
		}
		return ret;
	}
	
	
	/**
	 * retorna una coleccion con las habitaciones quetienen la capacidad = a cant
	 * @param cant
	 * @return ArrayList<Habitacion>
	 */
	public ArrayList<Habitacion> retHabitacionesConCapacidad(int cant) {
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		
		for(Habitacion h: this.getHabitaciones()){
			if(h.getCapacidad() == cant){
				ret.add(h);
			}
		}
		
		return ret;
	}

	/**
	 * Imprime en consola los datos del hotel
	 */	
	public void imprimirHotel() {
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Pais: " + this.getPais());
		System.out.println("Ciudad: " + this.getCiudad());
		System.out.println("Direccion: " + this.getDireccion());
		System.out.println("Telefono: " + this.getTelefono());
		System.out.println("eMail: " + this.getEmail());
		System.out.println("Categoria: " + this.getCategoria() + " estrellas");
		System.out.println("...");
	}

	
	/**
	 * Imprime en consola los descuentos
	 */	
	public void imprimirDescuentos() {
		
		for(Descuento d: this.getDescuentos()){
			d.imprimirDescuento();
		}
		
	}

	/**
	 * Retorna todas las reservas futuras, osea todas aquellas que todavia no iniciaron.
	 * @return
	 */
	public List<Reserva> reservasFuturas() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		for(Reserva r : this.getReservas()){
			if(r.esFutura()){
				reservas.add(r);
			}
		}
		return reservas;
	}
	
	
	/**
	 * 
	 */	
	public void agregarHabitaciones(ArrayList<Habitacion> habitaciones2) {
		this.getHabitaciones().addAll(habitaciones2);		
	}

	/**
	 * Retorna las habitaciones libres en un rango
	 * @param r
	 * @return
	 */
	public ArrayList<Habitacion> retHabitacionesLibresEn(Rango r) {
		
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		
		for(Habitacion h: this.getHabitaciones()){
			if(h.libreEn(r)){
				ret.add(h);
			}
		}
		
		return ret;
	}

	/**
	 * Retorna todas las reservas que inician en 'n' días.
	 * @param cantDias
	 * @return
	 */
	public List<Reserva> reservasQueInicianEn(int cantDias) {
		List<Reserva> reservas = new ArrayList<Reserva>();
		for(Reserva r : this.getReservas()){
			if(r.cantDiasParaIniciar() == cantDias){
				reservas.add(r);
			}
		}
		return reservas;
	}
	
	/**
	 * Retorna todas las reservas actuales del hotel.
	 * @return
	 */
	public List<Reserva> reservasActuales() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		for(Reserva r : this.getReservas()){
			if(r.esActual()){
				reservas.add(r);
			}
		}
		return reservas;
	}

	/**
	 * Retorna true si el nom de la tarjeta pasado por parametro existe en la coleccion de Tarjetas
	 * @param t
	 * @return
	 */
	public boolean aceptaTarjeta(String t) {
		return this.getTarjetas().contains(t);
	}
	
	
}

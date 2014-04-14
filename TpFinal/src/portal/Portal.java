package portal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import descuentos.Descuento;

import ofertas.AvisoDeOferta;
import ofertas.Oferta;
import preferencias.Detallado;
import preferencias.EntreValores;
import preferencias.MayorQue;
import preferencias.MenorQue;
import preferencias.NoDetallado;
import preferencias.Precio;
import preferencias.Preferencia;
import preferencias.TotalEstadia;

import reservas.Reserva;
import servicios.DeHabitacion;
import servicios.DeHotel;
import servicios.Servicio;
import subastas.Subasta;

import Fechas.PrecioRango;
import Fechas.Rango;
import FormasDePago.FormaDePago;
import FormasDePago.Tarjeta;
import alojamiento.Calificacion;
import alojamiento.Habitacion;
import alojamiento.Hotel;

import usuarios.Hotelero;
import usuarios.Pasajero;
import usuarios.Usuario;


public class Portal {

	//Variables
	private AvisoDeOferta aviso;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<Servicio> serviciosComunes = new ArrayList<Servicio>();
	private ArrayList<Subasta> subastas = new ArrayList<Subasta>();
	
	
	//Getters y Setters
	/*
	private Usuario getUsuarioLogeado(){
		return usuarioLogeado;
	}
	private void setUsuarioLogeado(Usuario u){
		this.usuarioLogeado = u;
	}
	*/
	
	private AvisoDeOferta getAviso() {
		return aviso;
	}	
	public void setAviso(AvisoDeOferta aviso) {
		this.aviso = aviso;
	}
	private ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	private void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	private ArrayList<Hotel> getHoteles() {
		return hoteles;
	}
	private void setHoteles(ArrayList<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	private ArrayList<Reserva> getReservas() {
		return reservas;
	}
	private void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	private ArrayList<Servicio> getServiciosComunes() {
		return serviciosComunes;
	}
	private void setServiciosComunes(ArrayList<Servicio> serviciosComunes) {
		this.serviciosComunes = serviciosComunes;
	}
	private ArrayList<Subasta> getSubastas() {
		return subastas;
	}
	private void setSubastas(ArrayList<Subasta> subastas) {
		this.subastas = subastas;
	}
	
	
	
	//Metodos
		
	/**
	 * Retorna una coleccion de las habitaciones	
	 * @param pais
	 * @param ciudad
	 * @param inicio
	 * @param fin
	 * @param cant
	 * @return
	 */
	public ArrayList<Habitacion> buscarAlojamiento(String pais, String ciudad, Calendar inicio, Calendar fin, int cant){
		
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		Rango r = new Rango(inicio,fin);
		
		for(Hotel h: this.hotelesEn(pais, ciudad)){
			ret.addAll(h.retHabitacionesLibresEn(r));
		}
		
		return ret;
	}
	
	/**
	 * Retorna una lista con los hoteles en (pais, ciudad)
	 * @param pais
	 * @param ciudad
	 * @return
	 */
	public ArrayList<Hotel> hotelesEn(String pais, String ciudad) {
		
		ArrayList<Hotel> ret = new ArrayList<Hotel>();
		
		for(Hotel h: this.getHoteles()){
			if(h.getPais() == pais && h.getCiudad() == ciudad){
				ret.add(h);
			}
		}
		
		return ret;
	}
	
	/**
	 * Igual al otro, pero busca los hoteles por nombre
	 * @param nombre
	 * @param inicio
	 * @param fin
	 * @param cant
	 * @return
	 */
	public ArrayList<Habitacion> buscarAlojamiento(String nombre, Calendar inicio, Calendar fin, int cant){
		
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		Rango r = new Rango(inicio,fin);
		
		for(Hotel h: this.retHotelesConNombre(nombre)){
			ret.addAll(h.retHabitacionesLibresEn(r));				
		}
		return ret;
	}
	
	/**
	 * Retorna una lista de hoteles con el nombre que se paso por parametro
	 * @param nombre
	 * @return
	 */
	public ArrayList<Hotel> retHotelesConNombre(String nombre) {
		
		ArrayList<Hotel> ret = new ArrayList<Hotel>();
		
		for(Hotel h: this.getHoteles()){
			if(h.getNombre() == nombre){
				ret.add(h);
			}
		}
		
		return ret;
	}
	
	
	/**
	 * Reserva una habitacion
	 * @param hab
	 * @param r
	 * @param cant
	 * @param forma
	 * @param p
	 * @return
	 */
	public Reserva reservar(Habitacion hab, Rango r, int cant, FormaDePago forma, Pasajero p){
		if(this.usuarioRegistrado(p) && hab.libreEn(r)){
			Reserva ret = new Reserva(cant, r, hab.retHotel(), hab, p, forma);
		
			this.agregarReserva(ret);
			p.setReserva(ret);
			hab.agregarDisponibilidad(r);
			hab.agregarReserva(ret);
			hab.getHotel().agregarReserva(ret);
			System.out.println("Habitacion reservada");
			return ret;
		}else{System.out.println("El usuario no esta registrado o la habitacion fue ocupada");}
		return null;
	}
	
	/**
	 * Retorna true si el usuario existe en la coleccion
	 * @param p
	 * @return
	 */
	public boolean usuarioRegistrado(Pasajero p) {
		return this.getUsuarios().contains(p);
	}
	
	/**
	 * Agrega la reserva a la col de reservas del portal
	 * @param nuevaReserva
	 */
	private void agregarReserva(Reserva nuevaReserva) {
		this.getReservas().add(nuevaReserva);		
	}
		
	/**
	 * Suscribe al pasajero al aviso de ofertas
	 * @param p
	 */
	public void suscribirseAlAviso(Pasajero p){
		this.getAviso().suscribirPasajero(p);
		System.out.println("Suscripto al aviso de ofertas");
	}
		
	/**
	 * Agrega un hotel a la coleccion
	 * @param h
	 */
	public void agregarHotel(Hotel h) {
		this.getHoteles().add(h);		
	}
	
	/**
	 * Retorna la col de reservas
	 * @return
	 */
	public ArrayList<Reserva> retReservas() {
		return this.getReservas();
	}
			
	/**
	 * Agrega un usuario a la coleccion
	 * @param u
	 */
	public void agregarUsuario(Usuario u) {
		this.getUsuarios().add(u);		
	}
	
	/**
	 * Agrega un Usuario (Pasajero u Hotelero) a la coleccion
	 * @param u
	 */
	public void registrarUsuario(Usuario u){
		
		this.agregarUsuario(u);		
	}
	
	/**
	 * Crea registra y retorna un Pasajero
	 * @param nom
	 * @param ap
	 * @param e
	 * @return
	 */
	public Pasajero registrarPasajero(String nom, String ap, String e){
		Pasajero ret = new Pasajero(nom, ap, e);
		this.registrarUsuario(ret);
		return ret;
	}
	
	/**
	 * Crea registra y retorna un Hotelero
	 * @param nom
	 * @param ap
	 * @param e
	 * @return
	 */
	public Hotelero registrarHotelero(String nom, String ap, String e){
		Hotelero ret = new Hotelero(nom, ap, e);
		this.registrarUsuario(ret);
		return ret;
	}
	
	
	/**
	 * Retorna la coleccion de usuarios 	
	 * @return
	 */
	public ArrayList<Usuario> retUsuarion() {
		return this.getUsuarios();		
	}
	
		
	/**
	 * Crea un rango con los valores pasados por parametro y lo retorna.
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public Rango crearRango(Calendar fechaInicio, Calendar fechaFin){
		return new Rango(fechaInicio, fechaFin);
	}
	
	/**
	 * Crea un precio-rango con los valores pasados por parametro y lo retorna.
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public Rango crearPrecioRango(Calendar fechaInicio, Calendar fechaFin, int precio){
		return new PrecioRango(fechaInicio, fechaFin, precio);
	}
	
	/**
	 * Crea un servicio de hotel y lo retorna.
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @return
	 */
	public DeHotel crearServicioDeHotel(String nombre, String descripcion, int precio){
		return new DeHotel(nombre, descripcion, precio);
	}
	
	/**
	 * Crea un servicio de habitacion y lo retorna.
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @return
	 */
	public DeHabitacion crearServicioDeHabitacion(String nombre, String descripcion, int precio){
		return new DeHabitacion(nombre, descripcion, precio);
	}
	
		
				
	public ArrayList<Hotel> retHoteles() {
		return this.getHoteles();
	}
	
	public ArrayList<Subasta> retSubastasEn(String pais, String ciudad) {
		ArrayList<Subasta> ret = new ArrayList<Subasta>();
		
		for(Hotel h: this.hotelesEn(pais, ciudad)){
			ret.addAll(h.getSubastas());
		}
		
		return ret;
	}
	
	public ArrayList<Subasta> retSubastas() {
		return this.getSubastas();
	}
	
	/**
	 * Retorna todas las calificaciones
	 * @return
	 */
	public ArrayList<Calificacion> retCalificaciones() {
		ArrayList<Calificacion> ret = new ArrayList<Calificacion>();
		
		for(Hotel h: this.getHoteles()){
			ret.addAll(h.getCalificaciones());
		}
		
		return ret;
	}
	
	/**
	 * Retorna las calificaciones de los hoteles con nombre (nom)
	 * @param nom
	 * @return
	 */
	public ArrayList<Calificacion> retCalificacionesDe(String nom) {
		ArrayList<Calificacion> ret = new ArrayList<Calificacion>();
		
		for(Hotel h: this.retHotelesConNombre(nom)){
			ret.addAll(h.getCalificaciones());
		}
		
		return ret;
	}
	
	/**
	 * Retorna las calificaciones de los hoteles en (pais, ciudad)
	 * @param pais
	 * @param ciudad
	 * @return
	 */
	public ArrayList<Calificacion> retCalificacionesEn(String pais,	String ciudad) {
		ArrayList<Calificacion> ret = new ArrayList<Calificacion>();
		
		for(Hotel h: this.hotelesEn(pais, ciudad)){
			ret.addAll(h.getCalificaciones());
		}
		
		return ret;
	}
	
	/**
	 * Agrega la oferta al AvisoDeOfertas
	 * @param o
	 */
	public void agregarOfertaAlAviso(Oferta o) {
		this.getAviso().actualizarOfertas(o);		
	}
	
	
		
	
}


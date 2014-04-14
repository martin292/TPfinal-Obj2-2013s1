package usuarios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import descuentos.Descuento;

import alojamiento.Calificacion;
import alojamiento.Habitacion;
import alojamiento.Hotel;

import ofertas.AvisoDeOferta;
import ofertas.Oferta;
import preferencias.Detallado;
import preferencias.EntreValores;
import preferencias.Lugar;
import preferencias.MayorQue;
import preferencias.MenorQue;
import preferencias.NoDetallado;
import preferencias.Precio;
import preferencias.Preferencia;
import preferencias.TotalEstadia;
import reservas.Reserva;
import servicios.DeHabitacion;
import servicios.DeHotel;
import subastas.Subasta;
import Fechas.Rango;
import FormasDePago.FormaDePago;
import FormasDePago.Tarjeta;


public class Pasajero extends Usuario{
	
	//Variables
	private ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();//Lista de las tarjetas del usuario
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();//Lista de las reservas del usuario
	private Preferencia preferencia;//Se usa para buscar ofertas
	private ArrayList<Oferta> ofertas = new ArrayList<Oferta>();//Lista de las ofertas iguales a la preferencia del usuario
	
	//Getters y Setters	
	private ArrayList<Tarjeta> getTarjetas() {
		return tarjetas;
	}	
	private ArrayList<Reserva> getReservas() {
		return reservas;
	}
	private Preferencia getPreferencia() {
		return preferencia;
	}
	private ArrayList<Oferta> getOfertas() {
		return ofertas;
	}
	public void setTarjeta(Tarjeta t) {
		this.tarjetas.add(t);		
	}
	public void setReserva(Reserva r){
		this.reservas.add(r);
	}
	public void setOferta(Oferta o){
		this.ofertas.add(o);
	}
	public void setPreferencia(Preferencia p){
		this.preferencia = p;
	}

	//Constructores
	public Pasajero(String nom, String ap, String em, String us, String p) {
		super(nom, ap, em, us, p);
	}	
	public Pasajero(){
		super();
	}
	
	public Pasajero(String nombre, String apellido, String email) {
		super(nombre, apellido, email);
	}
	
	
	
	//Metodos
	
	/**
	 * 	Retorna true si la Oferta es igual a su Preferencia
	 * @param oferta
	 */
	public boolean chequearOferta(Oferta o) {
		return this.getPreferencia().compararCon(o);
	}
	
	/**
	 * Crea una preferencia
	 * @param cap
	 * @param rango
	 * @param lugar
	 * @param precio
	 */
	
	public void crearPreferencia(int cap, Rango r, Lugar l, Precio x){
		Preferencia p = new Preferencia(cap, r, l, x);
		this.setPreferencia(p);
	}
	
	/**
	 * Imprime el pasajero
	 */
	public void imprimirPasajero() {
		System.out.println("Pasajero");
		System.out.println("Nombre: " + this.retNombre());
		System.out.println("Apellido: " + this.retApellido());
		System.out.println("EMail: " + this.retEmail());
		System.out.println("usr: " + this.retUsr());
		this.imprimirTarjetas();
		this.imprimirReservas();
		this.imprimirPreferencia();
		this.imprimirOfertas();		
	}	
	
	/**
	 * Imprime las ofertas
	 */	
	private void imprimirOfertas() {
		for(Oferta o: this.getOfertas()){
			System.out.println(" ");
			o.imprimirOferta();
		}		
	}
	
	/**
	 * Imprime la preferencia
	 */	
	private void imprimirPreferencia() {
		this.getPreferencia().imprimirPreferencia();
		
	}
	
	/**
	 * Imprime las reservas
	 */
	private void imprimirReservas() {
		for(Reserva r: this.getReservas()){
			System.out.println(" ");
			r.imprimirReserva();
		}		
	}
	
	/**
	 * Imprime las tarjetas
	 */
	private void imprimirTarjetas() {		
		for(Tarjeta t: this.getTarjetas()){
			System.out.println(" ");
			t.imprimirDatos();
		}		
	}
	
	public ArrayList<Reserva> retReservas(){
		this.imprimirReservas();
		return this.getReservas();
	}	
		
	public ArrayList<Oferta> retOfertas(){
		return this.getOfertas();
	}
	
	/**
	 * Imprime en la consola las reservas del pasajero
	 */
	public void chequearReservasRealizadas(){
		this.imprimirReservas();
	}
	
	/**
	 * Retorna las reservas del pasajer
	 * @return ArrayList<Reserva>
	 */
	public ArrayList<Reserva> retReservasRealizadas(){
		return this.getReservas();
	}
	
	/**
	 * Retorna las reservas futuras del pasajero
	 * @return ArrayList<Reserva>
	 */
	public ArrayList<Reserva> retReservasFuturas(){
		ArrayList<Reserva> aux = new ArrayList<Reserva>();
		Calendar c = Calendar.getInstance();
		
		for(Reserva r: this.getReservas()){
			if(r.retFechaInicio().after(c)){
				aux.add(r);
			}
		}
		this.imprimirReservas(aux);
		return aux;
	}
	
	/**
	 * imprime las reservas pasadas por parametro
	 * @param aux
	 */	
	private void imprimirReservas(ArrayList<Reserva> aux) {
		for(Reserva r: aux){
			r.imprimirReserva();
		}		
	}
		
	/**
	 * retorna una col con las reservas echas en una ciudad (parametro c)
	 * @param ciudad
	 * @return ArrayList<Reserva>
	 */
	public ArrayList<Reserva> retReservasEn(String ciudad){
		ArrayList<Reserva> aux = new ArrayList<Reserva>();
		
		for(Reserva r: this.getReservas()){
			if(r.retCiudad() == ciudad){
				aux.add(r);
			}
		}
		this.imprimirReservas(aux);
		return aux;
	}
	
	/**
	 * Retorna las ciudades donde reservo
	 * @return ArrayList<String>
	 */
	public ArrayList<String> retCiudadesDondeSeReservo(){
		ArrayList<String> ret = new ArrayList<String>();
		
		for(Reserva r: this.getReservas()){
			ret.add(r.retCiudad());
		}
		
		return ret;
	}
	
	/**
	 * Cancela una reserva
	 * @param reserva
	 */
	public void cancelar(Reserva r){		
		r.cancelarReserva();		
	}
	
	/**
	 * Cambia la forma de pago de una reserva
	 * @param reserva
	 * @param formaDePago
	 */	
	public void modificar(Reserva r, FormaDePago f){
		r.cambiarFormaDePago(f);
		System.out.println("Forma de pago modificada");
	}
	
	/**
	 * Cambia la habitacion de una reserva
	 * @param r
	 * @param h
	 */	
	public void modificar(Reserva r, Habitacion h){
		r.cambiarHabitacion(h);
		System.out.println("Habitacion modificada");
	}
	
	/*
	public void compartir(Reserva r, String Email){
		//Envia la reserva por eMail
	}
	*/
	
	/**
	 * Crea una Calificacion y se la asigna al hotel
	 * @param hotel
	 * @param puntaje
	 * @param comentario
	 */	
	public void calificar(Hotel hotel, int puntaje, String comentario){
		
		Calificacion cal = new Calificacion(puntaje, comentario, this);
		hotel.agregarCalificacion(cal);
		 
	}
	
	/**
	 * Imprime y retorna todos los descuentos
	 * @return ArrayList<Descuento>
	 */	
	public ArrayList<Descuento> verDescuentos(){
		ArrayList<Descuento> ret = new ArrayList<Descuento>();
		
		for(Hotel h: this.hoteles()){
			h.imprimirDescuentos();
			ret.addAll(h.getDescuentos());
		}
		
		return ret;
	}
	
	/**
	 * Retorna una col con todos los hoteles
	 * @return ArrayList<Hotel>
	 */
	public ArrayList<Hotel> hoteles() {
		return this.getPortal().retHoteles();
	}
	
	/**
	 * Suscribe al pasajero al aviso de ofertas
	 */
	public void suscribirse(){
		this.getPortal().suscribirseAlAviso(this);
	}
	
	/**
	 * Crea y retorna un Precio EntreValores
	 * @param a
	 * @param b
	 * @return EntreValores
	 */	
	public EntreValores crearPrecioEntreValores(int a, int b){
		EntreValores ret = new EntreValores(a, b);
		return ret;
	}
	
	/**
	 * Crea y retorna un Precio MenorQue
	 * @param a
	 * @return MenorQue
	 */	
	public MenorQue crearPrecioMenorQue(int a){
		MenorQue ret = new MenorQue(a);
		return ret;
	}
	
	/**
	 * Crea y retorna un Precio MayorQue
	 * @param a
	 * @return MayorQue
	 */	
	public MayorQue crearPrecioMayorQue(int a){
		MayorQue ret = new MayorQue(a);
		return ret;
	}
	
	/**
	 * Crea y retorna un Precio TotalEstadia
	 * @param a
	 * @return TotalEstadia
	 */	
	public TotalEstadia crearPrecioTotalEstadia(int a){
		TotalEstadia ret = new TotalEstadia(a);
		return ret;
	}
	
	/**
	 * Crea y retorna un Lugar Detallado
	 * @param pais
	 * @param ciudad
	 * @return Detallado
	 */	
	public Detallado crearLugarDetallado(String pais, String ciudad){
		return new Detallado(pais, ciudad);
	}
	
	/**
	 * Crea y retorna un Lugar NoDetallado
	 * @param pais
	 * @return NoDetallado
	 */
	public NoDetallado crearLugarNoDetallado(String pais){
		return new NoDetallado(pais);
	}
	
	/**
	 * Actualiza los datos de usuario
	 * @param nombre
	 * @param apellido
	 * @param email
	 */	
	public void actualizarDatos(String nombre, String apellido, String email){
		this.actualizarNombre(nombre);
		this.actualizarApellido(apellido);
		this.actualizarEMail(email);	
	}
	
	/**
	 * Retorna una coleccion de habitaciones
	 * @param pais
	 * @param ciudad
	 * @param inicio
	 * @param fin
	 * @param cant
	 * @return ArrayList<Habitacion>
	 */	
	public ArrayList<Habitacion> buscarAlojamiento(String pais, String ciudad, Calendar inicio, Calendar fin, int cant){
		return this.getPortal().buscarAlojamiento(pais, ciudad, inicio, fin, cant);
	}
	
	/**
	 * Retorna una lista con los hoteles en (pais, ciudad)
	 * @param pais
	 * @param ciudad
	 * @return ArrayList<Hotel>
	 */
	public ArrayList<Hotel> buscarHotelesEn(String pais, String ciudad){
		return this.getPortal().hotelesEn(pais, ciudad);
	}
	
	public ArrayList<Habitacion> buscarAlojamiento(String nombre, Calendar inicio, Calendar fin, int cant){
		return this.getPortal().buscarAlojamiento(nombre, inicio, fin, cant);
	}
	
	/**
	 * Retorna una lista de hoteles con el nombre que se paso por parametro
	 * @param nombre
	 * @return ArrayList<Hotel>
	 */
	public ArrayList<Hotel> buscarHotelesConNombre(String nombre){
		return this.getPortal().retHotelesConNombre(nombre);
	}
	
	/**
	 * Compara la preferencia con una oferta
	 * @param o
	 * @return boolean
	 */
	public boolean compararPreferenciaCon(Oferta o) {
		return this.chequearOferta(o);
	}
	
	
	public void notificar(AvisoDeOferta a, Oferta o) {
		this.setOferta(o);
	}
	
	/**
	 * Retorna las habitaciones que tienen un determinado servicio DeHabitacion
	 * @param s
	 * @param hab
	 * @return ArrayList<Habitacion>
	 */
	public ArrayList<Habitacion> retHabitacionesConServicio(DeHabitacion s, ArrayList<Habitacion> hab){
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		
		for(Habitacion h: hab){
			if(h.getServicios().contains(s)){
				ret.add(h);
			}
		}
		
		return ret;
	}
	
	/**
	 * Retorna las habitaciones que tienen determinados servicios DeHabitacion
	 * @param s
	 * @param hab
	 * @return ArrayList<Habitacion>
	 */
	public ArrayList<Habitacion> retHabitacionesConServicios(ArrayList<DeHabitacion> s, ArrayList<Habitacion> hab){
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		
		for(Habitacion h: hab){
			if(h.getServicios().contains(s)){
				ret.add(h);
			}
		}
		
		return ret;
	}
		
	/**
	 * Retorna las habitaciones cuyo hotel tiene un determinado servicio DeHotel
	 * @param s
	 * @param hab
	 * @return ArrayList<Habitacion>
	 */
	public ArrayList<Habitacion> retHabitacionesConServiciosEnHotel(DeHotel s, ArrayList<Habitacion> hab){
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		
		for(Habitacion h: hab){
			if(h.getHotel().getServiciosDeHotel().contains(s)){
				ret.add(h);
			}
		}
		return ret;
	}
	
	/**
	 * Retorna las habitaciones cuyo hotel tiene determinados servicios DeHotel
	 * @param s
	 * @param hab
	 * @return ArrayList<Habitacion>
	 */
	public ArrayList<Habitacion> retHabitacionesConServiciosEnHotel(ArrayList<DeHotel> s, ArrayList<Habitacion> hab){
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		
		for(Habitacion h: hab){
			if(h.getHotel().getServiciosDeHotel().contains(s)){
				ret.add(h);
			}
		}
		return ret;
	}
	
	/**
	 * Retorna las habitaciones de hoteles con categoria (cat)
	 * @param cat
	 * @param hab
	 * @return
	 */
	public ArrayList<Habitacion> retHabitacionesDeHotelesConCategoria(int cat, ArrayList<Habitacion> hab){
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		
		for(Habitacion h: hab){
			if(h.getHotel().getCategoria() == cat){
				ret.add(h);
			}
		}
		return ret;
	}
	
	/**
	 * Retorna las habitaciones cuyo hotel acepta la tarjeta del pasajero
	 * @param hab
	 * @return
	 */
	public ArrayList<Habitacion> retHabitacionesConTarjeta(ArrayList<Habitacion> hab, Tarjeta t){
		ArrayList<Habitacion> ret = new ArrayList<Habitacion>();
		
		for(Habitacion h: hab){
			if(h.getHotel().aceptaTarjeta(t.retNombre())){
				ret.add(h);
			}
		}
		return ret;
	}
	

	/**
	 * Retorna las Subastas en (pais, ciudad)
	 * @param pais
	 * @param ciudad
	 * @return ArrayList<Subasta>
	 */
	public ArrayList<Subasta> retSubastasEn(String pais, String ciudad){
		return this.getPortal().retSubastasEn(pais, ciudad);
	}
	
	/**
	 * Retorna todas las subastas
	 * @return ArrayList<Subasta>
	 */
	public ArrayList<Subasta> retSubastas(){
		return this.getPortal().retSubastas();
	}
	
	/**
	 * Oferta (en pesos) en una subasta pasada por parametro
	 * @param s
	 * @param oferta
	 * 
	 */
	public void ofertar(Subasta s, int oferta){
		s.recibirOfertaDe(this, oferta);
	}
	
	/**
	 * Supera la oferta actual en 1
	 * @param s
	 */
	public void superarOferta(Subasta s){
		s.superarOfertaActual(this);
	}
	
	/**
	 * Retorna todas las calificaciones
	 * @return
	 */
	public ArrayList<Calificacion> verCalificaciones(){
		return this.getPortal().retCalificaciones();
	}
	
	/**
	 * Retorna las calificaciones de los hoteles con nombre (nom)
	 * @param nom
	 * @return
	 */
	public ArrayList<Calificacion> verCalificacionesDe(String nom){
		return this.getPortal().retCalificacionesDe(nom);
	}
	
	/**
	 * Retorna las calificaciones de los hoteles en un pais y una ciudad
	 * @param pais
	 * @param ciudad
	 * @return
	 */
	public ArrayList<Calificacion> verCalificacionesEn(String pais, String ciudad){
		return this.getPortal().retCalificacionesEn(pais, ciudad);
	}
	
	
	
	
}


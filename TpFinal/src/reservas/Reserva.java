package reservas;

import java.util.Calendar;

import alojamiento.Habitacion;
import alojamiento.Hotel;
import usuarios.Pasajero;
import usuarios.Usuario;
import Fechas.Rango;
import FormasDePago.FormaDePago;

public class Reserva {
	
	//Variables
	private int cantidad;
	private Rango rangoFecha;
	private Habitacion habitacion;
	private Hotel hotel;
	private Pasajero pasajero;
	private FormaDePago forma;
	private EstadoReserva estado;
	
	//Constructores
	public Reserva(int c, Rango r, Hotel h, Habitacion hab, Usuario p, FormaDePago f){
		this.setCantidad(c);
		this.setRangoFecha(r);
		this.setHotel(h);
		this.setHabitacion(hab);
		this.setPasajero((Pasajero)p);
		this.setForma(f);
		
		Concretado x = new Concretado();
		this.setEstado(x);		
	}

	public Reserva() {
		Concretado x = new Concretado();
		this.setEstado(x);
	}

	//Getters y Setters
	private int getCantidad() {
		return cantidad;
	}
	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Rango getRangoFecha() {
		return rangoFecha;
	}
	private void setRangoFecha(Rango rangoFecha) {
		this.rangoFecha = rangoFecha;
	}
	private Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	private Hotel getHotel() {
		return hotel;
	}
	private void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	private Pasajero getPasajero() {
		return pasajero;
	}
	private void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	public FormaDePago getForma() {
		return forma;
	}
	private void setForma(FormaDePago forma) {
		this.forma = forma;
	}
	private EstadoReserva getEstado() {
		return estado;
	}
	private void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}
	
	
	//Metodos
	
	/**
	 * Cancela la reserva
	 */
	public void cancelarReserva(){
		this.getEstado().cancelar(this);
	}
	
	/**
	 * Setea el estado
	 * @param c
	 */
	public void cambiarEstado(EstadoReserva c) {
		this.setEstado(c);
	}
	
	/**
	 * Retorna el precio real (sin descuento) de la reserva
	 * @return
	 */
	public int retornarPrecioReal() {
		
		return this.getHabitacion().precioReal(this.getRangoFecha());
	}
	
	/**
	 * Cambia la haitacion
	 * @param h
	 */
	public void cambiarHabitacion(Habitacion h){
		this.getHabitacion().eliminarDisponibilidad(this.getRangoFecha());
		this.setHabitacion(h);
		h.agregarDisponibilidad(this.getRangoFecha());
	}
	
	/**
	 * Cambia la forma de pago
	 * @param f
	 */
	public void cambiarFormaDePago(FormaDePago f){
		this.setForma(f);
	}

	/**
	 * Imprime la reserva en consola
	 */
	public void imprimirReserva(){
		System.out.println("Cantidad: " + this.getCantidad());
		this.getRangoFecha().imprimirRango();
		this.getHotel().imprimirHotel();
		this.getHabitacion().imprimirHabitacion();
		this.getPasajero().imprimirPasajero();
		this.getForma().imprimirFormaDePago();
		this.getEstado().imprimirEstado();
	}

	
	public String retCiudad() {
		return this.getHotel().retCiudad();
	}
	public EstadoReserva retEstado(){
		return this.getEstado();
	}

	public Calendar retFechaFin(){
		return this.getRangoFecha().getFechaFin();
	}

	public Calendar retFechaInicio() {
		return this.getRangoFecha().getFechaInicio();
	}

	public Pasajero retPasajero() {
		return this.getPasajero();
	}
	
	public String retNombrePasajero(){
		return this.getPasajero().retNombre();
	}
	public String retApellidoPasajero(){
		return this.getPasajero().retApellido();
	}
	public String retEmailPasajero(){
		return this.getPasajero().retEmail();
	}

	/**
	 * Verifica si la reserva es actual.
	 * @return
	 */
	public boolean esActual() {
		Calendar fechaActual = Calendar.getInstance();
		
		return this.getRangoFecha().incluyeA(fechaActual);
	}
	
	/**
	 * Retorna la cantidad de días que faltan para que inicie la reserva.
	 * @return
	 */
	public int cantDiasParaIniciar() {
		Calendar fechaActual = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(this.getRangoFecha().getFechaInicio().getTime().getTime() - fechaActual.getTime().getTime());
		
		return  c.get(Calendar.DAY_OF_YEAR);
	}
	
	/**
	 * Retorna true si la reserva todavia no inicio.
	 * @return
	 */
	public boolean esFutura(){
		if(this.cantDiasParaIniciar() > 0){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
}

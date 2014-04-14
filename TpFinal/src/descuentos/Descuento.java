package descuentos;

import java.util.ArrayList;
import java.util.Calendar;

import Fechas.Rango;
import alojamiento.Habitacion;

public class Descuento {

	//Variables
	private int porcentaje;
	private Calendar fechaLimite;
	private Rango rangoFecha;
	private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	
	
	//Constructores
	public Descuento(Habitacion habitacion, int porcentaje, Calendar fechaLimite, Calendar fechaInicio, Calendar fechaFin) {
		super();
		this.habitaciones.add(habitacion);
		this.porcentaje = porcentaje;
		this.fechaLimite = fechaLimite;
		this.rangoFecha = new Rango(fechaInicio, fechaFin);
	}

	public Descuento() {
		super();
	}

	
	//Getters y Setters
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Calendar getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Calendar fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public Rango getRangoFecha() {
		return rangoFecha;
	}
	public void setRangoFecha(Rango rangoFecha) {
		this.rangoFecha = rangoFecha;
	}
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
	//Metodos
	
	/**
	 * Agrega un porcentaje al descuento.
	 * @param porcentaje
	 */
	public void agregarPorcentaje(int porcentaje){
		this.setPorcentaje(porcentaje);
	}
	
	/**
	 * Agrega una fecha limite al descuento.
	 * @param fechaLimite
	 */
	public void agregarFechaLimite(Calendar fechaLimite){
		this.setFechaLimite(fechaLimite);
	}
	
	/**
	 * Agrega un rango al descuento.
	 * @param rango
	 */
	public void agregarRangoFecha(Rango rango){
		this.setRangoFecha(rango);
	}
	
	/**
	 * Agrega una habitacion al descuento.
	 * @param habitacion
	 */
	public void agregarHabitacion(Habitacion habitacion){
		this.getHabitaciones().add(habitacion);
	}
	
	/**
	 * Agrega una lista de habitaciones al descuento.
	 * @param habitaciones
	 */
	public void agregarHabitaciones(ArrayList<Habitacion> habitaciones){
		this.setHabitaciones(habitaciones);
	}
	
	/**
	 * Imprime en la consola el descuento
	 */	
	public void imprimirDescuento() {
		System.out.println("Porcentaje: " + this.getPorcentaje() + "%");
		System.out.println("Fecha limite: " + this.getFechaLimite());
		this.getRangoFecha().imprimirRango();
		this.imprimirHabitacones();
		
	}

	/**
	 * Imprime en la consola las habitaciones
	 */	
	private void imprimirHabitacones() {
		for(Habitacion h: this.getHabitaciones()){
			h.imprimirHabitacion();
		}		
	}

	
}

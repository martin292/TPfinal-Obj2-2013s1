package preferencias;

import alojamiento.Habitacion;
import alojamiento.Hotel;
import Fechas.Rango;
import ofertas.Oferta;

public class Preferencia {

	//Variables
	private int capacidad;
	private Rango fechaRango;
	private Lugar lugar;
	private Precio precio;
	
	//Constructor
	public Preferencia(int cap, Rango r, Lugar l, Precio p) {
		this.setCapacidad(cap);
		this.setFechaRango(r);
		this.setLugar(l);
		this.setPrecio(p);
	}

	//Getters y Setters
	private int getCapacidad() {
		return capacidad;
	}

	private void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	private Rango getFechaRango() {
		return fechaRango;
	}

	private void setFechaRango(Rango fechaRango) {
		this.fechaRango = fechaRango;
	}

	private Lugar getLugar() {
		return lugar;
	}

	private void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	private Precio getPrecio() {
		return precio;
	}

	private void setPrecio(Precio precio) {
		this.precio = precio;
	}

	//Metodos
	
	/**
	 * Compara la preferencia con una oferta	
	 * @param o
	 * @return
	 */
	public boolean compararCon(Oferta o) {
		return this.compararCapacidadCon(o.retHabitacion()) && this.compararRangoCon(o.retRango()) && this.compararLugarCon(o.retHotel()) && this.compararPrecioCon(o.retPrecio());
	}

	/**
	 * Compara el precio con el parametro
	 * @param p
	 * @return
	 */
	public boolean compararPrecioCon(int p) {
		return this.getPrecio().compararPrecioCon(p);
	}

	/**
	 * Compara el lugar con el parametro
	 * @param h
	 * @return
	 */
	public boolean compararLugarCon(Hotel h) {
		return this.getLugar().compararLugarCon(h);
	}

	/**
	 * Compara el rango con el parametro
	 * @param r
	 * @return
	 */
	public boolean compararRangoCon(Rango r) {
		return this.getFechaRango().esIgual(r);
	}

	/**
	 * Compara la capacidad con la capacidad de la habitacion
	 * @param h
	 * @return
	 */
	public boolean compararCapacidadCon(Habitacion h) {
		return this.getCapacidad() == h.retCapacidad();
	}

	/**
	 * Imprime la preferencia
	 */	
	public void imprimirPreferencia() {
		System.out.println(" ");
		System.out.println("Capacidad: " + this.getCapacidad());
		this.getFechaRango().imprimirRango();
		this.getLugar().imprimirLugar();
		this.getPrecio().imprimirPrecio();
		
	}

}


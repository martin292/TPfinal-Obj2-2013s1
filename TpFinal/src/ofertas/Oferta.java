package ofertas;

import Fechas.Rango;
import alojamiento.Habitacion;
import alojamiento.Hotel;

public class Oferta {

	//Variables
	private Hotel hotel = new Hotel();
	private Habitacion habitacion = new Habitacion();
	private Rango fecha = new Rango();
	private int precio;
	
	//Constructor
	public Oferta(Hotel h, Habitacion ha, Rango f, int p){
		this.setHotel(h);
		this.setHabitacion(ha);
		this.setFecha(f);
		this.setPrecio(p);
	}
	
	public Oferta(Hotel hotel2, Habitacion habitacion2, int precio2, Rango rango) {
		// TODO Auto-generated constructor stub
	}

	//Getters y Setters
	private Hotel getHotel() {
		return hotel;
	}
	private void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	private Habitacion getHabitacion() {
		return habitacion;
	}
	private void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	private Rango getFecha() {
		return fecha;
	}
	private void setFecha(Rango fecha) {
		this.fecha = fecha;
	}
	private int getPrecio() {
		return precio;
	}
	private void setPrecio(int precio) {
		this.precio = precio;
	}

	//Metodos
	public Habitacion retHabitacion() {
		return this.getHabitacion();
	}

	public Rango retRango() {
		return this.getFecha();
	}

	public Hotel retHotel() {
		return this.getHotel();
	}

	public int retPrecio() {
		return this.getPrecio();
	}
	
	/**
	 * Imprime en consola la Oferta
	 */	
	public void imprimirOferta(){
		this.getHotel().imprimirHotel();
		this.getHabitacion().imprimirHabitacion();
		this.getFecha().imprimirRango();
		System.out.println("Precio: $" + this.getPrecio());
	}
	
}

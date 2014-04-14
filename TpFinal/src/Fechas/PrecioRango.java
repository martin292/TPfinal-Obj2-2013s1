package Fechas;

import java.util.Calendar;

public class PrecioRango extends Rango {
	
	//Variables de instancia
	private int precio;

	
	//Geters y Seters
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	//Constructores
	public PrecioRango(Calendar fechaInicio, Calendar fechaFin, int precio) {
		this.setFechaInicio(fechaInicio);
		this.setFechaFin(fechaFin);
		this.setPrecio(precio);
	}
	
	//Metodos
	
	/**
	 * Imprime en consola el PrecioRango
	 */	
	public void imprimirPrecio(){
		System.out.println("Fecha inicio: " + this.getFechaInicio());
		System.out.println("Fecha fin: " + this.getFechaFin());
		System.out.println("Precio: $" + this.getPrecio());
	}
	
}

package Fechas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Rango {
	
	//Variables de instancia-------------
	private Calendar fechaInicio;
	private Calendar fechaFin;

	//Constructor
	public Rango(Calendar a, Calendar b) {
		this.setFechaInicio(a);
		this.setFechaFin(b);
	}

	public Rango() {}

	
	//Geters y Seters-------------------------------------
	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	//Metodos----------------------------------------------------------------------------------------
	/**
	 * Retorna true si fechaIncio del rango es menor que la fecha dada por parametro, false en cualquier otro caso.
	 * @param f
	 * @return
	 */
	public boolean fechaInicioMenorQue(Calendar unaFecha) {
		return this.getFechaInicio().before(unaFecha);
	}
	
	/**
	 * Retorna true si fechaIncio del rango es igual que fecha dada por parametro, false en cualquier otro caso.
	 * @param unaFecha
	 * @return
	 */
	public boolean fechaIncioIgualQue(Calendar unaFecha){
		return this.getFechaInicio().equals(unaFecha);
	}
	
	/**
	 * Retorna true si fechaIncio del rango es menor o igual que la fecha pasada por parametro, false en cualquier otro caso.
	 * @param unaFecha
	 * @return
	 */
	public boolean fechaInicioMenorOIgualQue(Calendar unaFecha){
		return this.fechaInicioMenorQue(unaFecha) || this.fechaIncioIgualQue(unaFecha);
	}
	
	/**
	 * Retorn true si fechaFin del rango es mayor que la fecha dada por parametro, false en cualquier otro caso.
	 * @param unaFecha
	 * @return
	 */
	public boolean fechaFinMayorQue(Calendar unaFecha){
		return this.getFechaFin().after(unaFecha);
	}
	
	/**
	 * Retorna true si fechaFin del rango es igual a la fecha dada por parametro, false en cualquier otro caso.
	 * @param unaFecha
	 * @return
	 */
	public boolean fechaFinIgualQue(Calendar unaFecha){
		return this.getFechaFin().equals(unaFecha);
	}
	
	/**
	 * Retorna true si fechaFin del rango es mayor o igual a  la fecha dada por parametro, false en cualquier otro caso.
	 * @param unaFecha
	 * @return
	 */
	public boolean fechaFinMayorOIgualQue(Calendar unaFecha){
		return this.fechaFinMayorQue(unaFecha) || this.fechaFinIgualQue(unaFecha);
	}
	
	/**
	 * Retorna true si los rango son iguales, osea que tienen misma fecha de inicio y de fin.
	 * @param rango
	 * @return
	 */
	public boolean esIgual(Rango rango) {
		
		return this.getFechaInicio().equals(rango.getFechaInicio()) && this.getFechaFin().equals(rango.getFechaFin());
	}
		
	/**
	 * Retorna true si el rango se encuentra en la lista de rangos pasada por parametro.
	 * @param rangos
	 * @return
	 */
	public boolean estaEn(List<Rango> rangos) {
		
		for(Rango r: rangos){
			if(this.esIgual(r)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna true si el rango incluye a la fecha pasada por parametro, false en cualquier otro caso.
	 * @param unaFecha
	 * @return
	 */
	public boolean incluyeA(Calendar unaFecha) {
		
		return this.fechaInicioMenorOIgualQue(unaFecha) && this.fechaFinMayorOIgualQue(unaFecha);
	}
	
	/**
	 * Retorna true si el rango incluye a la fecha pasada por parametro, false en cualquier otro caso.
	 * @param unaFecha
	 * @return
	 */
	public boolean incluyeA(Rango rango) {
		return this.fechaInicioMenorOIgualQue(rango.getFechaInicio()) && this.fechaFinMayorOIgualQue(rango.getFechaFin());
	}
	
	/**
	 * Retorna true si el rango esta incluido en el rango dado por parametro, false en cualquier otro caso.
	 * @param rango
	 * @return
	 */
	public boolean incluidoEn(Rango rango) {
		
		return rango.fechaInicioMenorOIgualQue(this.getFechaInicio()) && rango.fechaFinMayorOIgualQue(this.getFechaFin());
	}
	
	/**
	 * Imprime en la consola la fecha de inicio y fin
	 * 
	 */
	public void imprimirRango() {
		System.out.println("Fecha inicio: " + this.getFechaInicio());
		System.out.println("Fecha fin: " + this.getFechaFin());
	}

	public boolean noExisteEn(ArrayList<Rango> rangos) {
		
		boolean ret = false;
		
		for(Rango r: rangos){
			ret = ret || this.esIgual(r);
		}
		
		return !ret;
	}
	
	/**
	 * Achica el rango asignando a la fecha fin, la fecha pasada por parametro con un dia anterior.
	 * @param unaFecha
	 */
	public void modificarRangoA(Calendar unaFecha){
		if(this.incluyeA(unaFecha)){
			unaFecha.add(Calendar.DATE, -1);
			this.setFechaFin(unaFecha);
		}
	}
	
	/**
	 * Achica el rango asignando a la fecha de inicio, la fecha pasada por parametro aumentada en un dia.
	 * @param unaFecha
	 */
	public void modificarRangoB(Calendar unaFecha){
		if(this.incluyeA(unaFecha)){
			unaFecha.add(Calendar.DATE, 1);
			this.setFechaInicio(unaFecha);
		}
	}
	
	/**
	 * Retorna la cantidad de dias que hay en un rango.
	 * @return
	 */
	public long cantDias(){
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(this.getFechaFin().getTime().getTime() - this.getFechaInicio().getTime().getTime());
		
		return  c.get(Calendar.DAY_OF_YEAR) + 1;
	}
	
	/**
	 * Retorna la cantidad de dias del rango dado por parametro que estan incluidos en el rango receptor.
	 * @param rango
	 * @return
	 */
	public int cantDiasQueIncluye(Rango rango) {
		int aux = 0;
		int ret = 0;
		Calendar fechaAux = rango.getFechaInicio();
		
			while(aux < rango.cantDias()){
				
				if(this.incluyeA(fechaAux)){
					ret = ret + 1;  
				}
				fechaAux.add(Calendar.DATE, 1);
				aux = aux + 1;
				
			}
		
		return ret;
	}

	
	
	
	

}


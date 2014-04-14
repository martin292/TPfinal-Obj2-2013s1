package ofertas;

import java.util.ArrayList;
import java.util.Observable;

import usuarios.Pasajero;

public class AvisoDeOferta{
	
	//Variables
	private ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	private ArrayList<Pasajero> suscriptores = new ArrayList<Pasajero>();
	//private ArrayList<Preferencia> preferencias = new ArrayList<Preferencia>();
	
	//Constructor
	public AvisoDeOferta(){
		super();
	}	
	
	//Getters y Setters
	private ArrayList<Oferta> getOfertas() {
		return ofertas;
	}
	
	private void setOfertas(Oferta o) {
		this.ofertas.add(o);
	}
	private ArrayList<Pasajero> getSuscriptores() {
		return this.suscriptores;
	}
	
	//Metodos
	
	/**
	 * agrega un observer
	 * @param p
	 */	
	public void suscribirPasajero(Pasajero p){
		this.getSuscriptores().add(p);
	}
	
	

	/**
	 * agrega una oferta
	 * @param o
	 */	
	public void actualizarOfertas(Oferta o){
		this.setOfertas(o);
		this.notificar(o);
	}
	
	/**
	 * Notifica a los observers
	 * @param o
	 */
	public void notificar(Oferta o){
		for(Pasajero p: this.getSuscriptores()){
			if(p.compararPreferenciaCon(o)){
				p.notificar(this, o);
			}
		}
	}
	
	/*
	public void notificar(Oferta o){
		for(Preferencia p: this.getPreferencias()){
			if(p.compararCon(o){
				p.notificarPasajero(o);
			}
		}
	}
	*/
	
	
	/**
	 * Imprime en consola las ofertas
	 */	
	public void imprimirOfertas(){
		
		for(Oferta o: this.getOfertas()){
			System.out.println("-------------------------");
			o.imprimirOferta();
			System.out.println("-------------------------");
			System.out.println(" ");
		}
		
	}
	
	/**
	 * Retorna las ofertas
	 * @return
	 */	
	public ArrayList<Oferta> retOfertas() {
		return this.getOfertas();
	}
	
	/**
	 * Retorna la cantidad de suscriptores
	 * @return
	 */
	public int cantidadDeSuscriptores(){
		return this.getSuscriptores().size();
	}
	
	/**
	 * Elimina un suscriptor
	 * @param p
	 */
	public void eliminarSuscriptor(Pasajero p){
		this.getSuscriptores().remove(p);
	}

	public ArrayList<Pasajero> retSuscriptores() {
		return this.getSuscriptores();
	}
	
	
}

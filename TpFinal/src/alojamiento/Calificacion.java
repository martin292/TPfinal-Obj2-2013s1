package alojamiento;

import usuarios.Pasajero;

public class Calificacion {

	//Variables
	private int puntaje; //entero entre 1 y 10
	private String comentario;
	private Pasajero pasajero;
	
	
	//Getters y Setters
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	//Constructores
	public Calificacion(int puntaje, String comentario, Pasajero user) {
		super();
		this.puntaje = puntaje;
		this.comentario = comentario;
		this.pasajero = pasajero;
	}
	public Calificacion() {
		super();
	}
	
	//Metodos
	
	/**
	 * Imprime la calificacion en la consola
	 */
	
	public void imprimirCalificacion() {
		System.out.println("Puntaje: " + this.getPuntaje());
		System.out.println("Comentario: " + this.getComentario());
		this.getPasajero().imprimirPasajero();
	}
	
	/**
	 * Agrega un comentario a la calificacion.
	 * @param comentario
	 */
	public void agregarComentario(String comentario){
		this.setComentario(comentario);
	}
	
	/**
	 * Agrega un puntaje a la calificacion siempre que el puntaje sea un entero entre 1 y 10.
	 * @param puntaje
	 * @throws PuntajeFueraDeRango 
	 */
	public void agregarPuntaje(int puntaje) throws PuntajeFueraDeRango{
		if(puntaje >= 1 && puntaje <=10){
			this.setPuntaje(puntaje);
		}
		else{
			throw new PuntajeFueraDeRango("Debe puntuar con números entre 1 y 10");
		}	
		
	}
	
	/**
	 * Agrega un pasajero a la calificacion.
	 * @param pasajero
	 */
	public void agregarPasajero(Pasajero pasajero){
		this.setPasajero(pasajero);
	}

}

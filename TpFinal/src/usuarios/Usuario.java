package usuarios;

import alojamiento.Calificacion;
import alojamiento.Hotel;
import portal.Portal;

public abstract class Usuario {

	//Variables
	private Portal portal;
	private String nombre;
	private String apellido;
	private String eMail;
	private String userName;//No se usa
	private String pass;//No se usa
	
	//Constructor
	public Usuario(String nom, String ap, String em, String us, String p) {//No se usa
		this.actualizarNombre(nom);
		this.actualizarApellido(ap);
		this.actualizarEMail(em);
		this.registrarNombreDeUsuario(us);
		this.registrarContraseña(p);
	}
	public Usuario(){}
	
	public Usuario(String nombre2, String apellido2, String email2) {
		this.actualizarNombre(nombre2);
		this.actualizarApellido(apellido2);
		this.actualizarEMail(email2);
	}
	
	//Getters y Setters
	public void setPortal(Portal p){
		this.portal = p;
	}
	public Portal getPortal(){
		return this.portal;
	}
	
	private String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private String getApellido() {
		return apellido;
	}
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	private String geteMail() {
		return eMail;
	}
	private void seteMail(String eMail) {
		this.eMail = eMail;
	}
	private String getUserName() {
		return userName;
	}
	private void setUserName(String userName) {
		this.userName = userName;
	}
	private String getPass() {
		return pass;
	}
	private void setPass(String pass) {
		this.pass = pass;
	}
	
	//Metodos
	public void actualizarNombre(String nom){
		this.setNombre(nom);
	}
	public void actualizarApellido(String ap){
		this.setApellido(ap);
	}
	public void actualizarEMail(String e){
		this.seteMail(e);
	}
	public void registrarNombreDeUsuario(String un){
		this.setUserName(un);
	}
	public void registrarContraseña(String p){
		this.setPass(p);
	}
	
	public String retNombre(){
		return this.getNombre();
	}
	public String retApellido(){
		return this.getApellido();
	}
	public String retEmail(){
		return this.geteMail();
	}
	public String retUsr(){
		return this.getUserName();
	}
	public String retPass() {
		return this.getPass();
	}
	
	/**
	 * Imprime en la consola el puntaje promedio de un hotel
	 * @param hotel
	 */
	
	public void promedioDe(Hotel hotel){
		System.out.println("Puntaje promedio: " + hotel.puntajePromedio());
	}
	
	/**
	 * Imprime las calificaciones de un hotel
	 * @param hotel
	 */
	
	public void listadoDeCalificaciones(Hotel hotel){
		for(Calificacion c: hotel.getCalificaciones()){
			c.imprimirCalificacion();
			System.out.println("------------------------------------------");
		}
	}
	
	
	
}

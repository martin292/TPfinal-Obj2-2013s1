package servicios;

public abstract class Servicio {

	//Variables
	private String nombre;
	private String descripcion;
	private int precio;
	
	//Costructor
	public Servicio(){
		super();
	}
	public Servicio(String nombre, String descripcion, int precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	//Metodos
	public void imprimirServicio(){
		System.out.println(" ");
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Descripcion: " + this.getDescripcion());
		System.out.println("Precio: $" + this.getPrecio());
	}
	
}

package FormasDePago;

public abstract class Tarjeta extends FormaDePago {

	//Variables
	private String nombre;
	private String banco;
	private int numero;
	
	//Constructor
	public Tarjeta(String nom, String bank, int i) {
		this.setNombre(nom);
		this.setBanco(bank);
		this.setNumero(i);
	}

	//Getters y Setters
	private String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private String getBanco() {
		return banco;
	}
	private void setBanco(String banco) {
		this.banco = banco;
	}
	private int getNumero() {
		return numero;
	}
	private void setNumero(int numero) {
		this.numero = numero;
	}
	
	//Metodos
	public abstract void imprimirDatos();
	
	public void imprimirNombre(){
		System.out.println("Nombre: " + this.getNombre());
	}
	public void imprimirBanco(){
		System.out.println("Banco: " + this.getBanco());
	}
	public void imprimirNumero(){
		System.out.println("Numero: " + this.getNumero());
	}
	
	public String retNombre(){
		return this.getNombre();
	}
	
	public String retBanco(){
		return this.getBanco();
	}
	
	public int retNumero(){
		return this.getNumero();
	}
	
}


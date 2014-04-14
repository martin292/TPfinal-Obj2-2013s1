package preferencias;

public abstract class Precio {

	//Variables
	private int precioA;

	//Constructor
	public Precio(int a){
		this.setPrecioA(a);
	}
	
	//Getters y Setters
	public int getPrecioA() {
		return precioA;
	}
	private void setPrecioA(int precioA) {
		this.precioA = precioA;
	}
	
	//Metodos
	public abstract boolean compararPrecioCon(int p);

	public abstract void imprimirPrecio();
	
}

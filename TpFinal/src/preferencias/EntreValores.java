package preferencias;

public class EntreValores extends Precio {

	//Variables
	private int precioB;

	//Constructor
	public EntreValores(int a, int b){
		super(a);
		this.setPrecioB(b);
	}
	
	//Getters y Setters
	public int getPrecioB() {
		return precioB;
	}
	private void setPrecioB(int precioB) {
		this.precioB = precioB;
	}

	@Override//Compara el precio con el parametro
	public boolean compararPrecioCon(int p) {
		return p >= this.getPrecioA() && p <= this.getPrecioB();
	}

	@Override//Imprime el precio
	public void imprimirPrecio() {
		System.out.println("Precio entre valores ");
		System.out.println("A: " + this.getPrecioA());
		System.out.println("B: " + this.getPrecioB());		
	}
	
	
	
}



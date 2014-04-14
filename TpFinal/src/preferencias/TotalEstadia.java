package preferencias;

public class TotalEstadia extends Precio {

	//Constructor
	public TotalEstadia(int a){
		super(a);
	}

	@Override//Compara el precio con el parametro
	public boolean compararPrecioCon(int p) {
		return this.getPrecioA() == p;
	}

	@Override//Imprime el precio
	public void imprimirPrecio() {
		System.out.println("Precio total: " + this.getPrecioA());		
	}
	
}



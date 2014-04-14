package preferencias;

public class MayorQue extends Precio {

	//Constructor
	public MayorQue(int a){
		super(a);
	}

	@Override//Compara el precio con el parametro
	public boolean compararPrecioCon(int p) {
		return this.getPrecioA() > p;
	}

	@Override//Imprime el precio
	public void imprimirPrecio() {
		System.out.println("Precio mayor que: " + this.getPrecioA());		
	}
	
}


package preferencias;

public class MenorQue extends Precio {
	
	//Constructor
	public MenorQue(int a){
		super(a);
	}

	@Override//Compara el precio con el parametro
	public boolean compararPrecioCon(int p) {
		return this.getPrecioA() < p;
	}

	@Override//Imprime el precio
	public void imprimirPrecio() {
		System.out.println("Precio menor que: " + this.getPrecioA());		
	}

}


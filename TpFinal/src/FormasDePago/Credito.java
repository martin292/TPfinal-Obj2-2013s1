package FormasDePago;

public class Credito extends Tarjeta {

	public Credito(String nom, String bank, int i) {
		super(nom, bank, i);
	}

	@Override
	public void imprimirDatos() {
		System.out.println("Tarjeta de credito");
		this.imprimirNombre();
		this.imprimirBanco();
		this.imprimirNumero();		
	}

	@Override
	public void imprimirFormaDePago() {
		this.imprimirDatos();		
	}
	

}

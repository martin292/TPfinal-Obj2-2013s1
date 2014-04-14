package FormasDePago;

public class Debito extends Tarjeta {

	public Debito(String nom, String bank, int i) {
		super(nom, bank, i);
	}

	@Override
	public void imprimirDatos() {
		System.out.println("Tarjeta de debito");
		this.imprimirNombre();
		this.imprimirBanco();
		this.imprimirNumero();
	}

	@Override
	public void imprimirFormaDePago() {
		this.imprimirDatos();		
	}

}


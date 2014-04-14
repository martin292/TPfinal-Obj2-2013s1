package FormasDePago;

public class Efectivo extends FormaDePago {

	//Variables
	private String moneda;

	//Getters y Setters
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
	//Constructor
	public Efectivo(String m){
		this.setMoneda(m);
	}
	
	//Metodos
	public void imprimirMoneda(){
		System.out.println("Moneda: " + this.getMoneda());
	}
	@Override
	public void imprimirFormaDePago() {
		this.imprimirMoneda();
		
	}
	
}

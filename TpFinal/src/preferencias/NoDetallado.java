package preferencias;

import alojamiento.Hotel;

public class NoDetallado extends Lugar {

	//Variables
	private String pais;

	//Constructor
	public NoDetallado(String p){
		this.setPais(p);
	}
	
	//Getters y Setters
	private String getPais() {
		return pais;
	}
	private void setPais(String pais) {
		this.pais = pais;
	}

	@Override//Compara el lugar con el parametro
	public boolean compararLugarCon(Hotel h) {
		return this.getPais() == h.retPais();
	}

	@Override//Imprime el lugar
	public void imprimirLugar() {
		System.out.println("Pais: " + this.getPais());		
	}

	public String retPais() {
		return this.getPais();
	}
	
	
	
}


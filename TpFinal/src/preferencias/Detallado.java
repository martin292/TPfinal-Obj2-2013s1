package preferencias;

import alojamiento.Hotel;

public class Detallado extends Lugar {
	
	//Variables
	private String pais;
	private String ciudad;
	
	//Constructor
	public Detallado(String p, String c){
		this.setPais(p);
		this.setCiudad(c);
	}
	
	//Getters y Setters
	private String getPais() {
		return pais;
	}
	private void setPais(String pais) {
		this.pais = pais;
	}
	private String getCiudad() {
		return ciudad;
	}
	private void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override//Compara el lugar con el parametro
	public boolean compararLugarCon(Hotel h) {
		return this.getPais() == h.retPais() && this.getCiudad() == h.retCiudad();
	}

	@Override//Imprime el lugar
	public void imprimirLugar() {
		System.out.println("Pais: " + this.getPais());
		System.out.println("Ciudad: " + this.getCiudad());		
	}

	public String retPais() {
		return this.getPais();
	}

	public String retCiudad() {
		return this.getCiudad();
	}
	
		
	
}


package aDiary_data;

public class BusquedaDatos {


	private Dato datoBusqueda;
	private String valorDeDatoNuevo;
	
	public BusquedaDatos() {
		this.datoBusqueda = new Dato();
		this.valorDeDatoNuevo = "";
	}
	
	public BusquedaDatos(Dato dato, String value) {
		this.datoBusqueda = dato;
		this.valorDeDatoNuevo = "";
	}
	
	
	
}

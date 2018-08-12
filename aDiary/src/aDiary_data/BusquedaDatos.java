package aDiary_data;

import java.util.ArrayList;

public class BusquedaDatos {


	private Dato datoBusqueda;
	private String valorDeDato;
	
	public BusquedaDatos() {
		this.datoBusqueda = new Dato();
		this.valorDeDato = "";
	}
	
	public BusquedaDatos(Dato dato, String value) {
		this.datoBusqueda = dato;
		this.valorDeDato = value;
	}
	
	public BusquedaDatos(String value) {
		this.valorDeDato = value;
		this.datoBusqueda = new Dato();
	}
	
	private ArrayList<Dato> obtenerDatos(String rutaExcel) {
		ManejoDatos manejo = new ManejoDatos();
		manejo.solicitarDatos(rutaExcel);
		return manejo.getDatos();
	}
	
	public boolean buscarCoincidencia(String rutaExcel) {
		ArrayList<Dato> datos = obtenerDatos(rutaExcel);
		for(int i = 0; i <datos.size(); i++) {
			if(datos.get(i).getContenido().equals(this.valorDeDato)) {
				this.datoBusqueda = datos.get(i);
				return true;
			}
		}
		return false;
	}

	public Dato getDatoBusqueda() {
		return datoBusqueda;
	}

	public void setDatoBusqueda(Dato datoBusqueda) {
		this.datoBusqueda = datoBusqueda;
	}

	public String getValorDeDato() {
		return valorDeDato;
	}

	public void setValorDeDato(String valorDeDato) {
		this.valorDeDato = valorDeDato;
	}
	
	
	
	
}

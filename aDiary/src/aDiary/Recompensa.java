package aDiary;

import java.util.ArrayList;

public class Recompensa {

	private String nombreRecompensaElegida;
	private ArrayList<String> recompensas;

	public Recompensa() {
		recompensas = new ArrayList<String>();
		addRecompensasDefault();
		
	}

	public ArrayList<String> getRecompensa() {
		return recompensas;
	}

	public String getNombreRecompensaElegida() {
		return this.nombreRecompensaElegida;
	}
	public void setRecompensas(ArrayList<String> recompensas) {
		this.recompensas = recompensas;
	}

	public void setNombreRecompensaElegida(String nombreRecompensaElegida) {
		this.nombreRecompensaElegida = nombreRecompensaElegida;
	}

	private void addRecompensasDefault() {
		recompensas.add("Recompensa ejemplo");
	}

	public String seleccionarRecompensa(int posicion) { 
		return recompensas.get(posicion);
	}

	//public String toString() { //Arreglar
		//return algo;
	//}

}
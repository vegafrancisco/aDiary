package aDiary;

import java.util.ArrayList;

import aDiary_data.BusquedaDatos;
import aDiary_data.Dato;
import aDiary_data.ManejoDatos;

public class MenuPrincipal {

	private Dia misionesDia;
	private Propietario propietarioActivo;
	private double valorProgreso;

	public MenuPrincipal() {
		// TODO - implement MenuPrincipal.MenuPrincipal
		this.misionesDia = new Dia();
	}

	public Propietario getPropietarioActivo() {
		return this.propietarioActivo;
	}

	/**
	 * 
	 * @param propietarioActivo
	 */
	public void setPropietarioActivo(Propietario propietarioActivo) {
		this.propietarioActivo = propietarioActivo;
	}

	public Dia getMisionesDia() {
		return this.misionesDia;
	}

	/**
	 * 
	 * @param misionesDia
	 */
	public void setMisionesDia(Dia misionesDia) {
		this.misionesDia = misionesDia;
	}

	public double getValorProgreso() {
		return this.valorProgreso;
	}
	
	
	public void obtenerMisionesDia() {
		
		ManejoDatos manejo = new ManejoDatos();
		String rutaExcel = "./usrdata/" + this.propietarioActivo.getNombre() + "/" + this.propietarioActivo.getPerfilActivo();
		manejo.solicitarDatos(rutaExcel);
		ArrayList<Dato> data = manejo.getDatos();
		BusquedaDatos busqueda = new BusquedaDatos();
		busqueda.setValorDeDato(this.misionesDia.getFecha().toString());
		busqueda.buscarCoincidencia(rutaExcel);
		Dato fechaMision = encontrarCoincidencia(busqueda, data);
		
		if(fechaMision != null) {
			int fila = fechaMision.getFila();
			if(verificarDatosMision(fila, data)) {
				ArrayList <Dato> datosFiltrados = entregarDatosFiltrados(fila, data);
				Mision mision = new Mision(datosFiltrados.get(1).getContenido(), Boolean.valueOf(datosFiltrados.get(2).getContenido()));
				this.misionesDia.getMisiones().add(mision);
			}
			
		}
	}
	
	private Dato encontrarCoincidencia(BusquedaDatos busqueda, ArrayList<Dato> data) {
		for(int i = 0; i<data.size(); i++) {
			if(data.get(i).getContenido().equals(busqueda.getDatoBusqueda().getContenido())) {
				return data.get(i);
			}
		}
		return null;
			
	}
	
	private boolean verificarDatosMision(int fila, ArrayList<Dato> data) {
		int contador = 0;
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).getFila() == fila) {
				contador += 1;
			}
		}
		
		if(contador == 3) {
			return true;
		}else {
			return false;
		}
	}
	
	private ArrayList<Dato> entregarDatosFiltrados(int fila, ArrayList<Dato> data){
		ArrayList<Dato> datosFiltrados = new ArrayList<>();
		for(int i = 0; i<data.size(); i++) {
			if(data.get(i).getFila() == fila) {
				datosFiltrados.add(data.get(i));
			}
			
		}
		return datosFiltrados;
	}
	public void guardarMisionDia(Mision misionNueva) {
		
		ManejoDatos manejo = new ManejoDatos();
		manejo.añadirMision(misionNueva.getMision(), misionNueva.getIsCompleted(), 0);
	}

	/**
	 * 
	 * @param valorProgreso
	 */
	public void setValorProgreso(double valorProgreso) {
		this.valorProgreso = valorProgreso;
	}

	public double calcularProgreso() {
		// TODO - implement MenuPrincipal.calcularProgreso
		throw new UnsupportedOperationException();
	}

}
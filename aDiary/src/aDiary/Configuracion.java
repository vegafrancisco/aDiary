package aDiary;

import java.util.ArrayList;

import aDiary_data.BusquedaDatos;
import aDiary_data.Dato;
import aDiary_data.ManejoDatos;

public class Configuracion {

	private Propietario propietarioActivo;
	private Recompensa cajaRecompensas;

	public Configuracion() {

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

	public Recompensa getCajaRecompensas() {
		return this.cajaRecompensas;
	}

	/**
	 * 
	 * @param cajaRecompensas
	 */
	public void setCajaRecompensas(Recompensa cajaRecompensas) {
		this.cajaRecompensas = cajaRecompensas;
	}

	private void cleanDatosUsuario() {
		// TODO - implement Configuracion.cleanDatosUsuario
		ManejoDatos manejo = new ManejoDatos(this.propietarioActivo);
		manejo.eliminarDatosUsuario();
	}

	/**
	 * 
	 * @param nuevaRecompensa
	 */
	public void editarRecompensas(int posicion, String oldRecompensa ,String newRecompensa) {
		cajaRecompensas.seleccionarRecompensa(posicion).replace(oldRecompensa, newRecompensa);
	}

	public void guardarRecompensas() {
		// TODO - implement Configuracion.guardarRecompensas
		ManejoDatos manejo = new ManejoDatos();
		String rutaExcel = "./usrdata/" + this.propietarioActivo + "/recompensa.xlsx";
		manejo.solicitarDatos(rutaExcel);
		ArrayList<String> nuevasRecompensas = ignorarRecompensasRepetidas(manejo.getDatos(), rutaExcel);
		for(int i = 0; i<nuevasRecompensas.size();i++) {
			manejo.añadirRecompensa(nuevasRecompensas.get(i), 1);
		}
	}
	
	private ArrayList<String> ignorarRecompensasRepetidas(ArrayList<Dato> dato, String rutaExcel){
		ArrayList<String> datosFiltrados = this.cajaRecompensas.getRecompensa();
		String datoEncontrado;
		for(int i = 0; i<dato.size(); i++) {
			for(int j = 0; j<this.cajaRecompensas.getRecompensa().size(); j++) {
				BusquedaDatos busqueda = new BusquedaDatos(dato.get(i), this.cajaRecompensas.getRecompensa().get(j));
				if(busqueda.buscarCoincidencia(rutaExcel)) {
					datoEncontrado = this.cajaRecompensas.getRecompensa().get(j);
					datosFiltrados.remove(datoEncontrado);
				}
				
			}
	
		}
		return datosFiltrados;

	}
	public void cambiarEstadoControlParental(String contraseña, boolean activado) {
		// TODO - implement Configuracion.cambiarEstadoControlParental
		if(contraseña.equals(this.propietarioActivo.getContrasenaControlParental())) {
			this.propietarioActivo.setEstadoControlParental(activado);
		}
	}

}
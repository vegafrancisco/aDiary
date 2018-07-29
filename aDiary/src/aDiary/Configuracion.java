package aDiary;

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
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	public void cambiarEstadoControlParental() {
		// TODO - implement Configuracion.cambiarEstadoControlParental
		throw new UnsupportedOperationException();
	}

}
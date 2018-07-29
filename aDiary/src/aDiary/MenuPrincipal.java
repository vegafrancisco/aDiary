package aDiary;

public class MenuPrincipal {

	private Dia misionesDia;
	private Propietario propietarioActivo;
	private double valorProgreso;

	public MenuPrincipal() {
		// TODO - implement MenuPrincipal.MenuPrincipal
		throw new UnsupportedOperationException();
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
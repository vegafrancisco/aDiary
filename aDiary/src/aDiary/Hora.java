public class Hora {

	Mision mision;
	Dia dia;
	private String rangoHora;
	private String horaIni;
	private String horaFin;

	public String getRangoHora() {
		return this.rangoHora;
	}

	public Mision getMision() {
		return this.mision;
	}

	public String getHoraIni() {
		return this.horaIni;
	}

	public String getHoraFin() {
		return this.horaFin;
	}

	/**
	 * 
	 * @param rangoHora
	 */
	public void setRangoHora(String rangoHora) {
		this.rangoHora = rangoHora;
	}

	/**
	 * 
	 * @param mision
	 */
	public void setMision(Mision mision) {
		this.mision = mision;
	}

	/**
	 * 
	 * @param horaIni
	 */
	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}

	/**
	 * 
	 * @param horaFin
	 */
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String toString() {
		// TODO - implement Hora.toString
		throw new UnsupportedOperationException();
	}

}
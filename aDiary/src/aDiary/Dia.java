package aDiary;

import java.util.*;
import java.time.*;

public class Dia {

	//private Horario horario;
	//private Historial historial;
	private ArrayList<Mision> misiones;
	private LocalTime fecha;
	private int dia;

	public Dia() {
		// TODO - implement Dia.Dia
		setFecha(LocalTime.now());
		dia = 0;
		misiones = new ArrayList<>();
	}

	public ArrayList<Mision> getMisiones() {
		// TODO - implement Dia.getHoras
		throw new UnsupportedOperationException();
	}

	public String almacenarElementosDeHoras() {
		// TODO - implement Dia.almacenarElementosDeHoras
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		// TODO - implement Dia.toString
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the fecha
	 */
	public LocalTime getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalTime fecha) {
		this.fecha = fecha;
	}

}
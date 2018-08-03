package aDiary_data;

import aDiary.Propietario;
import java.io.File;

/**
 *
 * @author tonio
 */
public class CreacionCarpeta {
	
	private String rutaDirectorio;
	private boolean directorioCreado;
		
	public CreacionCarpeta(String rutaDirectorio) {
		this.rutaDirectorio = rutaDirectorio;
		this.directorioCreado = false;
	}
	
	public void crearCarpeta() {
		File file = new File(this.rutaDirectorio);
		this.directorioCreado = file.mkdirs();
	}

	public String getRutaDirectorio() {
		return rutaDirectorio;
	}

	public void setRutaDirectorio(String rutaDirectorio) {
		this.rutaDirectorio = rutaDirectorio;
	}

	public boolean isDirectorioCreado() {
		return directorioCreado;
	}

	public void setDirectorioCreado(boolean directorioCreado) {
		this.directorioCreado = directorioCreado;
	}
	
	
}

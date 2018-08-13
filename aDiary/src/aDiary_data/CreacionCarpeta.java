package aDiary_data;

import aDiary.Propietario;
import java.io.*;
import org.apache.poi.common.*;
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

	public void removerCarpetaYArchivos() {
		File file = new File(this.rutaDirectorio);
		try {
			eliminarArchivos(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void eliminarArchivos(File file) throws IOException{
		if (file.isDirectory()) {
		    for (File c : file.listFiles()) eliminarArchivos(c);
		}
	    if (!file.delete()) throw new FileNotFoundException("Error en eliminar el archivo: " + file); 
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

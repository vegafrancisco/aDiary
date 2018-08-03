package aDiary_data;

import aDiary.Propietario;

import my.jutils.poi.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tonio
 */
public class ManejoDatos {
	
	/* Metodo primera ejecución */
	public boolean init() {
		String rutaCarpeta = "./usrdatos";
		CreacionCarpeta initFolder = new CreacionCarpeta(rutaCarpeta);
		initFolder.crearCarpeta();
		if(initFolder.isDirectorioCreado()) {
			rutaCarpeta = "./usrdatos/usuarios.xlsx";
			HashMap map = new HashMap<Object, Object>();
	        CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,rutaCarpeta,"Hoja1",(Map)map);
			nuevoExcel.execute();
			return true;
		}else {
			return false;
		}
		
	}
	
    public void solicitarDatos(Propietario usr, int solicitud){
    	String rutaExcel = "";
        LecturaExcel read = new LecturaExcel();
        read.leerExcel(rutaExcel);
        if(!read.isEstadoLeerExcel()) {
        	//Falta caso en la que no exista carpeta que se "deba" crear.
        	
        	HashMap map = new HashMap<Object, Object>();
            CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,rutaExcel,"Hoja1",(Map)map);
            if(nuevoExcel.execute()) {
            	read.leerExcel(rutaExcel);
            }
        }
    }
    
    private void pasosCarpeta(Propietario usr) {
    	
    	String rutaUsuario = "./usrdata/" + usr.getNombre();
    	CreacionCarpeta carpeta = new CreacionCarpeta(rutaUsuario);
    	carpeta.crearCarpeta();
    	
    	if(!usr.getPerfiles().isEmpty()) {
    		for(int i = 0; i<usr.getPerfiles().size() ; i++) {
    			carpeta.setRutaDirectorio(rutaUsuario + "/" + usr.getPerfiles().get(i));
    			carpeta.crearCarpeta();
    		}
    	}
    	
    }
    
    
}
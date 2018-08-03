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
    
    private String elegirCarpeta(Propietario usr, int opcion) {
    	if(opcion == 1) {
    		return "./usrdata/";
    	}else if (opcion ==2) {
    		return "./usrdata/" + usr.getNombre(); 
    	} else {
    		return "";
    	}
    	
    }
    
    private void pasosCarpeta(Propietario usr, int opcion) {
    	String rutaCarpeta = elegirCarpeta(usr, opcion);
    	CreacionCarpeta newcarpet = new CreacionCarpeta(rutaCarpeta);
    	if(!usr.getPerfilActivo().equals("FLAG")) {
    		newcarpet.crearCarpeta();
    	}
    	
    }
}
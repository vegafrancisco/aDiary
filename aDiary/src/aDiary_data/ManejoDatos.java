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
	public void init() {
		CreacionCarpeta initFolder = new CreacionCarpeta();
		initFolder.crearCarpetaDatos();
		HashMap map = new HashMap<Object, Object>();
        CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,"./usrdatos","Hoja1",(Map)map);
		
	}
	
    public void solicitarDatos(Propietario usr, String rutaExcel){
    	nuevaCarpeta(usr, usr.getPerfilActivo());
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
    
    public void nuevaCarpeta(Propietario usr, String subUsr) {
    	CreacionCarpeta c = new CreacionCarpeta(usr, subUsr);
    	c.crearCarpetaUsuario();
    	c.crearCarpetaSubUsuario();
    }
}
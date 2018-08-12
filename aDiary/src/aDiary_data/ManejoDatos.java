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
	
	private ArrayList<Dato> datos;
	
	public ManejoDatos() {
		this.datos = new ArrayList<>();
	}
	
	/* Metodo primera ejecución */
	public void init() {
		String rutaCarpeta = "./usrdata";
		CreacionCarpeta initFolder = new CreacionCarpeta(rutaCarpeta);
		initFolder.crearCarpeta();
		rutaCarpeta = "./usrdata/usuarios.xlsx";
		HashMap map = new HashMap<Object, Object>();
        CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,rutaCarpeta,"Hoja1",(Map)map);
		nuevoExcel.execute();		
	}
	
    public void solicitarDatos(String rutaExcel){
        LecturaExcel read = new LecturaExcel();
        read.leerExcel(rutaExcel);
        if(!read.isEstadoLeerExcel()) {
        	//Falta caso en la que no exista carpeta que se "deba" crear.
        	
        	HashMap map = new HashMap<Object, Object>();
            CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,rutaExcel,"Hoja1",(Map)map);
            if(nuevoExcel.execute()) {
            	read.leerExcel(rutaExcel);
            }
        }else {
        	this.datos = read.getDatos();
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

	public ArrayList<Dato> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Dato> datos) {
		this.datos = datos;
	}
    
    
    
    
    
}
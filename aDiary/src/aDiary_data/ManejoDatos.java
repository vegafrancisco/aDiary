package aDiary_data;

import aDiary.Propietario;

import my.jutils.poi.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tonio
 */
public class ManejoDatos {
	
	private ArrayList<Dato> datos;
	private Propietario usrDato;
	
	public ManejoDatos() {
		this.datos = new ArrayList<>();
		this.usrDato = null;
	}
	
	public ManejoDatos(Propietario usrDato) {
		this.usrDato = usrDato;
		this.datos = new ArrayList<>();
	}
	
	/* Metodo primera ejecución */
	public boolean init() {
		File flag = new File("./flag");
		
		if(!flag.exists()) {
		
			try {
				flag.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			String rutaCarpeta = "./usrdata";
			CreacionCarpeta initFolder = new CreacionCarpeta(rutaCarpeta);
			initFolder.crearCarpeta();
			String rutaExcel = rutaCarpeta + "/usuarios.xlsx";
			HashMap map = new HashMap<Object, Object>();
			CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,rutaExcel,"Hoja1",(Map)map);
			nuevoExcel.execute();
			ModExcel template = new ModExcel();
	    	template.moldearExcel(rutaExcel, 2, 0);
			return true;
		}
		return false;
	}
	
    public boolean solicitarDatos(String rutaExcel){
        LecturaExcel read = new LecturaExcel();
        read.leerExcel(rutaExcel);
        if(!read.isEstadoLeerExcel()) {
        	return true;
        }else {
        	this.datos = read.getDatos();
        	return false;
        }
    }
    
    public boolean modificarDato(String valorNuevo,String valorAntiguo, String rutaExcel, int hoja) {
    	ModExcel mod = new ModExcel(valorNuevo, valorAntiguo);
    	return mod.modificarCelda(rutaExcel, hoja);
    }
    
    public boolean añadirMision(String mision, String estado, int hoja) {
    	String rutaExcel = "./usrdata/" + this.usrDato.getNombre() + "/" + this.usrDato.getPerfilActivo()+"/misiones.xlsx";
    	ModExcel mod = new ModExcel(mision, "");
    	if(mod.modificarCelda(rutaExcel, hoja)) {
    		mod.setValorNuevo(estado);
    		return mod.modificarCelda(rutaExcel, hoja);
    	}else {
    		return false;
    	}
    }
    
    public boolean añadirRecompensa(String recompensa, int hoja) {
    	String rutaExcel = "./usrdata/" + this.usrDato.getNombre() + "/recompensa.xlsx";	
    	ModExcel mod = new ModExcel(recompensa, "");
    	mod.prepararCeldas(rutaExcel, 1,0);
    	return mod.modificarCelda(rutaExcel, hoja);
    }
    
    public boolean añadirUsuario(String usuario, String contraseña, int hoja) {
    	String rutaExcel = "./usrdata/usuarios.xlsx";
    	ModExcel mod = new ModExcel(usuario, ""); 
    	mod.prepararCeldas(rutaExcel, 2,0);
    	if(mod.modificarCelda(rutaExcel, hoja)) {
    		mod.setValorNuevo(contraseña);
    		return mod.modificarCelda(rutaExcel, hoja);
    	}else {
    		return false;
    	}
    }
    
    /*private void pasosCarpeta() {
    	String rutaUsuario = "./usrdata/" + usrDato.getNombre();
    	CreacionCarpeta carpeta = new CreacionCarpeta(rutaUsuario);
    	carpeta.crearCarpeta();
    	
    	if(!usrDato.getPerfiles().isEmpty()) {
    		for(int i = 0; i<usrDato.getPerfiles().size() ; i++) {
    			carpeta.setRutaDirectorio(rutaUsuario + "/" + usrDato.getPerfiles().get(i));
    			carpeta.crearCarpeta();
    		}
    	}
    	
    }*/
    
    public void crearArchivosPerfil(String perfilACrear) {
    	String rutaUsuario = "./usrdata/" + this.usrDato.getNombre() + "/" + perfilACrear;
    	CreacionCarpeta carpeta = new CreacionCarpeta(rutaUsuario);
    	carpeta.crearCarpeta();
    	crearExcelMisiones(rutaUsuario + "/misiones.xlsx");
    }
    
    private void crearExcelMisiones(String rutaExcel) {
    	//String rutaExcel = "./usrdata/" + this.usrDato.getNombre() + "/" + this.usrDato.getPerfilActivo()+"/misiones.xlsx";
    	HashMap map = new HashMap<Object, Object>();
    	CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,rutaExcel,"Hoja1",(Map)map);
    	nuevoExcel.execute();
    	
    }
    
    public void crearExcelRecompensa(){
    	String rutaExcel = "./usrdata/" + this.usrDato.getNombre() + "/recompensas.xlsx";
    	HashMap map = new HashMap<Object, Object>();
    	CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,rutaExcel,"Hoja1",(Map)map);
    	nuevoExcel.execute();
    }

	public ArrayList<Dato> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Dato> datos) {
		this.datos = datos;
	}

	public Propietario getUsrDato() {
		return usrDato;
	}

	public void setUsrDato(Propietario usrDato) {
		this.usrDato = usrDato;
	}
	
    
}
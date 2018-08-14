package aDiary_data;

import aDiary.Propietario;

import my.jutils.poi.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
	    	template.moldearExcel(rutaExcel, 5, 0);
	    	template.setValorNuevo("admin");
	    	if(template.modificarCelda(rutaExcel, 0)) {
	    		template.setValorNuevo("admin");
	    		if(template.modificarCelda(rutaExcel, 0)) {
	    			template.setValorNuevo("default");
	    			if(template.modificarCelda(rutaExcel, 0)) {
	    				template.setValorNuevo(booleanAString(false));
	    				if(template.modificarCelda(rutaExcel, 0)) {
	    					template.setValorNuevo("admin");
	    					template.modificarCelda(rutaExcel, 0);
	    				}
	    			}
	    		}
	    	}
	    	
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
    
    public boolean añadirUsuario(String usuario, String contraseña, String perfil,boolean estadoControl, String contraseñaControlParental, int hoja) {
    	String rutaExcel = "./usrdata/usuarios.xlsx";
    	ModExcel mod = new ModExcel(usuario, ""); 
    	mod.prepararCeldas(rutaExcel, 5,0);
    	if(mod.modificarCelda(rutaExcel, hoja)) {
    		mod.setValorNuevo(contraseña);
    		if(mod.modificarCelda(rutaExcel, hoja)) {
    			mod.setValorNuevo(perfil);
    			if(mod.modificarCelda(rutaExcel, hoja)) {
    				mod.setValorNuevo(booleanAString(estadoControl));
    				if(mod.modificarCelda(rutaExcel, hoja)) {
    					mod.setValorNuevo(contraseñaControlParental);
    					return mod.modificarCelda(rutaExcel, hoja);
    				}else {
    					return false;
    				}
    			}else {
    				return false;
    			}
    		} else {
    			return false;
    		}
    	}else {
    		return false;
    	}
    }
    
    public boolean añadirPerfil(ArrayList<String> listaPerfiles, String perfilNuevo) {
    	String rutaExcel = "./usrdata/usuarios.xlsx";
    	String perfilConcatenado = "";
    	String lineaPerfiles = "";
    	if(listaPerfiles.isEmpty()) {
    		perfilConcatenado = perfilNuevo;
    	}else {
    		for(int i = 0; i<listaPerfiles.size(); i++) {
    			lineaPerfiles = listaPerfiles.get(i) + ";";
    		}
    		perfilConcatenado = lineaPerfiles +  perfilNuevo + ";";
    	}
    	ModExcel mod = new ModExcel(perfilConcatenado, lineaPerfiles);
    	return mod.modificarCelda(rutaExcel, 0);
    }
    
    public void crearArchivosPerfil(String perfilACrear) {
    	String rutaUsuario = "./usrdata/" + this.usrDato.getNombre() + "/" + perfilACrear;
    	CreacionCarpeta carpeta = new CreacionCarpeta(rutaUsuario);
    	carpeta.crearCarpeta();
    	crearExcelMisiones(rutaUsuario + "/misiones.xlsx");
    }
    
    private void crearExcelMisiones(String rutaExcel) {
    	//String rutaExcel = "./usrdata/" + this.usrDato.getNombre() + "/" + this.usrDato.getPerfilActivo()+"/misiones.xlsx";
    	HashMap map = new HashMap<Object, Object>();
    	CreateExcel nuevoExcel = new CreateExcel("./templateMisiones.xlsx",0,rutaExcel,"Hoja1",(Map)map);
    	nuevoExcel.execute();
    	
    }
    
    private void moldearExcelMisiones(String rutaExcel) {
    	Calendar calendario = Calendar.getInstance();
    	calendario.getTime();
    }
    
    public void crearExcelRecompensa(){
    	String rutaExcel = "./usrdata/" + this.usrDato.getNombre() + "/recompensas.xlsx";
    	HashMap map = new HashMap<Object, Object>();
    	CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,rutaExcel,"Hoja1",(Map)map);
    	nuevoExcel.execute();
    }
    
    public void eliminarDatosUsuario() {
    	String rutaCarpeta = "./usrdata/" +  this.usrDato.getNombre();
    	CreacionCarpeta eliminar = new CreacionCarpeta(rutaCarpeta);
    	eliminar.removerCarpetaYArchivos();
    	crearArchivosPerfil("admin-" + this.usrDato.getNombre());
    }

    public Propietario creacionPropietario(String nombre, String contraseña) {
    	String rutaExcel = "./usrdata/usuarios.xlsx";
    	BusquedaDatos busqueda = new BusquedaDatos();
    	busqueda.setValorDeDato(nombre);
    	if(busqueda.buscarCoincidencia(rutaExcel)) {
    		Propietario lecturaUsr = new Propietario();
    		LecturaExcel lecturaDeCeldas = new LecturaExcel();
    		try {
				lecturaDeCeldas.readContenidoCelda(busqueda.getDatoBusqueda().getFila(), busqueda.getDatoBusqueda().getColumna(), rutaExcel);
				lecturaUsr.setNombre(lecturaDeCeldas.getContenidoCelda());
				lecturaDeCeldas.readContenidoCelda(busqueda.getDatoBusqueda().getFila(), busqueda.getDatoBusqueda().getColumna()+1, rutaExcel);
				lecturaUsr.setContrasena(lecturaDeCeldas.getContenidoCelda());
				lecturaDeCeldas.readContenidoCelda(busqueda.getDatoBusqueda().getFila(), busqueda.getDatoBusqueda().getColumna()+2, rutaExcel);
				lecturaUsr.setPerfiles(separarPerfiles(lecturaDeCeldas.getContenidoCelda()));
				lecturaDeCeldas.readContenidoCelda(busqueda.getDatoBusqueda().getFila(), busqueda.getDatoBusqueda().getColumna()+3, rutaExcel);
				lecturaUsr.setEstadoControlParental(estadosABoolean(lecturaDeCeldas.getContenidoCelda()));
				lecturaDeCeldas.readContenidoCelda(busqueda.getDatoBusqueda().getFila(), busqueda.getDatoBusqueda().getColumna()+4, rutaExcel);
				lecturaUsr.SetContrasenaControlParental(lecturaDeCeldas.getContenidoCelda());
				return lecturaUsr;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return null;
    }
    
    private ArrayList<String> separarPerfiles(String perfiles){
    	String[] splitStr = perfiles.split(";");
    	ArrayList<String> coleccionPerfiles = new ArrayList<>();
    	coleccionPerfiles.toArray(splitStr);
    	return coleccionPerfiles;
    }
    
    private boolean estadosABoolean(String estado) {
    	switch(estado) {
    		case "true":
    			return true;
    		case "false":
    			return false;
    		default:
    			return false;
    	}
    }
    
    private String booleanAString(boolean estado) {
    	if(estado) {
    		return "true";
    		
    	}else {
    		return "false";
    	}
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
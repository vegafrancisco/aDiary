package aDiary_data;

import aDiary.Propietario;
import java.io.File;

/**
 *
 * @author tonio
 */
public class CreacionCarpeta {
    private Propietario Usuario;
    private String nombreSubUsuario;
    private File directorioUsr;
    private File directorioSubUsr;
    
    
    public CreacionCarpeta(Propietario nombreUsuario, String nombreSubUsuario){
        this.nombreSubUsuario = nombreSubUsuario;
        this.Usuario = nombreUsuario;
    }
    
    public CreacionCarpeta(){
        this.nombreSubUsuario = "";
        this.Usuario = null;
    }
    
    public void setUsuario(Propietario usuario) {
        this.Usuario = usuario;
    }

    public void setNombreSubUsuario(String nombreSubUsuario) {
        this.nombreSubUsuario = nombreSubUsuario;
    }

    public Propietario getNombreUsuario() {
        return this.Usuario;
    }

    public String getNombreSubUsuario() {
        return this.nombreSubUsuario;
    }
    
    public void crearCarpetaDatos(){
        File usrData = new File("./usrdata/");
        usrData.mkdirs();
    }
    
    public void crearCarpetaUsuario(){
        this.directorioUsr = new File("./usrdata/" + this.Usuario.getNombre());
        this.directorioUsr.mkdirs();
    }
    
    public void crearCarpetaSubUsuario(){
    	this.directorioSubUsr = new File("./usrdata/" + this.Usuario.getNombre() + "/" +  this.nombreSubUsuario);
   		this.directorioSubUsr.mkdirs();
    	
    }
}

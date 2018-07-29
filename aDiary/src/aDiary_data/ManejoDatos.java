package aDiary_data;

import aDiary.Propietario;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author tonio
 */
public class ManejoDatos {
    
    public String solicitarDatos(Propietario usr, String rutaArchivo){
        LecturaExcel read = new LecturaExcel();
        read.leerExcel(usr, rutaArchivo);
        ArrayList data;
        if (read.isEstadoLeerExcel()){
            data = read.getDatos();
            
        }
        
        
        return "";
    }
    
}
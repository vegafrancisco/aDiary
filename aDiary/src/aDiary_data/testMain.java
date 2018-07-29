package aDiary_data;

import org.junit.runner.notification.Failure;

import aDiary.Propietario;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LecturaExcelTest test = new LecturaExcelTest();
		test.testNoFile();
		
		
		
		/*Propietario p = new Propietario();
		
		CreacionCarpeta c = new CreacionCarpeta(p, "");
        
        c.crearCarpetaUsuario();
        LecturaExcel l = new LecturaExcel();
        
        l.leerExcel(p, "./usrdata/" + p.getNombre() + "/misiones.xlsx"); */

	}

}

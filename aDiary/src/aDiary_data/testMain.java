package aDiary_data;

import aDiary.Propietario;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Propietario p = new Propietario();
		p.setNombre("Test");
		CreacionCarpeta c = new CreacionCarpeta(p, "");
        
        c.crearCarpetaUsuario();
        LecturaExcel l = new LecturaExcel();
        
        l.leerExcel(p, "./usrdata/" + p.getNombre() + "/misiones.xlsx");

	}

}

package aDiary_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import aDiary.Propietario;
import aDiary_data.ManejoDatos;

public class ManejoDatosTest {

	//@Ignore("Test only for first run")
	@Test
	public void testInit() {
		ManejoDatos manejo = new ManejoDatos();
		System.out.println(manejo.init());
	}

	
	@Test
	public void testLecturaMisionesUsuario() {
		Propietario usr = new Propietario();
		usr.setNombre("Test");
		
		String rutaExcel = "./usrdata/" + usr.getNombre() + "/misiones.xlsx";
		
		ManejoDatos manejo = new ManejoDatos(usr);
		
		manejo.solicitarDatos(rutaExcel);
		
		for(int i = 0; i<manejo.getDatos().size(); i++) {
			System.out.println("testLecturaMisionesUsuario: " + manejo.getDatos().get(i));
		}
		
	}
	
	@Ignore("outdated")
	public void testFail() {
		
		Propietario usr = new Propietario();
		usr.setNombre("Test");
		
		String rutaExcel = "./nothing";
		
		ManejoDatos manejo = new ManejoDatos();
		
		
	}
	
	@Ignore("not yet implemented")
	public void testCarpetas() {
		Propietario usr = new Propietario();
		ArrayList<String> a = new ArrayList<>(); 
	}
	
	@Test
	public void testLecturaUsuarios() {
		ManejoDatos manejo = new ManejoDatos();
		manejo.solicitarDatos("./usrdata/usuarios.xlsx");
		for(int i = 0; i<manejo.getDatos().size(); i++) {
			System.out.println(manejo.getDatos().get(i));
		}
	}
	
	
}

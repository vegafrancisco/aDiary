package aDiary_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import aDiary.Propietario;
import aDiary_data.ManejoDatos;

public class ManejoDatosTest {

	@Ignore("outdated")
	public void test() {
		Propietario usr = new Propietario();
		usr.setNombre("Test");
		
		String rutaExcel = "./usrData/" + usr.getNombre() + "/misiones.xlsx";
		
		ManejoDatos manejo = new ManejoDatos();
		
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
	public void testInit() {
		ManejoDatos manejo = new ManejoDatos();
		manejo.init();
	}

}

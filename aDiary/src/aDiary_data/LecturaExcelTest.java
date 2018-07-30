package aDiary_data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aDiary.Propietario;

public class LecturaExcelTest {

	

	@Test
	public void testNoFile() {
		LecturaExcel l = new LecturaExcel();
		Propietario usr = new Propietario();
		usr.setNombre("Test");
		String rutaExcel = "./nothing";
		l.leerExcel(usr, rutaExcel);
		assertEquals(true ,l.isEstadoLeerExcel());
	}

}

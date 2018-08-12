package aDiary_test;

import static org.junit.Assert.*;

import org.junit.Test;
import aDiary.Login;

public class LoginTest {

	@Test
	public void testLogin() {
		//Se asume excel usuarios creados
		Login login = new Login();
		login.setNombreIngresado("Antonio");
		login.setContrasenaIngresada("Ayres");
		if(login.validarLogin()) {
			System.out.println("Operacion exitosa");
		}else {
			System.out.println("Usuario o Contraseña erroneos");
		}
	}

}

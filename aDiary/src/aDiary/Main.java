package aDiary;

import java.time.*;

import aDiary_GUI.Login_GUI_exp;

public class Main {
 
	
	public static void main(String[]args) {
		Login_GUI_exp ini = new Login_GUI_exp("Iniciar Sesion");
		ini.setVisible(true);
		LocalDate local = LocalDate.now();
		System.out.println(local);
	}
}

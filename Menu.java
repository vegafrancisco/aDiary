package aDiary;
import java.util.Scanner;

public class Menu {

	MisionesDia m;
	
	public Menu(){
		this.m = new MisionesDia();
	}
	
	
	public void menuPrincipal() {
	
		Scanner sc = new Scanner(System.in);
		int opcn = 0;
		do {
		System.out.println("1.- Agregar misión");
		System.out.println("2.- Completar misión");
		System.out.println("3.- Quitar misión");
		System.out.println("4.- Ver misiones");
		System.out.println("5.- Salir corriendo");
		opcn = sc.nextInt();
		} while( opcn< 0 && opcn >= 5); 
		elegirOpcion(opcn);
	}
	
	public void elegirOpcion(int opcn) {
		switch(opcn) {
		
		case 1:
			agregarMision();
			break;
		
		case 2:
			completarMision();
			break;
			 
		case 3: 
			quitarMision();
			break;
		
		case 4:
			verMisiones();
			break;
		
		case 5: 
			System.exit(0);
		}
		menuPrincipal();
	}
	
	public void agregarMision() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la misión persona querida");
		String mision = sc.nextLine();
		this.m.agregarMision(mision, false);
	}
	
	public void quitarMision() {
		Scanner sc = new Scanner(System.in);
		verMisiones();
		System.out.println("Que misión desea eliminar");
		int i = sc.nextInt();
		this.m.quitarMision(i-1);
		
	}
	
	public void verMisiones() {
		System.out.println(this.m.toString());
	}
	
	public void completarMision() {
		verMisiones();
		Scanner sc = new Scanner(System.in);
		Recompensa z = new Recompensa();
		
		System.out.println("Qué misión completo muchacho");
		int eleccion = sc.nextInt();
		m.getMisiones().get(eleccion-1).setIsCompleted(true);
		z.mostrar();
		
	}
	
	}



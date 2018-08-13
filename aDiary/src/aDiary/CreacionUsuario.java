package aDiary;

import aDiary_data.ManejoDatos;

public class CreacionUsuario {

	
	private String nombreUsrNuevo;
	private String contrasenaUsrNuevo;
	private String perfilNuevo;

	public CreacionUsuario() {
		// TODO - implement CreacionUsuario.CreacionUsuario
		
	}

	

	public String getNombreUsrNuevo() {
		return this.nombreUsrNuevo;
	}

	/**
	 * 
	 * @param nombreUsrNuevo
	 */
	public void setNombreUsrNuevo(String nombreUsrNuevo) {
		this.nombreUsrNuevo = nombreUsrNuevo;
	}

	public String getContrasenaUsrNuevo() {
		return this.contrasenaUsrNuevo;
	}

	/**
	 * 
	 * @param contrasenaUsrNuevo
	 */
	public void setContrasenaUsrNuevo(String contrasenaUsrNuevo) {
		this.contrasenaUsrNuevo = contrasenaUsrNuevo;
	}

	/**
	 * 
	 * @param contraseñaVerificadora
	 */
	private boolean verificarContraseña(String contraseñaVerificadora) {
		// TODO - implement CreacionUsuario.verificarContrasena
		return contraseñaVerificadora.equals(contrasenaUsrNuevo);
		
	}

	/**
	 * 
	 * @param contraseñaVerificadora
	 */
	public Propietario crearUsuario(String contraseñaVerificadora) {
		// TODO - implement CreacionUsuario.crearUsuario
		if(verificarContraseña(contraseñaVerificadora)) {
			Propietario usr = new Propietario();
			usr.setNombre(this.nombreUsrNuevo);
			usr.setContrasena(this.nombreUsrNuevo);
			if(this.perfilNuevo != "default" && this.perfilNuevo != "") {
				usr.setPerfilActivo(this.perfilNuevo);
			}
			return usr;
		}
		return null;
	}

	public void guardarUsuario(Propietario usr) {
		// TODO - implement CreacionUsuario.guardarUsuario
		ManejoDatos manejo = new ManejoDatos(usr);
		manejo.añadirUsuario(this.getNombreUsrNuevo(), this.getContrasenaUsrNuevo(), 0);
		manejo.crearArchivosPerfil(usr.getPerfilActivo());
		manejo.crearExcelRecompensa();
	}

	/**
	 * 
	 * @param perfil
	 */
	public void añadirPerfil(String perfil) {
		// TODO - implement CreacionUsuario.añadirPerfil
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param activado
	 */
	public void activarControlParental(boolean activado) {
		// TODO - implement CreacionUsuario.activarControlParental
		throw new UnsupportedOperationException();
	}



	public String getPerfilNuevo() {
		return perfilNuevo;
	}



	public void setPerfilNuevo(String perfilNuevo) {
		this.perfilNuevo = perfilNuevo;
	}
	
	

}
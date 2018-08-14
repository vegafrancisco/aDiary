package aDiary_GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import aDiary.MenuPrincipal;
import aDiary.Propietario;

public class MenuPrincipal_GUI extends JFrame implements ActionListener{
	
	private MenuPrincipal menu;
	private JButton horarioButton;
	private JButton historialButton;
	private JButton configuracionButton;
	private JButton usuarioButton;
	private JProgressBar progresoMisiones;
	
	private Propietario usrActivo;
	
	
	public MenuPrincipal_GUI(String nombreUsr, String title) {
		super(title);
		initComponents(nombreUsr);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		elementSize();
		addWindow();
		
		this.historialButton.addActionListener(this);
		this.horarioButton.addActionListener(this);
		this.configuracionButton.addActionListener(this);
		this.usuarioButton.addActionListener(this);
	}
	
	public void initComponents(String nombreUsr) {
		this.horarioButton = new JButton("Horario");
		this.historialButton = new JButton("Historial de misiones");
		this.configuracionButton = new JButton("Configuración");
		this.usuarioButton = new JButton(nombreUsr);
	
	}
	
	public void elementSize() {
		this.setSize(800,480);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		this.horarioButton.setBounds(550, 80, 150, 35);
		this.historialButton.setBounds(550, 140, 150, 35);
		this.configuracionButton.setBounds(550, 200, 150, 35);
		this.usuarioButton.setBounds(550, 320, 150, 70);
	}
	
	private void addWindow() {
		this.add(this.historialButton);
		this.add(this.horarioButton);
		this.add(this.configuracionButton);
		this.add(this.usuarioButton);
		this.add(new JLabel());
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == this.configuracionButton) {
			Config_GUI config = new Config_GUI("Configurción");
			config.setUsrActivo(this.usrActivo);
			config.setVisible(true);
			this.dispose();
		}
	}

	/**
	 * @return the usrActivo
	 */
	public Propietario getUsrActivo() {
		return usrActivo;
	}

	/**
	 * @param usrActivo the usrActivo to set
	 */
	public void setUsrActivo(Propietario usrActivo) {
		this.usrActivo = usrActivo;
	}

}

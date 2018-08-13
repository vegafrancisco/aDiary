package aDiary_GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import aDiary.Login;
import aDiary.Propietario;
import aDiary_data.ManejoDatos;

public class Login_GUI_exp extends JFrame implements ActionListener{

	private JButton ingresoButton;
	private JButton creacionUsuarioButton;
    private JTextField nombreUsuarioTF;
    private JPasswordField contraseñaTF;
    private JLabel nombreUsuarioLabel;
    private JLabel contraseñaLabel;
    
    public Login_GUI_exp(String title){
        super(title);
        
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        elementSize();
        addWindow();
        
        this.ingresoButton.addActionListener(this);
    }
    
    public void initComponents(){
        this.contraseñaLabel = new JLabel("Contraseña");
        this.nombreUsuarioLabel = new JLabel("Usuario");
        this.nombreUsuarioTF = new JTextField("");
        this.contraseñaTF = new JPasswordField("");
        this.ingresoButton = new JButton("INGRESAR");
        this.creacionUsuarioButton = new JButton("CREAR CUENTA");
    }
    
    public void elementSize(){
    	this.setSize(260, 350);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.nombreUsuarioLabel.setBounds(50, 30, 150, 25);
        this.nombreUsuarioTF.setBounds(50, 60, 150, 25);
        this.contraseñaLabel.setBounds(50, 100, 150, 25);
        this.contraseñaTF.setBounds(50, 130, 150, 25);
        this.ingresoButton.setBounds(50, 200, 150, 35);
        this.creacionUsuarioButton.setBounds(50, 250, 150, 35);
    }
    
    public void addWindow(){
        this.add(this.nombreUsuarioLabel);
        this.add(this.nombreUsuarioTF);
        this.add(this.contraseñaLabel);
        this.add(this.contraseñaTF);
        this.add(this.ingresoButton);
        this.add(this.creacionUsuarioButton);
        this.add(new JLabel());
    }

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == this.ingresoButton) {
			Login login = new Login();
			login.setNombreIngresado(this.nombreUsuarioTF.getText());
			String password = new String(this.contraseñaTF.getPassword());
			login.setContrasenaIngresada(password);
			if(login.validarLogin()) {
				JOptionPane.showMessageDialog(this, "Operacion exitosa");
				ManejoDatos manejo = new ManejoDatos();
				Propietario usr = manejo.creacionPropietario(login.getNombreIngresado(), login.getContrasenaIngresada());
				JOptionPane.showMessageDialog(this, usr);
				System.out.println(usr);
				//NEW VENTANA!
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "Usuario o Contraseña erroneos");
			}
		}
	}
    
}

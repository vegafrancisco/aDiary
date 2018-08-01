package aDiary_GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login_GUI extends JFrame{

	private JButton ingresoButton;
    private JTextField nombreUsuarioTF;
    private JTextField contraseñaTF;
    private JLabel nombreUsuarioLabel;
    private JLabel contraseñaLabel;
    
    public Login_GUI(String title){
        super(title);
        
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        elementSize();
        addWindow();
    }
    
    public void initComponents(){
        this.contraseñaLabel = new JLabel("Contraseña");
        this.nombreUsuarioLabel = new JLabel("Usuario");
        this.nombreUsuarioTF = new JTextField("");
        this.contraseñaTF = new JTextField("");
        this.ingresoButton = new JButton("INGRESAR");
    }
    
    public void elementSize(){
        this.setSize(260, 300);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.nombreUsuarioLabel.setBounds(50, 30, 150, 25);
        this.nombreUsuarioTF.setBounds(50, 60, 150, 25);
        this.contraseñaLabel.setBounds(50, 100, 150, 25);
        this.contraseñaTF.setBounds(50, 130, 150, 25);
        this.ingresoButton.setBounds(50, 200, 150, 35);
    }
    
    public void addWindow(){
        this.add(this.nombreUsuarioLabel);
        this.add(this.nombreUsuarioTF);
        this.add(this.contraseñaLabel);
        this.add(this.contraseñaTF);
        this.add(this.ingresoButton);
        this.add(new JLabel());
    }
    
}

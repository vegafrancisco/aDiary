/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aDiary_GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author hypoc
 */
public class EditarPerfil_GUI extends JFrame{
    private JButton cambiarPassButton;
    private JButton cambiarNombreButton;
    private JButton agregarPerfilButton;
    private JButton quitarPerfilButton;
    private JLabel editarPerfilLabel;
    
    public EditarPerfil_GUI(String title){
        super(title);
        
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        elementSize();
        addWindow();
    }
    
    public void initComponents(){
        this.cambiarPassButton = new JButton("CAMBIAR CONTRASEÑA");
        this.cambiarNombreButton = new JButton("CAMBIAR NOMBRE PROPIETARIO");
        this.agregarPerfilButton = new JButton("AGREGAR PERFIL");
        this.quitarPerfilButton = new JButton("QUITAR PERFIL");
        this.editarPerfilLabel = new JLabel("EDITAR PERFIL");
    }
    
    public void elementSize(){
        this.setSize(280, 300);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.cambiarPassButton.setBounds(30, 60, 200, 25);
        this.cambiarNombreButton.setBounds(30, 100, 200, 25);
        this.agregarPerfilButton.setBounds(30, 100, 200, 25);
        this.quitarPerfilButton.setBounds(30, 100, 200, 25);
        this.editarPerfilLabel.setBounds(80, 30, 200, 25);
    }
    
    public void addWindow(){
        this.add(this.cambiarPassButton);
        this.add(this.cambiarNombreButton);
        this.add(this.agregarPerfilButton);
        this.add(this.quitarPerfilButton);
        this.add(this.editarPerfilLabel);
        this.add(new JLabel());
    }
    
}

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
public class ControlParental_GUI extends JFrame{
    private JButton editarPassButton;
    private JButton activarControlButton;
    private JLabel controlLabel;
    
    public ControlParental_GUI(String title){
        super(title);
        
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        elementSize();
        addWindow();
    }
    
    public void initComponents(){
        this.editarPassButton = new JButton("EDITAR CONTRASEÑA");
        this.activarControlButton = new JButton("ACTIVAR CONTROL PARENTAL");
        this.controlLabel = new JLabel("CONTROL PARENTAL");
    }
    
    public void elementSize(){
        this.setSize(280, 300);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.editarPassButton.setBounds(30, 60, 200, 25);
        this.activarControlButton.setBounds(30, 100, 200, 25);
        this.controlLabel.setBounds(80, 30, 200, 25);
    }
    
    public void addWindow(){
        this.add(this.editarPassButton);
        this.add(this.activarControlButton);
        this.add(this.controlLabel);
        this.add(new JLabel());
    }
}

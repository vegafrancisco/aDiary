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
public class Config_GUI extends JFrame{
    private JButton controlParentalButton;
    private JButton reiniciarProgramaButton;
    private JButton editarRecompensaButton;
    private JButton ayudaButton;
    private JLabel configLabel;
    
    public Config_GUI(String title){
        super(title);
        
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        elementSize();
        addWindow();
    }
    
    public void initComponents(){
        this.controlParentalButton = new JButton("CONTROL PARENTAL");
        this.reiniciarProgramaButton = new JButton("REINICIAR PROGRAMA");
        this.editarRecompensaButton = new JButton("EDITAR RECOMPENSAS");
        this.ayudaButton = new JButton("AYUDA");
        this.configLabel = new JLabel("CONFIGURACION");
    }
    
    public void elementSize(){
        this.setSize(280, 300);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.controlParentalButton.setBounds(30, 60, 200, 25);
        this.reiniciarProgramaButton.setBounds(30, 100, 200, 25);
        this.editarRecompensaButton.setBounds(30, 140, 200, 25);
        this.ayudaButton.setBounds(30, 180, 200, 25);
        this.configLabel.setBounds(80, 30, 200, 25);
    }
    
    public void addWindow(){
        this.add(this.controlParentalButton);
        this.add(this.reiniciarProgramaButton);
        this.add(this.editarRecompensaButton);
        this.add(this.ayudaButton);
        this.add(this.configLabel);
        this.add(new JLabel());
    }
}

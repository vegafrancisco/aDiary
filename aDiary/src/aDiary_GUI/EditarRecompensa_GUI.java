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
public class EditarRecompensa_GUI extends JFrame{
    private JLabel editarRecompensaLabel;
    private JButton guardarButton;
    private TextArea recompensaArea;
    
    public EditarRecompensa_GUI(String title){
        super(title);
        
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        elementSize();
        addWindow();
    }
    
    public void initComponents(){
        this.editarRecompensaLabel = new JLabel("EDITAR RECOMPENSAS");
        this.guardarButton = new JButton("GUARDAR");
        this.recompensaArea = new TextArea("");
    }
    
    public void elementSize(){
        this.setSize(280, 300);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.editarRecompensaLabel.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        this.guardarButton.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        this.recompensaArea.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
    }
    
    public void addWindow(){
        this.add(this.editarRecompensaLabel);
        this.add(this.guardarButton);
        this.add(this.recompensaArea);
        this.add(new JLabel());
    }
}

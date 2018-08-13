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
public class Ayuda_GUI extends JFrame{
    private JButton tutorialButton;
    private JLabel ayudaLabel;
    private TextArea informacionArea;
    
    public Ayuda_GUI(String title){
        super(title);
        
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        elementSize();
        addWindow();
    }
    
     public void initComponents(){
        this.tutorialButton = new JButton("TUTORIAL");
        this.ayudaLabel = new JLabel("AYUDA");
        this.informacionArea = new TextArea("Información del Programa");
    }
     
     public void elementSize(){
        this.setSize(800, 600);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.tutorialButton.setBounds(300, 60, 150, 25);
        this.ayudaLabel.setBounds(350, 30, 150, 25);
        this.informacionArea.setBounds(50, 100, 600, 400);
    }
     
     public void addWindow(){
        this.add(this.tutorialButton);
        this.add(this.ayudaLabel);
        this.add(this.informacionArea);
        this.add(new JLabel());
    }
    
}

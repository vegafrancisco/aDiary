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
public class Historial_GUI extends JFrame{    
    private JLabel historialLabel;
    private TextArea misionesArea;
    
    public Historial_GUI(String title){
        super(title);
        
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        elementSize();
        addWindow();
    }
    
    public void initComponents(){
        this.historialLabel = new JLabel("HISTORIAL DE MISIONES");
        this.misionesArea = new TextArea("");
    }
    
    public void elementSize(){
        this.setSize(280, 300);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.historialLabel.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        this.misionesArea.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
    }
    
    public void addWindow(){
        this.add(this.historialLabel);
        this.add(this.misionesArea);
        this.add(new JLabel());
    }
}

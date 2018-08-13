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
public class Horario_GUI extends JFrame{
    private JLabel horarioLabel;
    private TextArea horarioArea;
    private JButton editarButton;
    private JButton guardarButton;
    
    public Horario_GUI(String title){
        super(title);
        
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        elementSize();
        addWindow();
    }
    
    public void initComponents(){
        this.horarioLabel = new JLabel("HORARIO");
        this.horarioArea = new TextArea("");
        this.editarButton = new JButton("EDITAR");
        this.guardarButton = new JButton("GUARDAR");
    }
    
    public void elementSize(){
        this.setSize(280, 300);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.horarioLabel.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        this.horarioArea.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        this.editarButton.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        this.guardarButton.setBounds(1,1,1,1);
    }
    
    public void addWindow(){
        this.add(this.horarioLabel);
        this.add(this.horarioArea);
        this.add(this.editarButton);
        this.add(this.guardarButton);
        this.add(new JLabel());
    }
}

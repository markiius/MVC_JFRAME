/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Modelo;
import modelo.Persona;
import vista.Vista;

/**
 *
 * @author Marco
 */
public class Controlador implements ActionListener{
    private Modelo model;
    private Vista vista;
    
    public Controlador(Modelo model, Vista vista){
        this.vista=vista;
        this.model=model;
        this.vista.BotonAgregar.addActionListener(this);
    }
    
    public void iniciar(){
        this.vista.setTitle("Primer programa");
        this.vista.setLocationRelativeTo(null);    
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.BotonAgregar){
            Persona persona = new Persona();
            persona.setNombre(vista.TextNombre.getText());
            persona.setApellidos(vista.TextApellidos.getText());
            persona.setSexo(vista.ComboSexo.getSelectedItem().toString());
            this.Insertar(persona); 
        }
    }
   
    public void Insertar(Persona persona){
        String insertar [] = {persona.getNombre(), persona.getApellidos(),persona.getSexo()};
        vista.md.addRow(insertar);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication22;

import javax.swing.ImageIcon;

/**
 *
 * @author Gabriel
 */
public class Carta {
    private String color;
    private String numero; 
    private ImageIcon icon; 

    public Carta(String color, String numero) {
        this.color = color;
        this.numero = numero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public ImageIcon getIcon(){
        return icon;
    }
    public void setIcon(ImageIcon icon){
        this.icon = icon;
    }
    
    
}

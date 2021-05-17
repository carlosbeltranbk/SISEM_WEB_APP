/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.municipio;

/**
 *
 * @author BELTRAN PC
 */
public class BeanMunicipio {
    
    private int idMunicipio;
    private String nombreMunicipio;
    
    /**
     * creamos el constructor de las variables declaradas
     * @param idMunicipio
     * @param nombreMunicipio 
     */

    public BeanMunicipio(int idMunicipio, String nombreMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nombreMunicipio = nombreMunicipio;
    }
    
    public BeanMunicipio(){
        
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
  
}

/*
 * Esta clase define todas las variables para usar de la tabla Sindico Municipal
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.model.fiscalia;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.persona.BeanPersona;

/**
 *
 * @author BELTRAN PC
 */
public class BeanFiscalia {
    
    /**
     * Declaramos las variables necesarias para 
     */
    
    private int idFiscalia;
    private String nombreFiscalia;
    private String direccionFiscalia;
    private BeanMunicipio municipio;
    private BeanPersona persona;

    /**
     * 
     * @param idFiscalia Variable de la tabla Fiscalía / primary key
     * @param nombreFiscalia Variable de la tabla Fiscalía / nombre de la fiscalia
     * @param direccionFiscalia Variable de la tabla Fiscalía / direccion de la fiscalia
     * @param municipio Variable de la tabla Fiscalía / municipio al que corresponde
     * @param persona  Variable de la tabla Fiscalía / la persona encargada
     */
    public BeanFiscalia(int idFiscalia, String nombreFiscalia, String direccionFiscalia, BeanMunicipio municipio, BeanPersona persona) {
        this.idFiscalia = idFiscalia;
        this.nombreFiscalia = nombreFiscalia;
        this.direccionFiscalia = direccionFiscalia;
        this.municipio = municipio;
        this.persona = persona;
    }
    
    /**
     * Contructor Vacío
     */
    public BeanFiscalia() {
    }

    public int getIdFiscalia() {
        return idFiscalia;
    }

    public void setIdFiscalia(int idFiscalia) {
        this.idFiscalia = idFiscalia;
    }

    public String getNombreFiscalia() {
        return nombreFiscalia;
    }

    public void setNombreFiscalia(String nombreFiscalia) {
        this.nombreFiscalia = nombreFiscalia;
    }

    public String getDireccionFiscalia() {
        return direccionFiscalia;
    }

    public void setDireccionFiscalia(String direccionFiscalia) {
        this.direccionFiscalia = direccionFiscalia;
    }

    public BeanMunicipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(BeanMunicipio municipio) {
        this.municipio = municipio;
    }

    public BeanPersona getPersona() {
        return persona;
    }

    public void setPersona(BeanPersona persona) {
        this.persona = persona;
    }
    
    
}

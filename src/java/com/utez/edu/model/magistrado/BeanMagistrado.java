/*
 * Esta clase define todas las variables para usar de la tabla Sindico Municipal
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.model.magistrado;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.rol.BeanRol;
import java.io.FileInputStream;

/**
 *
 * @author BELTRAN PC
 */
public class BeanMagistrado {
    
    private BeanPersona persona;
    private BeanMunicipio municipio;
    private BeanRol rol;
    private FileInputStream documentacion;
    
    /**
     * Creamos el constructor 
     * @param persona
     * @param municipio
     * @param rol
     * @param documentacion 
     */

    public BeanMagistrado(BeanPersona persona, BeanMunicipio municipio, BeanRol rol, FileInputStream documentacion) {
        this.persona = persona;
        this.municipio = municipio;
        this.rol = rol;
        this.documentacion = documentacion;
    }

    public BeanMagistrado() {
    }

    public BeanPersona getPersona() {
        return persona;
    }

    public void setPersona(BeanPersona persona) {
        this.persona = persona;
    }

    public BeanMunicipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(BeanMunicipio municipio) {
        this.municipio = municipio;
    }

    public BeanRol getRol() {
        return rol;
    }

    public void setRol(BeanRol rol) {
        this.rol = rol;
    }

    public FileInputStream getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(FileInputStream documentacion) {
        this.documentacion = documentacion;
    }

    
   
    
}
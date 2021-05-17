/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.pleno;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.rol.BeanRol;
import java.io.FileInputStream;
/**
 *
 * @author BELTRAN PC
 */
public class BeanPleno {
    
    private BeanPersona persona;
    private BeanMunicipio municipio;
    private BeanRol rol;
    private FileInputStream documentacion;

    public BeanPleno(BeanPersona persona, BeanMunicipio municipio, BeanRol rol, FileInputStream documentacion) {
        this.persona = persona;
        this.municipio = municipio;
        this.rol = rol;
        this.documentacion = documentacion;
    }

    public BeanPleno() {
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

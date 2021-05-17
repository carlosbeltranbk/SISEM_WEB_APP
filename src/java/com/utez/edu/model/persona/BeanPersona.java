/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.persona;

import com.utez.edu.model.municipio.BeanMunicipio;
import java.io.File;

/**
 *
 * @author BELTRAN PC
 */
public class BeanPersona {
    
    private int idPersona;
    private String nombre;
    private String primeroApellido;
    private String segundoApellido;
    private String fechaNacimiento;
    private int edad;
    private String curp;
    private String numeroTrabajador;
    private BeanMunicipio municipio;
    private File documentacion1;
    private File documentacion2;
    private String foto1;
    private String foto2;

    /**
     * Hacemos el constructor de las variables declaradas
     * @param idPersona
     * @param nombre
     * @param primeroApellido
     * @param segundoApellido
     * @param fechaNacimiento
     * @param edad
     * @param curp
     * @param numeroTrabajador
     * @param municipio
     * @param documentacion1
     * @param documentacion2
     * @param foto1
     * @param foto2 
     */
    
    public BeanPersona(int idPersona, String nombre, String primeroApellido, String segundoApellido, String fechaNacimiento, int edad, String curp, String numeroTrabajador, BeanMunicipio municipio, File documentacion1, File documentacion2, String foto1, String foto2) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.primeroApellido = primeroApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.curp = curp;
        this.numeroTrabajador = numeroTrabajador;
        this.municipio = municipio;
        this.documentacion1 = documentacion1;
        this.documentacion2 = documentacion2;
        this.foto1 = foto1;
        this.foto2 = foto2;
    }

    public BeanPersona() {
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimeroApellido() {
        return primeroApellido;
    }

    public void setPrimeroApellido(String primeroApellido) {
        this.primeroApellido = primeroApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNumeroTrabajador() {
        return numeroTrabajador;
    }

    public void setNumeroTrabajador(String numeroTrabajador) {
        this.numeroTrabajador = numeroTrabajador;
    }

    public BeanMunicipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(BeanMunicipio municipio) {
        this.municipio = municipio;
    }

    public File getDocumentacion1() {
        return documentacion1;
    }

    public void setDocumentacion1(File documentacion1) {
        this.documentacion1 = documentacion1;
    }

    public File getDocumentacion2() {
        return documentacion2;
    }

    public void setDocumentacion2(File documentacion2) {
        this.documentacion2 = documentacion2;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }
    
    
}

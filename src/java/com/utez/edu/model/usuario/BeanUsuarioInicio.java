/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.usuario;

import com.utez.edu.model.rol.BeanRol;

/**
 *
 * @author jtc_2
 */
public class BeanUsuarioInicio {
    
    private int idUsuario;
    private String correo;
    private String contrasenia;
    private BeanRol rol;

    public BeanUsuarioInicio(int idUsuario, String correo, String contrasenia, BeanRol rol) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public BeanUsuarioInicio() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public BeanRol getRol() {
        return rol;
    }

    public void setRol(BeanRol rol) {
        this.rol = rol;
    }
    
    
    
}

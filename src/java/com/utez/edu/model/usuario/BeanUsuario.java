/*
 * Esta clase define todas las variables para usar de la tabla Usuario
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.model.usuario;

import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.rol.BeanRol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BELTRAN PC
 */
public class BeanUsuario {

    private int idUsuario;
    private String correo;
    private String contrasenia;
    private BeanPersona persona;
    private BeanRol rol;
    private boolean estado;
    private List<BeanRol> roles = new ArrayList<>();

    public BeanUsuario() {
    }

    public BeanUsuario(int idUsuario, String correo, String contrasenia, BeanPersona persona, BeanRol rol, boolean estado) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.persona = persona;
        this.rol = rol;
        this.estado = estado;
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

    public BeanPersona getPersona() {
        return persona;
    }

    public void setPersona(BeanPersona persona) {
        this.persona = persona;
    }

    public BeanRol getRol() {
        return rol;
    }

    public void setRol(BeanRol rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<BeanRol> getRoles() {
        return roles;
    }

    public void setRoles(List<BeanRol> roles) {
        this.roles = roles;
    }

  
    

}

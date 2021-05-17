/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.correo;

/**
 *
 * @author jtc_2
 */
public class CorreoBean {
    
    private String id; //codigoRecueracion
    private String correo; //correo
    private String user; //nombre del usuario
    private String contra;
    private String contra1;
    
    // -------------------------------------------------- //
    
    private String codigoRecuperacion;
    private String correoUsuario;
    private int idUsuario;
    private String contraseniaUsuario;
    private String contra1Alter;

    public CorreoBean(String codigoRecuperacion, String correoUsuario, int idUsuario, String contraseniaUsuario, String contra1Alter) {
        this.codigoRecuperacion = codigoRecuperacion;
        this.correoUsuario = correoUsuario;
        this.idUsuario = idUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.contra1Alter = contra1Alter;
    }

    public CorreoBean() {
    }

    public String getCodigoRecuperacion() {
        return codigoRecuperacion;
    }

    public void setCodigoRecuperacion(String codigoRecuperacion) {
        this.codigoRecuperacion = codigoRecuperacion;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public String getContra1Alter() {
        return contra1Alter;
    }

    public void setContra1Alter(String contra1Alter) {
        this.contra1Alter = contra1Alter;
    }
    
    
    

   

}

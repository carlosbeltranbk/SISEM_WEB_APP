/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.usuarioLogin;

/**
 *
 * @author Oscar Rodríguez
 */
public class BeanUsuarioLogin {

    /**
     * @param: idUsuario Almacena el identificador unico del objeto usuario.
     * @param: usuario Almacena el usuario del objeto usuario.
     * @param: password Almacena la contraseña del objeto usuario.
     * @param: rol Almacena el rol asignado del objeto administrador.
     */

    private int idUsuario;
    private String usuario;
    private String password;
    private int rol;

    /**
     * @param: Get Metodos cada uno a su respectiva variable sirve para obtener
     * su información.
     * @param: Set Metodos cada uno a su respectiva variable sirve para asignar
     * un valor a la variable.
     * @return: Los metodos get retornan la informacion contenida en la variable
     * del objeto.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

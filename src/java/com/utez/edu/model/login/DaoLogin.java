/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.login;

import com.utez.edu.model.rol.BeanRol;
import com.utez.edu.model.usuario.BeanUsuario;
import com.utez.edu.sisem.servicios.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BELTRAN PC
 */
public class DaoLogin {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;

    private final String INICIO_SESION = "SELECT * FROM USUARIO INNER JOIN rol "
            + " ON perteneceRol = idRol  WHERE correo = ? AND contrasenia = ?;";
    
    public BeanUsuario iniciarSesion(String username, String pass) {
        BeanUsuario usuario = new BeanUsuario();
        BeanRol rol = new BeanRol();
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(INICIO_SESION);
            pstm.setString(1, username);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasenia(rs.getString("contrasenia"));

                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombreRol(rs.getString("nombreRol"));
                
                usuario.setRol(rol);

            }

        } catch (SQLException e) {
            System.err.println("Error DaoLogin - iniciarSesion() " + e);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexion DaoLogin - iniciarSesion() " + e);
            }
        }
        return usuario;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.correo;

import com.utez.edu.model.persona.BeanPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.utez.edu.sisem.servicios.ConexionMySQL;

/**
 *
 * @author jtc_2
 */
public class DaoCorreo {

    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;

    final private String CONSULTAR_USER = "SELECT * FROM usuario WHERE correo = ?;";
    final private String INGRESAR_CLAVE = "UPDATE usuario SET codigoRecuperacion = ? WHERE correo = ?;";
    final private String CONSULTAR_USER_ID = "SELECT * FROM usuario WHERE codigoRecuperacion= ?;";
    final private String CAMBIAR_CONTRA = "UPDATE usuario SET contrasenia = ?, codigoRecuperacion = null WHERE codigoRecuperacion = ?";

    public CorreoBean consularCorreo(String correo) {
        CorreoBean bean = null;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(CONSULTAR_USER);
            pstm.setString(1, correo);
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = new CorreoBean();
                
                bean.setCorreoUsuario(rs.getString("correo"));
                bean.setIdUsuario(rs.getInt("idUsuario"));
                bean.setCodigoRecuperacion(rs.getString("codigoRecuperacion"));
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en el método consularCorreo() en el DaoCorreo ->" + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return bean;
    }

    public boolean cambiarPass(CorreoBean bean) {
        boolean resultado = false;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(CAMBIAR_CONTRA);
            pstm.setString(1, bean.getContraseniaUsuario());
            pstm.setString(2, bean.getCodigoRecuperacion());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en el método cambiarPass() en el DaoCorreo ->0" + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }

        return resultado;
    }

    public CorreoBean consularCorreoUserId(String id) {
        CorreoBean bean = null;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(CONSULTAR_USER_ID);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = new CorreoBean();
                bean.setCorreoUsuario(rs.getString("correo"));
                bean.setIdUsuario(rs.getInt("idUsuario"));
                bean.setCodigoRecuperacion(rs.getString("codigoRecuperacion"));
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en el método consularCorreo() en el DaoCorreo ->" + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return bean;
    }

    public CorreoBean ingresarClave(CorreoBean beann) {
        CorreoBean bean = null;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(INGRESAR_CLAVE);
            pstm.setString(1, beann.getCodigoRecuperacion());
            pstm.setString(2, beann.getCorreoUsuario());
            boolean resultado = pstm.executeUpdate() == 1;
            if (resultado) {
                DaoCorreo dao = new DaoCorreo();
                bean = dao.consularCorreo(beann.getCorreoUsuario());
            }
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en el método consularCorreo() en el DaoCorreo ->" + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return bean;
    }
}

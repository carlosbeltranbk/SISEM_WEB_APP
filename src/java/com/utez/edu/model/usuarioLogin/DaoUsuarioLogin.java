/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.usuarioLogin;

import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.rol.BeanRol;
import com.utez.edu.model.usuario.BeanUsuario;
import com.utez.edu.sisem.servicios.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Oscar Rodríguez
 */
public class DaoUsuarioLogin {

    /**
     * @param: singletonConexion Genera la instancia para la conexion con la
     * base de datos.
     * @param: conexion Establece conexión entre la base de datos y web.
     * @param: rs Dispone de los datos entre la base y el sistema.
     * @param: pstm Prepara y ejecuta las sentencias entre la base de datos y el
     * sistema web.
     */

    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private ResultSet rs;
    private PreparedStatement pstm;

    final private String SQL_LOGIN_ADMIN = "SELECT * FROM persona INNER JOIN usuario ON idPersona = pertenecePersona\n" +
"					    INNER JOIN rol ON idRol = perteneceRol WHERE correo = ? AND contrasenia = ? AND estado = 1;";

    /**
     * Metodo encargado de realizar el inicio de sesion en el sistema web
     *
     * @return: Retorna el objeto con los datos del administrador datos que
     * corresponden a quien inicio sesion.
     */
    public BeanUsuario consultarAdminLogin(String correo, String contrasenia) {
        BeanUsuario bean = null;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(SQL_LOGIN_ADMIN);
            pstm.setString(1, correo);
            pstm.setString(2, contrasenia);
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = new BeanUsuario();
                bean.setIdUsuario(rs.getInt("idUsuario"));
                bean.setCorreo(rs.getString("correo"));
                bean.setContrasenia(rs.getString("contrasenia"));
                
                BeanPersona persona = new BeanPersona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPrimeroApellido(rs.getString("primeroApellido"));
                persona.setSegundoApellido(rs.getString("segundoApellido"));
                persona.setFechaNacimiento(rs.getString("fechaNacimiento"));
                persona.setEdad(rs.getInt("edad"));
                persona.setCurp(rs.getString("curp"));
                
                BeanRol rol = new BeanRol();
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombreRol(rs.getString("nombreRol"));
                
                bean.setPersona(persona);
                bean.setRol(rol);
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.println("Error en el metodo consultarAdminLogin() " + ex.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception ex) {
                System.out.println("Error al cerrar conexiones consultarAdminLogin() " + ex.getMessage());
            }

        }
        return bean;
    }
}

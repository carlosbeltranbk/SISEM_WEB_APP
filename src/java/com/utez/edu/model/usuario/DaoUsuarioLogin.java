/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.usuario;

import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.rol.BeanRol;
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
public class DaoUsuarioLogin {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String SQL_CONSULTAR_USUARIOS="SELECT * FROM Persona INNER JOIN Usuario ON idPersona = pertenecePersona\n" +
"					    INNER JOIN Rol ON idRol = perteneceRol WHERE correo = ? AND contrasenia = ? AND estado = 1;";
    
    
    
    
}

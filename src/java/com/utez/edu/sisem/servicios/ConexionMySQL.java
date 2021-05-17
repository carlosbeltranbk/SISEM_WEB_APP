/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.sisem.servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 *
 * @author BELTRAN-PC
 */
public class ConexionMySQL {

    private static String ipAddress;
    private static String puerto;
    private static String usuario;
    private static String password;
    private static String nombreBase;
    private static ResourceBundle propiedades;
    private static ConexionMySQL conexion;
    
    private ConexionMySQL() {

    }
    
    public static ConexionMySQL getInstance() {
        if (conexion == null) {
            conexion = new ConexionMySQL();
        }
        return conexion;
    }

    public static Connection getConexion() {
        Connection con = null;
        if (propiedades == null) {
            propiedades = ResourceBundle.getBundle("propiedadesMySQL");
            ipAddress = propiedades.getString("ipAddress");
            puerto = propiedades.getString("puerto");
            usuario = propiedades.getString("usuario");
            password = propiedades.getString("password");
            nombreBase = propiedades.getString("nombreBase");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();;
            con = DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + puerto + "/" + nombreBase, usuario, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        ConexionMySQL conexion = new ConexionMySQL();
        Connection con = conexion.getConexion();
        if (con != null) {
            System.out.println("¡Conexión exitosa!");
        } else {
            System.out.println("¡No se estableció conexión!");
        }
    }
}
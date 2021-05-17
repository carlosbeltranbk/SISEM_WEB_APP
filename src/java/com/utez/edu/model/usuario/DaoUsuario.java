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
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author BELTRAN PC
 */
public class DaoUsuario {

    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;

    final private String SQL_CONSULTAR_USUARIOS = "SELECT idUsuario, correo, contrasenia, persona.idPersona, persona.nombre, persona.primeroApellido, persona.segundoApellido,"
            + "   rol.idRol, rol.nombreRol, estado FROM usuario inner join persona on usuario.pertenecePersona = persona.idPersona"
            + "   inner join rol on usuario.perteneceRol = rol.idRol;";

    final private String SQL_CONSULTAR_USUARIOS_ID = "SELECT idUsuario, correo, contrasenia, persona.idPersona, persona.nombre,"
            + "   rol.idRol, rol.nombreRol, estado FROM usuario inner join persona on usuario.pertenecePersona = persona.idPersona"
            + "   inner join rol on usuario.perteneceRol = rol.idRol where usuario.idUsuario = ?;";

    final private String SQL_REGISTRAR_USUARIOS = "CALL AgregarUsuario(?,?,?,?);";

    final private String SQL_MODIFICAR_USUARIOS = "UPDATE usuario SET correo = ?, pertenecePersona = ?, perteneceRol = ?, estado = ?"
            + "   WHERE idUsuario = ?;";

    final private String SQL_ELIMINAR_USUARIOS = "UPDATE usuario SET estado = 0 WHERE idUsuario = ?;";

    final private String SQL_REGISTRAR_USUARIOS_PERSONA = "CALL Registrar_Usuario(?,?,?,?,?,?,?,?,?,?,?);";

    final private String SQL_CONSULTAR_CONTRA = "SELECT contrasenia FROM usuario where correo = ?;";
    
    //Consulta para insertar nuevo usuario desde la vista del administrador
    final private String SQL_REGISTRAR_USUARIOS_ADMINISTRADOR = "CALL AgregarPersona(?,?,?,?,?,?,?,?,?,?,?,?,?);";
    

    /**
     * 
     * @return 
     */
    public List<BeanUsuario> consultarUsuarios() {
        List<BeanUsuario> usuarios = new ArrayList();
        try {
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(SQL_CONSULTAR_USUARIOS);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanUsuario usuario = new BeanUsuario();
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasenia(rs.getString("contrasenia"));

                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPrimeroApellido(rs.getString("primeroApellido"));
                persona.setSegundoApellido(rs.getString("segundoApellido"));

                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombreRol(rs.getString("nombreRol"));

                usuario.setEstado(rs.getBoolean("estado"));

                usuario.setPersona(persona);
                usuario.setRol(rol);

                usuarios.add(usuario);
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo consultarUsuarios() del daoUsuarios: " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return usuarios;
    }

    /**
     * 
     * @param idUsuario
     * @return 
     */
    public BeanUsuario consultarUsuarioId(int idUsuario) {
        BeanUsuario usuario = null;
        try {
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_USUARIOS_ID);
            pstm.setInt(1, idUsuario);
            rs = pstm.executeQuery();
            if (rs.next()) {

                usuario = new BeanUsuario();
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasenia(rs.getString("contrasenia"));

                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));

                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombreRol(rs.getString("nombreRol"));

                usuario.setEstado(rs.getBoolean("estado"));

                usuario.setPersona(persona);
                usuario.setRol(rol);

            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo consultarUsuarioId() del daoUsuario: " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return usuario;
    }

    /**
     * 
     * @param usuario
     * @return
     * @throws FileNotFoundException 
     */
    public String registrarUsuario(BeanUsuario usuario) throws FileNotFoundException {
        boolean resultado = false;
        String correo = null;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_REGISTRAR_USUARIOS);

            pstm.setString(1, usuario.getCorreo());
            pstm.setInt(2, usuario.getPersona().getIdPersona());
            pstm.setInt(3, usuario.getRol().getIdRol());
            pstm.setBoolean(4, usuario.isEstado());

            resultado = pstm.executeUpdate() == 1;
            if (resultado) {
                correo = usuario.getCorreo();
            }
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo registrarUsuario() del daoUsuario: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return correo;
    }

    /**
     * 
     * @param usuario
     * @return
     * @throws FileNotFoundException 
     */
    public String registrarUsuarioPersona(BeanUsuario usuario) throws FileNotFoundException {
        boolean resultado = false;
        FileInputStream is = new FileInputStream(usuario.getPersona().getDocumentacion1().getAbsoluteFile());
        String correo = null;
        FileInputStream iss = new FileInputStream(usuario.getPersona().getDocumentacion2().getAbsoluteFile());
        System.out.println(" Imagen 1 ------>  " + is);
        System.out.println(" Imagen 2 ------> " + iss);
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_REGISTRAR_USUARIOS_PERSONA);

            // "CALL Registrar_Usuario(?,?,?,?,?,?,?,?,?,?,?);";
            pstm.setString(1, usuario.getPersona().getNombre());
            pstm.setString(2, usuario.getPersona().getPrimeroApellido());
            pstm.setString(3, usuario.getPersona().getSegundoApellido());
            pstm.setString(4, usuario.getPersona().getFechaNacimiento());
            pstm.setString(5, usuario.getPersona().getCurp());
            pstm.setInt(6, usuario.getPersona().getMunicipio().getIdMunicipio());
            pstm.setString(7, usuario.getCorreo());
            pstm.setBlob(8, is);
            pstm.setBlob(9, iss);
            pstm.setString(10, usuario.getPersona().getFoto1());
            pstm.setString(11, usuario.getPersona().getFoto2());
            resultado = pstm.executeUpdate() == 1;
            if (resultado) {
                correo = usuario.getCorreo();
            }
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo registrarUsuarioPersona() del daoUsuario: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return correo;
    }
    
    
    // --------------------------- REGISTRAR USUARIO DESDE ADMINISTRADOR ------------------------------------- //
    
    /**
     * 
     * @param usuario
     * @return
     * @throws FileNotFoundException 
     */
    public String registrarUsuarioPersonaAdministrador(BeanUsuario usuario) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(usuario.getPersona().getDocumentacion1().getAbsoluteFile());
        FileInputStream iss = new FileInputStream(usuario.getPersona().getDocumentacion2().getAbsoluteFile());
        System.out.println(" Imagen 1 ------>  " + is);
        System.out.println(" Imagen 2 ------> " + iss);
        boolean resultado = false;
        String correo = null;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_REGISTRAR_USUARIOS_ADMINISTRADOR);

            // "CALL Registrar_Usuario(?,?,?,?,?,?,?,?,?,?,?);";
            pstm.setString(1, usuario.getPersona().getNombre());
            pstm.setString(2, usuario.getPersona().getPrimeroApellido());
            pstm.setString(3, usuario.getPersona().getSegundoApellido());
            pstm.setString(4, usuario.getPersona().getFechaNacimiento());
            pstm.setString(5, usuario.getPersona().getCurp());
            pstm.setInt(6, usuario.getPersona().getMunicipio().getIdMunicipio());
            pstm.setString(7, usuario.getCorreo());
            pstm.setInt(8, usuario.getRol().getIdRol());
            pstm.setString(9, usuario.getPersona().getNumeroTrabajador());
            pstm.setBlob(10, is);
            pstm.setBlob(11, iss);
            pstm.setString(12, usuario.getPersona().getFoto1());
            pstm.setString(13, usuario.getPersona().getFoto2());
            resultado = pstm.executeUpdate() == 1;
            if (resultado) {
                correo = usuario.getCorreo();
            }
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo registrarUsuarioPersonaAdministrador() del daoUsuario: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return correo;
    }
    // --------------------------- REGISTRAR USUARIO DESDE ADMINISTRADOR ------------------------------------- //
    
    
    
    
    
    /**
     * 
     * @param usuario
     * @return 
     */
    public boolean modificarUsuario(BeanUsuario usuario) {
        boolean resultado = false;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_MODIFICAR_USUARIOS);

            pstm.setString(1, usuario.getCorreo());
            pstm.setInt(2, usuario.getPersona().getIdPersona());
            pstm.setInt(3, usuario.getRol().getIdRol());
            pstm.setBoolean(4, usuario.isEstado());
            pstm.setInt(5, usuario.getIdUsuario());

            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo modificarUsuario() del daoUsuario: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron las conexiones" + e.getMessage());
            }
        }
        return resultado;
    }

    /**
     * 
     * @param idUsuario
     * @return 
     */
    public boolean eliminarUsuario(int idUsuario) {
        boolean resultado = false;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_ELIMINAR_USUARIOS);
            pstm.setInt(1, idUsuario);
            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo eliminarUsuario() del daoUsuario: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron las conexiones en eliminarUsuario()" + e.getMessage());
            }
        }
        return resultado;
    }

    /**
     * 
     * @param correo
     * @return 
     */
    public BeanUsuario consultarContras(String correo) {
        BeanUsuario usuario = null;
        try {
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement("SELECT contrasenia,correo FROM usuario WHERE correo = ?;");
            pstm.setString(1, correo);
            rs = pstm.executeQuery();
            if (rs.next()) {
                usuario = new BeanUsuario();
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setCorreo(rs.getString("correo"));

            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo consultarUsuarioId() del daoUsuario: " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return usuario;
    }

}

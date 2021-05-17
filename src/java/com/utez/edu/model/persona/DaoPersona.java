/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.persona;

import com.utez.edu.model.municipio.BeanMunicipio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.utez.edu.sisem.servicios.ConexionMySQL;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;

/**
 *
 * @author BELTRAN PC
 */
public class DaoPersona {

    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;

    final private String SQL_CONSULTAR_PERSONAS = "SELECT * FROM persona"
            + "    inner join municipio on persona.perteneceMunicipio = municipio.idMunicipio;";

    final private String SQL_CONSULTAR_PERSONAS_ID = "SELECT idPersona, nombre, primeroApellido, segundoApellido, fechaNacimiento, edad,"
            + "    curp, numeroTrabajador, municipio.idMunicipio, municipio.nombreMunicipio FROM persona"
            + "    inner join municipio on persona.perteneceMunicipio = municipio.idMunicipio where persona.idPersona = ?;";

    final private String SQL_REGISTRAR_PERSONAS = "CALL AgregarPersona(?,?,?,?,?,?,?);";

    final private String SQL_MODIFICAR_PERSONAS = "CALL ModificarPersona(?,?,?,?,?,?,?,?);";

    final private String SQL_ELIMINAR_PERSONAS = "DELETE FROM persona WHERE idPersona = ?;";

    public List<BeanPersona> consultarPersonas(String path) {
        List<BeanPersona> personas = new ArrayList();
        try {
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(SQL_CONSULTAR_PERSONAS);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanPersona persona = new BeanPersona();
                BeanMunicipio municipio = new BeanMunicipio();

                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPrimeroApellido(rs.getString("primeroApellido"));
                persona.setSegundoApellido(rs.getString("segundoApellido"));
                persona.setFechaNacimiento(rs.getString("fechaNacimiento"));
                persona.setEdad(rs.getInt("edad"));
                persona.setCurp(rs.getString("curp"));
                persona.setNumeroTrabajador(rs.getString("numeroTrabajador"));
                persona.setFoto1(rs.getString("nombreImgNombre"));
                persona.setFoto2(rs.getString("nombreImgTwo"));

                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        String nombre = (rs.getString("nombreImgNombre"));
                        File archivo = new File(path,nombre);
                        
                        if (archivo.exists()) {
                            System.out.println("Ya existe");
                        } else {
                            Blob blob = rs.getBlob("archivoone");
                            byte[] bytearray = blob.getBytes(1L, (int) blob.length());
                            FileOutputStream fos = new FileOutputStream(archivo);
                            fos.write(bytearray);
                            fos.close();
                            System.out.println(bytearray);
                        }
                    }
                    if (i == 1) {
                        String nombreT = (rs.getString("nombreImgTwo"));
                        File archivo = new File(path,nombreT);
                        if (archivo.exists()) {
                            System.out.println("Ya existe");
                        } else {
                            Blob blob = rs.getBlob("archivotwo");
                            byte[] bytearray = blob.getBytes(1L, (int) blob.length());
                            FileOutputStream fos = new FileOutputStream(archivo);
                            fos.write(bytearray);
                            fos.close();
                            System.out.println(bytearray);
                        }
                    }
                }

                municipio.setIdMunicipio(rs.getInt("idMunicipio"));
                municipio.setNombreMunicipio(rs.getString("nombreMunicipio"));

                persona.setMunicipio(municipio);
                personas.add(persona);
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo consultarPersonas() del DaoPersonas: " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return personas;
    }

    public BeanPersona consultarPersonaId(int idPersona) {
        BeanPersona persona = null;
        try {
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_PERSONAS_ID);
            pstm.setInt(1, idPersona);
            rs = pstm.executeQuery();
            if (rs.next()) {

                BeanMunicipio municipio = new BeanMunicipio();
                persona = new BeanPersona();

                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPrimeroApellido(rs.getString("primeroApellido"));
                persona.setSegundoApellido(rs.getString("segundoApellido"));
                persona.setFechaNacimiento(rs.getString("fechaNacimiento"));
                persona.setEdad(rs.getInt("edad"));
                persona.setCurp(rs.getString("curp"));
                persona.setNumeroTrabajador(rs.getString("numeroTrabajador"));

                municipio.setIdMunicipio(rs.getInt("idMunicipio"));
                municipio.setNombreMunicipio(rs.getString("nombreMunicipio"));

                persona.setMunicipio(municipio);

            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo consultarPersonaID() del DaoPersonas: " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return persona;
    }

    public boolean registrarPersona(BeanPersona persona) {
        boolean resultado = false;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_REGISTRAR_PERSONAS);

            pstm.setString(1, persona.getNombre());
            pstm.setString(2, persona.getPrimeroApellido());
            pstm.setString(3, persona.getSegundoApellido());
            pstm.setString(4, persona.getFechaNacimiento());
            pstm.setString(5, persona.getCurp());
            pstm.setString(6, persona.getNumeroTrabajador());
            pstm.setInt(7, persona.getMunicipio().getIdMunicipio());

            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo registrarPersona() del DaoPersonas: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    public boolean modificarPersona(BeanPersona persona) {
        boolean resultado = false;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_MODIFICAR_PERSONAS);

            pstm.setString(1, persona.getNombre());
            pstm.setString(2, persona.getPrimeroApellido());
            pstm.setString(3, persona.getSegundoApellido());
            pstm.setString(4, persona.getFechaNacimiento());
            pstm.setString(5, persona.getCurp());
            pstm.setString(6, persona.getNumeroTrabajador());
            pstm.setInt(7, persona.getMunicipio().getIdMunicipio());
            pstm.setInt(8, persona.getIdPersona());

            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo modificarPersona() del daoPersona: " + e.getMessage());
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

    public boolean eliminarPersona(int idPersona) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(SQL_ELIMINAR_PERSONAS);
            pstm.setInt(1, idPersona);
            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo eliminarPersona() del daoPersona: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron las conexiones en eliminarEstudiante()" + e.getMessage());
            }
        }
        return resultado;
    }

}

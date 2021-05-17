/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.oficialia;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.rol.BeanRol;
import com.utez.edu.model.usuario.BeanUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.utez.edu.sisem.servicios.ConexionMySQL;
/**
 *
 * @author BELTRAN PC
 */
public class DaoOficialia {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String SQL_CONSULTAR_OFICIALIAS="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 8;";
    
    final private String SQL_CONSULTAR_OFICIALIAS_ID="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 8 and idPersona = ?;";
    
    final private String SQL_MODIFICAR_PERSONAS="CALL ModificarPersona(?,?,?,?,?,?,?,?);";
    
    final private String SQL_ELIMINAR_PERSONAS="DELETE FROM persona WHERE idPersona = ?;";
    
    public List<BeanOficialia> consultarOficialias(){
        List<BeanOficialia> oficialias = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(SQL_CONSULTAR_OFICIALIAS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                BeanOficialia oficialia = new BeanOficialia();
                BeanMunicipio municipio = new BeanMunicipio();

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
                
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombreRol(rs.getString("nombreRol"));
                
                
                oficialia.setMunicipio(municipio);
                oficialia.setRol(rol);
                oficialia.setPersona(persona);
                
                oficialias.add(oficialia);
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo CONSULTAR_OFICIALIAS() del DaoPersonas CONSULTAR_SINDICOS: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return oficialias;
    }
    
    public BeanOficialia consultarOficialiaId(int idPersona){
        BeanOficialia oficialia = null;
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_OFICIALIAS_ID);
            pstm.setInt(1, idPersona);
            rs = pstm.executeQuery();
            if(rs.next()){
                
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                oficialia = new BeanOficialia();
                BeanMunicipio municipio = new BeanMunicipio();

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
                
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombreRol(rs.getString("nombreRol"));
                
                
                oficialia.setMunicipio(municipio);
                oficialia.setRol(rol);
                oficialia.setPersona(persona);
               
                
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo CONSULTAR_OFICIALIAS_ID() del daoSindicos: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return oficialia;
    }
    
    public boolean modificarOficialia(BeanOficialia oficialia){
        boolean resultado = false;
        try{
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_MODIFICAR_PERSONAS);

            pstm.setString(1, oficialia.getPersona().getNombre());
            pstm.setString(2, oficialia.getPersona().getPrimeroApellido());
            pstm.setString(3, oficialia.getPersona().getSegundoApellido());
            pstm.setString(4, oficialia.getPersona().getFechaNacimiento());
            pstm.setString(5, oficialia.getPersona().getCurp());
            pstm.setString(6, oficialia.getPersona().getNumeroTrabajador());
            pstm.setInt(7, oficialia.getMunicipio().getIdMunicipio());
            pstm.setInt(8, oficialia.getPersona().getIdPersona());
            
            resultado = pstm.executeUpdate() == 1;
            
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo modificarOficialia) del daoPersona: " + e.getMessage());
        }finally{
            try{
                pstm.close();
                conexion.close();
            }catch(Exception e){
                System.out.println("No se cerraron las conexiones"+ e.getMessage());
            }
        }
        return resultado;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.sindicoMunicipal;

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
public class DaoSindicoMunicipal {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String SQL_CONSULTAR_SINDICOS="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 4;";
    
    final private String SQL_CONSULTAR_SINDICOS_ID="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 4 and idPersona = ?;";
    
    final private String SQL_MODIFICAR_PERSONAS="CALL ModificarPersona(?,?,?,?,?,?,?,?);";
    
    final private String SQL_ELIMINAR_PERSONAS="DELETE FROM persona WHERE idPersona = ?;";
    
    public List<BeanSindicoMunicipal> consultarSindicos(){
        List<BeanSindicoMunicipal> sindicos = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(SQL_CONSULTAR_SINDICOS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                BeanSindicoMunicipal sindico = new BeanSindicoMunicipal();
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
                
                
                sindico.setMunicipio(municipio);
                sindico.setRol(rol);
                sindico.setPersona(persona);
                
                sindicos.add(sindico);
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo CONSULTAR_SINDICOS() del DaoPersonas CONSULTAR_SINDICOS: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return sindicos;
    }
    
    public BeanSindicoMunicipal consultarSindicoId(int idPersona){
        BeanSindicoMunicipal sindico = null;
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_SINDICOS_ID);
            pstm.setInt(1, idPersona);
            rs = pstm.executeQuery();
            if(rs.next()){
                
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                sindico = new BeanSindicoMunicipal();
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
                
                
                sindico.setMunicipio(municipio);
                sindico.setRol(rol);
                sindico.setPersona(persona);
               
                
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo CONSULTAR_SINDICOS_ID() del daoSindicos: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return sindico;
    }
    
    public boolean modificarSindico(BeanSindicoMunicipal sindico){
        boolean resultado = false;
        try{
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_MODIFICAR_PERSONAS);

            pstm.setString(1, sindico.getPersona().getNombre());
            pstm.setString(2, sindico.getPersona().getPrimeroApellido());
            pstm.setString(3, sindico.getPersona().getSegundoApellido());
            pstm.setString(4, sindico.getPersona().getFechaNacimiento());
            pstm.setString(5, sindico.getPersona().getCurp());
            pstm.setString(6, sindico.getPersona().getNumeroTrabajador());
            pstm.setInt(7, sindico.getMunicipio().getIdMunicipio());
            pstm.setInt(8, sindico.getPersona().getIdPersona());
            
            resultado = pstm.executeUpdate() == 1;
            
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo modificarSindico) del daoPersona: " + e.getMessage());
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

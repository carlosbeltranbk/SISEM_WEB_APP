/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.pleno;

import com.utez.edu.model.municipio.BeanMunicipio;
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
 * @author BELTRAN PC
 */
public class DaoPleno {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String SQL_CONSULTAR_PLENOS="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 6;";
    
    final private String SQL_CONSULTAR_PLENOS_ID="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 6 and idPersona = ?;";
    
    final private String SQL_MODIFICAR_PERSONAS="CALL ModificarPersona(?,?,?,?,?,?,?,?);";
    
    final private String SQL_ELIMINAR_PERSONAS="DELETE FROM persona WHERE idPersona = ?;";
    
    public List<BeanPleno> consultarPlenos(){
        List<BeanPleno> plenos = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(SQL_CONSULTAR_PLENOS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                BeanPleno pleno = new BeanPleno();
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
                
                
                pleno.setMunicipio(municipio);
                pleno.setRol(rol);
                pleno.setPersona(persona);
                
                plenos.add(pleno);
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo CONSULTAR_PLENOS() del DaoPersonas CONSULTAR_SINDICOS: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return plenos;
    }
    
    public BeanPleno consultarPlenoId(int idPersona){
        BeanPleno pleno = null;
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_PLENOS_ID);
            pstm.setInt(1, idPersona);
            rs = pstm.executeQuery();
            if(rs.next()){
                
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                pleno = new BeanPleno();
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
                
                
                pleno.setMunicipio(municipio);
                pleno.setRol(rol);
                pleno.setPersona(persona);
               
                
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo CONSULTAR_PLENOS_ID() del daoSindicos: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return pleno;
    }
    
    public boolean modificarPleno(BeanPleno pleno){
        boolean resultado = false;
        try{
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_MODIFICAR_PERSONAS);

            pstm.setString(1, pleno.getPersona().getNombre());
            pstm.setString(2, pleno.getPersona().getPrimeroApellido());
            pstm.setString(3, pleno.getPersona().getSegundoApellido());
            pstm.setString(4, pleno.getPersona().getFechaNacimiento());
            pstm.setString(5, pleno.getPersona().getCurp());
            pstm.setString(6, pleno.getPersona().getNumeroTrabajador());
            pstm.setInt(7, pleno.getMunicipio().getIdMunicipio());
            pstm.setInt(8, pleno.getPersona().getIdPersona());
            
            resultado = pstm.executeUpdate() == 1;
            
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo modificarPleno) del daoPersona: " + e.getMessage());
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

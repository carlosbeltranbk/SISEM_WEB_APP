/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.magistrado;

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
public class DaoMagistrado {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String SQL_CONSULTAR_MAGISTRADOS="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 3;";
    
    final private String SQL_CONSULTAR_MAGISTRADOS_ID="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 3 and idPersona = ?;";
    
    final private String SQL_MODIFICAR_PERSONAS="CALL ModificarPersona(?,?,?,?,?,?,?,?);";
    
    final private String SQL_ELIMINAR_PERSONAS="DELETE FROM persona WHERE idPersona = ?;";
    
    public List<BeanMagistrado> consultarMagistrados(){
        List<BeanMagistrado> magistrados = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(SQL_CONSULTAR_MAGISTRADOS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                BeanMagistrado magistrado = new BeanMagistrado();
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
                
                
                magistrado.setMunicipio(municipio);
                magistrado.setRol(rol);
                magistrado.setPersona(persona);
                
                magistrados.add(magistrado);
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo MAIGSTRADOS-CONSULTAR() del DaoPersonas CONSULTAR_SINDICOS: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return magistrados;
    }
    
    
   public BeanMagistrado consultarMagistradId(int idPersona){
        BeanMagistrado magistrado = null;
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_MAGISTRADOS_ID);
            pstm.setInt(1, idPersona);
            rs = pstm.executeQuery();
            if(rs.next()){
                
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                magistrado = new BeanMagistrado();
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
                
                
                magistrado.setMunicipio(municipio);
                magistrado.setRol(rol);
                magistrado.setPersona(persona);
               
                
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
        return magistrado;
    }
    
    public boolean modificarMagistrado(BeanMagistrado maistrado){
        boolean resultado = false;
        try{
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_MODIFICAR_PERSONAS);

            pstm.setString(1, maistrado.getPersona().getNombre());
            pstm.setString(2, maistrado.getPersona().getPrimeroApellido());
            pstm.setString(3, maistrado.getPersona().getSegundoApellido());
            pstm.setString(4, maistrado.getPersona().getFechaNacimiento());
            pstm.setString(5, maistrado.getPersona().getCurp());
            pstm.setString(6, maistrado.getPersona().getNumeroTrabajador());
            pstm.setInt(7, maistrado.getMunicipio().getIdMunicipio());
            pstm.setInt(8, maistrado.getPersona().getIdPersona());
            
            resultado = pstm.executeUpdate() == 1;
            
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo modificarMagistrado) del daoPersona: " + e.getMessage());
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

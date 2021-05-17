/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.secretariaEstudio;

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
public class DaoSecretaria {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String SQL_CONSULTAR_SECRETARIA="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 5;";
    
    final private String SQL_CONSULTAR_SECRETARIA_ID="SELECT idRol, nombreRol, idPersona, nombre, primeroApellido, segundoApellido," +
"   fechaNacimiento, edad, curp, numeroTrabajador," +
"   idMunicipio, nombreMunicipio FROM usuario inner join persona on pertenecePersona = idPersona" +
"   inner join rol on perteneceRol = idRol inner join municipio on perteneceMunicipio = idMunicipio" +
"   where idRol = 5 and idPersona = ?;";
    
    final private String SQL_MODIFICAR_SECRETARIA="CALL ModificarPersona(?,?,?,?,?,?,?,?);";
    
    final private String SQL_ELIMINAR_PERSONAS="DELETE FROM persona WHERE idPersona = ?;";
    
    public List<BeanSecretaria> consultarSecretarias(){
        List<BeanSecretaria> secretarias = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(SQL_CONSULTAR_SECRETARIA);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                BeanSecretaria secretaria = new BeanSecretaria();
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
                
                
                secretaria.setMunicipio(municipio);
                secretaria.setRol(rol);
                secretaria.setPersona(persona);
                
                secretarias.add(secretaria);
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo CONSULTAR_SECRETARIAS() del DaoPersonas CONSULTAR_SINDICOS: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return secretarias;
    }
    
    public BeanSecretaria consultarSecretariaId(int idPersona){
        BeanSecretaria secretaria = null;
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_SECRETARIA_ID);
            pstm.setInt(1, idPersona);
            rs = pstm.executeQuery();
            if(rs.next()){
                
                BeanPersona persona = new BeanPersona();
                BeanRol rol = new BeanRol();
                secretaria = new BeanSecretaria();
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
                
                
                secretaria.setMunicipio(municipio);
                secretaria.setRol(rol);
                secretaria.setPersona(persona);
               
                
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo SQL_CONSULTAR_SECRETARIA_ID() del daoSindicos: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return secretaria;
    }
    
    public boolean modificarSecreatia(BeanSecretaria secretaria){
        boolean resultado = false;
        try{
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_MODIFICAR_SECRETARIA);

            pstm.setString(1, secretaria.getPersona().getNombre());
            pstm.setString(2, secretaria.getPersona().getPrimeroApellido());
            pstm.setString(3, secretaria.getPersona().getSegundoApellido());
            pstm.setString(4, secretaria.getPersona().getFechaNacimiento());
            pstm.setString(5, secretaria.getPersona().getCurp());
            pstm.setString(6, secretaria.getPersona().getNumeroTrabajador());
            pstm.setInt(7, secretaria.getMunicipio().getIdMunicipio());
            pstm.setInt(8, secretaria.getPersona().getIdPersona());
            
            resultado = pstm.executeUpdate() == 1;
            
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo modificarSecretaria) del daoPersona: " + e.getMessage());
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

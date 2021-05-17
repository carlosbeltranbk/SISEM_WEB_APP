/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.fiscalia;

import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.municipio.BeanMunicipio;
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
public class DaoFiscalia {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String SQL_CONSULTAR_FISCALIAS="SELECT idFiscalia, nombreFiscalia, direccionFiscalia, municipio.idMunicipio, municipio.nombreMunicipio," +
"   persona.idPersona, persona.nombre, persona.primeroApellido, persona.segundoApellido FROM fiscalia inner join municipio" +
"   on fiscalia.municipioFiscalia = municipio.idMunicipio inner join persona on fiscalia.personaFiscalia = persona.idPersona;";
    
    final private String SQL_CONSULTAR_FISCALIAS_ID="SELECT idFiscalia, nombreFiscalia, direccionFiscalia, municipio.idMunicipio, municipio.nombreMunicipio," +
"   persona.idPersona, persona.nombre, persona.primeroApellido, persona.segundoApellido FROM fiscalia inner join municipio" +
"   on fiscalia.municipioFiscalia = municipio.idMunicipio inner join persona on fiscalia.personaFiscalia = persona.idPersona where fiscalia.idFiscalia = ?;";
    
    final private String SQL_REGISTRAR_FISCALIAS= "INSERT INTO fiscalia(nombreFiscalia, direccionFiscalia, municipioFiscalia, personaFiscalia) VALUES (?,?,?,?);";
    
    final private String SQL_MODIFICAR_FISCALIAS="UPDATE fiscalia SET nombreFiscalia = ?, direccionFiscalia = ?, municipioFiscalia = ?, personaFiscalia = ? WHERE fiscalia.idFiscalia = ?;";
    
    final private String SQL_ELIMINAR_FISCALIAS="DELETE FROM fiscalia where fiscalia.idFiscalia = ?;";
    
    public List<BeanFiscalia> consultarFiscalias(){
        List<BeanFiscalia> fiscalias = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(SQL_CONSULTAR_FISCALIAS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanFiscalia fiscalia = new BeanFiscalia();
                BeanPersona persona = new BeanPersona();
                BeanMunicipio municipio = new BeanMunicipio();
                
                fiscalia.setIdFiscalia(rs.getInt("idFiscalia"));
                fiscalia.setNombreFiscalia(rs.getString("nombreFiscalia"));
                fiscalia.setDireccionFiscalia(rs.getString("direccionFiscalia"));
                
                municipio.setIdMunicipio(rs.getInt("idMunicipio"));
                municipio.setNombreMunicipio(rs.getString("nombreMunicipio"));

                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                
                fiscalia.setMunicipio(municipio);
                fiscalia.setPersona(persona);
             
                fiscalias.add(fiscalia);
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo consultarFiscalias() del daoFiscalias: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return fiscalias;
    }
    
    
    public BeanFiscalia consultarFiscaliaId(int idFiscalia){
        BeanFiscalia fiscalia = null;
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_FISCALIAS_ID);
            pstm.setInt(1, idFiscalia);
            rs = pstm.executeQuery();
            if(rs.next()){
                
                fiscalia = new BeanFiscalia();
                BeanMunicipio municipio = new BeanMunicipio();
                BeanPersona persona = new BeanPersona();
                
                
                fiscalia.setIdFiscalia(rs.getInt("idFiscalia"));
                fiscalia.setNombreFiscalia(rs.getString("nombreFiscalia"));
                fiscalia.setDireccionFiscalia(rs.getString("direccionFiscalia"));
                
                municipio.setIdMunicipio(rs.getInt("idMunicipio"));
                municipio.setNombreMunicipio(rs.getString("nombreMunicipio"));

                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPrimeroApellido(rs.getString("primeroApellido"));
                persona.setSegundoApellido(rs.getString("segundoApellido"));
                
                fiscalia.setMunicipio(municipio);
                fiscalia.setPersona(persona);
               
                
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo consultarFiscaliaId() del daoFiscalia: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return fiscalia;
    }
    
    public boolean registrarFiscalia(BeanFiscalia fiscalia){
        boolean resultado = false;
        try{
            conexion =ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_REGISTRAR_FISCALIAS);
            
            pstm.setString(1, fiscalia.getNombreFiscalia());
            pstm.setString(2, fiscalia.getDireccionFiscalia());
            pstm.setInt(3, fiscalia.getMunicipio().getIdMunicipio());
            pstm.setInt(4, fiscalia.getPersona().getIdPersona());

            resultado = pstm.executeUpdate()== 1;
            
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo registrarFiscalia() del daoFiscalia: " + e.getMessage());
        }finally{
            try{
                pstm.close();
                conexion.close();
            }catch(Exception e){
                
            }
        }
        return resultado;
    }
    
    public boolean modificarFiscalia(BeanFiscalia fiscalia){
        boolean resultado = false;
        try{
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_MODIFICAR_FISCALIAS);

            pstm.setString(1, fiscalia.getNombreFiscalia());
            pstm.setString(2, fiscalia.getDireccionFiscalia());
            pstm.setInt(3, fiscalia.getMunicipio().getIdMunicipio());
            pstm.setInt(4, fiscalia.getPersona().getIdPersona());
            pstm.setInt(5, fiscalia.getIdFiscalia());
            
            resultado = pstm.executeUpdate() == 1;
            
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo modificarFiscalia() del daoFiscalia: " + e.getMessage());
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
    
    public boolean eliminarFiscalia(int idFiscalia){
        boolean resultado = false;
        try{
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_ELIMINAR_FISCALIAS);
            pstm.setInt(1, idFiscalia);
            resultado = pstm.executeUpdate() == 1;
            
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo eliminarFiscalia() del daoFiscalia: " + e.getMessage());
        }finally{
            try{
                pstm.close();
                conexion.close();
            }catch(Exception e){
                System.out.println("No se cerraron las conexiones en eliminarFiscalia()"+ e.getMessage());
            }
        }
        return resultado;
    }
    
}

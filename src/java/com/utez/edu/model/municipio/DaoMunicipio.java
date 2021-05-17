/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.municipio;
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
public class DaoMunicipio {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String MYSQL_CONSULTAR_MUNICIPIOS = "SELECT idMunicipio, nombreMunicipio FROM municipio;";
    
    public List<BeanMunicipio> consultarMunicipios(){
        List<BeanMunicipio> municipios = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(MYSQL_CONSULTAR_MUNICIPIOS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanMunicipio municipio = new BeanMunicipio();
                
                municipio.setIdMunicipio(rs.getInt("idMunicipio"));
                municipio.setNombreMunicipio(rs.getString("nombreMunicipio"));
    
                municipios.add(municipio);
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo consultarAudiencias() del DaoAudiencia: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return municipios;
    }
}

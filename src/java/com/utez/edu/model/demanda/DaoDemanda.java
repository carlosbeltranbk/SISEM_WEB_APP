/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.demanda;

import com.utez.edu.model.fiscalia.BeanFiscalia;
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
public class DaoDemanda {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String MYSQL_CONSULTAR_DEMANDAS = "SELECT * FROM demanda inner join municipio on demanda.demandaMunicipio = municipio.idMunicipio;";
    
    public List<BeanDemanda> consultarDemandas(){
        List<BeanDemanda> demandas = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(MYSQL_CONSULTAR_DEMANDAS);
            rs = pstm.executeQuery();
            while(rs.next()){
                
                BeanDemanda demanda = new BeanDemanda();
                BeanMunicipio municipio = new BeanMunicipio();
         
                
                demanda.setIdDemanda(rs.getInt("idDemanda"));
                demanda.setFolio(rs.getString("folio"));
                demanda.setTipoDemanda(rs.getString("tipoDemanda"));
                demanda.setDescripcion(rs.getString("descripcion"));
                
                municipio.setIdMunicipio(rs.getInt("idMunicipio"));
                municipio.setNombreMunicipio(rs.getString("nombreMunicipio"));
                
                demanda.setEstado(rs.getBoolean("estado"));

                demanda.setMunicipio(municipio);

               
                demandas.add(demanda);
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo consultarDemandas() del DaoAudiencia: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return demandas;
    }
    
}

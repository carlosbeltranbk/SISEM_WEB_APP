/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.personaDemanda;

import com.utez.edu.model.demanda.BeanDemanda;
import com.utez.edu.model.persona.BeanPersona;
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
public class DaoPersonaDemanda {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String MYSQL_CONSULTAR_PERSONADEMANDAS = "SELECT * FROM demanda_persona inner join persona on demanda_persona.persona = persona.idPersona" +
"   inner join demanda on demanda_persona.demanda = demanda.idDemanda;";
    
    public List<BeanPersonaDemanda> consultarDemandasPersonas(){
        List<BeanPersonaDemanda> perDemandas = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(MYSQL_CONSULTAR_PERSONADEMANDAS);
            rs = pstm.executeQuery();
            while(rs.next()){
                
                BeanPersonaDemanda pDemanda = new BeanPersonaDemanda();
                BeanDemanda demanda = new BeanDemanda();
                BeanPersona persona = new BeanPersona();
                
                pDemanda.setEstado(rs.getBoolean("estado"));
                
                demanda.setIdDemanda(rs.getInt("idDemanda"));
                demanda.setFolio(rs.getString("folio"));
                
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPrimeroApellido(rs.getString("primeroApellido"));
                persona.setSegundoApellido(rs.getString("segundoApellido"));
                
               
                pDemanda.setIdDemanda(demanda);
                pDemanda.setIdPersona(persona);
                perDemandas.add(pDemanda);
            }
            rs.close();
            pstm.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en metodo consultarDemandasdePersonas() del DaoAudiencia: " + e.getMessage());
        }finally{
            try{
            rs.close();
            pstm.close();
            conexion.close();
            }catch(Exception e){
                
            }
        }
        return perDemandas;
    }
    
}

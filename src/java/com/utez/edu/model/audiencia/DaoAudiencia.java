/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.audiencia;
import com.utez.edu.model.usuario.BeanUsuario;
import com.utez.edu.model.demanda.BeanDemanda;
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
public class DaoAudiencia {
    
    private final ConexionMySQL singletonConexion = ConexionMySQL.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String MYSQL_CONSULTAR_AUDIENCIAS = "SELECT idAudiencia, dia, hora, usuario.idUsuario, usuario.correo, demanda.idDemanda, demanda.tipoDemanda" +
    " FROM audiencia inner join usuario on audiencia.audienciaUsuario = usuario.idUsuario inner join" +
    " demanda on audiencia.audienciaDemanda = demanda.idDemanda;";
    
    public List<BeanAudiencia> consultarAudiencias(){
        List<BeanAudiencia> audiencias = new ArrayList();
        try{
            conexion = ConexionMySQL.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            //pstm = conexion.prepareStatement("{call pa_consultar_dulce}");
            pstm = conexion.prepareStatement(MYSQL_CONSULTAR_AUDIENCIAS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanAudiencia audiencia = new BeanAudiencia();
                BeanUsuario usuario = new BeanUsuario();
                BeanDemanda demanda = new BeanDemanda();
                
                audiencia.setIdAudiencia(rs.getInt("idAudiencia"));
                audiencia.setDia(rs.getString("dia"));
                audiencia.setHora(rs.getString("hora"));

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setCorreo(rs.getString("correo"));
                
                demanda.setIdDemanda(rs.getInt("idDemanda"));
                demanda.setTipoDemanda(rs.getString("tipoDemanda"));

                audiencia.setUsuario(usuario);
                audiencia.setDemanda(demanda);
                
                audiencias.add(audiencia);
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
        return audiencias;
    }
}

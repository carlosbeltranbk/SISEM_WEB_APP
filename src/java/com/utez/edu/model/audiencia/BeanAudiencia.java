/*
 * Esta clase define todas las variables para usar de la tabla Sindico Municipal
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.model.audiencia;

import com.utez.edu.model.demanda.BeanDemanda;
import com.utez.edu.model.usuario.BeanUsuario;

/**
 *
 * @author BELTRAN PC
 */
public class BeanAudiencia {
    
    /**
     * Bean con las varibles necesarias.
     */
    
    private int idAudiencia;
    private String dia;
    private String hora;
    private BeanUsuario usuario;
    private BeanDemanda demanda;

    
    /**
     * 
     * @param idAudiencia Variable de la tabla Audiencia / primary key
     * 
     * @param dia Variable de la tabla Audiencia / dia de la audiencia
     * 
     * @param hora Variable de la tabla Audiencia / hora de la ""
     * 
     * @param usuario Variable de la tabla Audiencia / usuario relacionado a la audiencia
     * 
     * @param demanda  Variable de la tabla Audiencia / el tipo de demanda
     * 
     */
    public BeanAudiencia(int idAudiencia, String dia, String hora, BeanUsuario usuario, BeanDemanda demanda) {
        this.idAudiencia = idAudiencia;
        this.dia = dia;
        this.hora = hora;
        this.usuario = usuario;
        this.demanda = demanda;
    }
    
    /**
     * Contrustctor vacío
     */
    public BeanAudiencia(){
        
    }
    
    /**
     * Getters & Setters de las variables declaradas
     * @return 
     */

    public int getIdAudiencia() {
        return idAudiencia;
    }

    public void setIdAudiencia(int idAudiencia) {
        this.idAudiencia = idAudiencia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public BeanUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(BeanUsuario usuario) {
        this.usuario = usuario;
    }

    public BeanDemanda getDemanda() {
        return demanda;
    }

    public void setDemanda(BeanDemanda demanda) {
        this.demanda = demanda;
    }  
}

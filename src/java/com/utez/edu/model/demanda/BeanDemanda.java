/*
 * Esta clase define todas las variables para usar de la tabla Sindico Municipal
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.model.demanda;

import com.utez.edu.model.fiscalia.BeanFiscalia;
import com.utez.edu.model.municipio.BeanMunicipio;

/**
 *
 * @author BELTRAN PC
 */
public class BeanDemanda {
    
    /**
     * Variables necesarias para el bean
     */
    
    private int idDemanda;
    private String folio;
    private String tipoDemanda;
    private String descripcion;
    private BeanMunicipio municipio;
    private Boolean estado;
    private BeanFiscalia fiscalia;

    /**
     * 
     * @param idDemanda Varibale de la tabla Demandna / primary key
     * 
     * @param folio Varibale de la tabla Demandna / folio de la demanda
     * 
     * @param tipoDemanda Varibale de la tabla Demandna / el tipo de la demanda
     * 
     * @param descripcion Varibale de la tabla Demandna / la descripcion de la demanda
     * 
     * @param municipio Varibale de la tabla Demandna / municipio donde se generó
     * 
     * @param estado Varibale de la tabla Demandna / está de la demanda (activo/inactivo)
     * 
     * @param fiscalia  Varibale de la tabla Demandna / fiscalia relacionada a los hechos
     * 
     */
    public BeanDemanda(int idDemanda, String folio, String tipoDemanda, String descripcion, BeanMunicipio municipio, Boolean estado, BeanFiscalia fiscalia) {
        this.idDemanda = idDemanda;
        this.folio = folio;
        this.tipoDemanda = tipoDemanda;
        this.descripcion = descripcion;
        this.municipio = municipio;
        this.estado = estado;
        this.fiscalia = fiscalia;
    }
    
    /**
     * Constructor vacío
     */
    public BeanDemanda() {
    }

    public int getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(int idDemanda) {
        this.idDemanda = idDemanda;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTipoDemanda() {
        return tipoDemanda;
    }

    public void setTipoDemanda(String tipoDemanda) {
        this.tipoDemanda = tipoDemanda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BeanMunicipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(BeanMunicipio municipio) {
        this.municipio = municipio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BeanFiscalia getFiscalia() {
        return fiscalia;
    }

    public void setFiscalia(BeanFiscalia fiscalia) {
        this.fiscalia = fiscalia;
    } 
}

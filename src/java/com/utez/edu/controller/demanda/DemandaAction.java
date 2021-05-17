/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.demanda;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;

import com.utez.edu.model.demanda.BeanDemanda;
import com.utez.edu.model.demanda.DaoDemanda;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.municipio.DaoMunicipio;

import com.utez.edu.model.fiscalia.BeanFiscalia;
import com.utez.edu.model.fiscalia.DaoFiscalia;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author BELTRAN PC
 */
public class DemandaAction {
    
    private BeanDemanda beanDemanda = new BeanDemanda();
    private DaoDemanda daoDemanda = new DaoDemanda();
    private List<BeanDemanda> listaDemandas = new ArrayList();
    
    private List<BeanMunicipio> listaMunicipios = new ArrayList();
    private List<BeanFiscalia> listaFiscalias = new ArrayList();
    
    private String mensaje;

    public BeanDemanda getBeanDemanda() {
        return beanDemanda;
    }

    public void setBeanDemanda(BeanDemanda beanDemanda) {
        this.beanDemanda = beanDemanda;
    }

    public List<BeanDemanda> getListaDemandas() {
        return listaDemandas;
    }

    public void setListaDemandas(List<BeanDemanda> listaDemandas) {
        this.listaDemandas = listaDemandas;
    }

    public List<BeanMunicipio> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaMunicipios(List<BeanMunicipio> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public List<BeanFiscalia> getListaFiscalias() {
        return listaFiscalias;
    }

    public void setListaFiscalias(List<BeanFiscalia> listaFiscalias) {
        this.listaFiscalias = listaFiscalias;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    /* ----------------- METODOS ---------------------- */
    
    /**
     * 
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarDemandas() {
        listaDemandas = daoDemanda.consultarDemandas();
        return SUCCESS;
    }
    
}

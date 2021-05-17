/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.personaDemanda;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;

import com.utez.edu.model.personaDemanda.BeanPersonaDemanda;
import com.utez.edu.model.personaDemanda.DaoPersonaDemanda;

import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.persona.DaoPersona;

import com.utez.edu.model.demanda.BeanDemanda;
import com.utez.edu.model.demanda.DaoDemanda;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author BELTRAN PC
 */
public class PersonaDemandaAction {
    
    private BeanPersonaDemanda beanPersonaDemanda = new BeanPersonaDemanda();
    private DaoPersonaDemanda daoPersonaDemanda = new DaoPersonaDemanda();
    private List<BeanPersonaDemanda> listaPersonaDemanas = new ArrayList();
    
    private List<BeanPersona> listaPersona = new ArrayList();
    private List<BeanDemanda> listaDemandas = new ArrayList();
    
    private String mensaje;

    public BeanPersonaDemanda getBeanPersonaDemanda() {
        return beanPersonaDemanda;
    }

    public void setBeanPersonaDemanda(BeanPersonaDemanda beanPersonaDemanda) {
        this.beanPersonaDemanda = beanPersonaDemanda;
    }

    public List<BeanPersonaDemanda> getListaPersonaDemanas() {
        return listaPersonaDemanas;
    }

    public void setListaPersonaDemanas(List<BeanPersonaDemanda> listaPersonaDemanas) {
        this.listaPersonaDemanas = listaPersonaDemanas;
    }

    public List<BeanPersona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<BeanPersona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public List<BeanDemanda> getListaDemandas() {
        return listaDemandas;
    }

    public void setListaDemandas(List<BeanDemanda> listaDemandas) {
        this.listaDemandas = listaDemandas;
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
    public String consultarPersonaDemanda() {
        listaPersonaDemanas = daoPersonaDemanda.consultarDemandasPersonas();
        return SUCCESS;
    }
    
}

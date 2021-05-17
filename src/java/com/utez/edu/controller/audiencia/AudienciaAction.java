/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.audiencia;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;

import com.utez.edu.model.audiencia.BeanAudiencia;
import com.utez.edu.model.audiencia.DaoAudiencia;

import com.utez.edu.model.usuario.BeanUsuario;
import com.utez.edu.model.usuario.DaoUsuario;

import com.utez.edu.model.demanda.BeanDemanda;
import com.utez.edu.model.demanda.DaoDemanda;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author BELTRAN PC
 */
public class AudienciaAction {
    
    private BeanAudiencia beanAudiencia = new BeanAudiencia();
    private DaoAudiencia daoAudiencia = new DaoAudiencia();
    private List<BeanAudiencia> listaAudiencias = new ArrayList();
    
    private List<BeanUsuario> listaUsuarios = new ArrayList();
    private List<BeanDemanda> listaDemandas = new ArrayList();
    
    private String mensaje;

    public BeanAudiencia getBeanAudiencia() {
        return beanAudiencia;
    }

    public void setBeanAudiencia(BeanAudiencia beanAudiencia) {
        this.beanAudiencia = beanAudiencia;
    }

    public List<BeanAudiencia> getListaAudiencias() {
        return listaAudiencias;
    }

    public void setListaAudiencias(List<BeanAudiencia> listaAudiencias) {
        this.listaAudiencias = listaAudiencias;
    }

    public List<BeanUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<BeanUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
    public String consultarAudiencias() {
        listaAudiencias = daoAudiencia.consultarAudiencias();
        return SUCCESS;
    }
    
}
